import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx")
        jcenter()
    }
}


repositories {
    mavenCentral()
    jcenter()
    maven("https://repo.spring.io/milestone")
    maven("https://repo.spring.io/snapshot")
}

plugins {
    kotlin("jvm") version "1.3.61"
    id("org.openjfx.javafxplugin") version "0.0.8"

    id("org.springframework.boot") version "2.3.0.BUILD-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("plugin.spring") version "1.3.61"
    kotlin("plugin.jpa") version "1.3.61"
}

group = "net.nprod"
version = "0.0.1"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.openjfx:javafx-graphics:13.0.1:win")
    implementation("org.openjfx:javafx-graphics:13.0.1:linux")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

javafx {
    version = "13"
    modules("javafx.controls", "javafx.fxml")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-Xuse-experimental=kotlin.Experimental", "-Xjsr305=strict")
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}

