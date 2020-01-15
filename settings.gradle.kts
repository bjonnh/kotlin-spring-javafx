rootProject.name = "NapFX"

pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://kotlin.bintray.com/kotlinx")
        jcenter()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "kotlin-multiplatform" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
                "kotlinx-serialization" -> useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
                "org.springframework.boot" -> useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
            }
        }
    }
}

