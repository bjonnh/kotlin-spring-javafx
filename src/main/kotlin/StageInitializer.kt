package net.nprod.napfx

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.util.Callback
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import java.io.IOException


@Component
class StageInitializer(
    @param:Value("\${spring.application.ui.title}") private val applicationTitle: String,
    private val applicationContext: ApplicationContext
) : ApplicationListener<StageReadyEvent> {
    @Value("classpath:/test.fxml")
    private val chartResource: Resource? = null

    override fun onApplicationEvent(event: StageReadyEvent) {
        try {
            val fxmlLoader = FXMLLoader(chartResource!!.url)
            fxmlLoader.controllerFactory = Callback { aClass: Class<*> ->
                applicationContext.getBean(
                    aClass
                )
            }
            val parent = fxmlLoader.load<Parent>()
            val stage = event.getStage()
            stage.scene = Scene(parent, 800.0, 600.0)
            stage.title = applicationTitle
            stage.show()
        } catch (e: IOException) {
            throw RuntimeException()
        }
    }

}
