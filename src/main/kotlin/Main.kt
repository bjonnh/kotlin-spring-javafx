package net.nprod.napfx

import javafx.application.Application
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class NapFXApplication

fun main(args: Array<String>) {
    Application.launch(JFXApplication::class.java, *args)
}