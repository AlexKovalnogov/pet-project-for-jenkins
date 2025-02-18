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
    implementation("log4j:log4j:1.2.17")
    // Import allure-bom to ensure correct versions of all the dependencies are used
   // testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    // Add necessary Allure dependencies to dependencies section
    implementation("io.qameta.allure:allure-testng:2.18.1")





}

tasks.test {
    useTestNG(){

    }

}

tasks.register("customtask") {
    println("Version: ${allureVersion}")
    }