plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    implementation("org.testng:testng:7.10.2")
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
    implementation("log4j:log4j:1.2.17")



}

tasks.test {
    useTestNG()
}