plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.testng:testng:7.10.2")

}

tasks.test {
    useTestNG()
}