import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val allureVersion = "2.24.0"

dependencies {
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    implementation("org.testng:testng:7.4.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
    implementation ("org.apache.logging.log4j:log4j-api:2.17.1")
    implementation ("org.apache.logging.log4j:log4j-core:2.17.1")
    implementation("io.qameta.allure:allure-testng:2.18.1")


}

tasks.test {
    useTestNG() {
        suites("src/test/resources/tests.xml")

    }

}

tasks.register("updateConfig") {
    val browser = System.getenv("Browser")
    println("Value browser is " + browser)
    val configFile = file("config.properties")
    val properties = Properties()

    if (configFile.exists()) {
        FileInputStream(configFile).use { input ->
            properties.load(input)
        }

        properties.setProperty("BROWSER", browser)

        // Save the updated properties back to the file
        FileOutputStream(configFile).use { output ->
            properties.store(output, "Updated by Gradle")
        }
    }
}