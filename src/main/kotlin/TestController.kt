package net.nprod.napfx

import javafx.fxml.FXML
import javafx.scene.control.Button
import org.springframework.stereotype.Component

@Component
class TestController {
    @FXML
    lateinit var button: Button

    @FXML
    fun initialize() {

    }

}