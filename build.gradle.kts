plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.31")
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.appium:java-client:7.0.0")
    implementation("org.seleniumhq.selenium:selenium-java:3.13.0")
    implementation("junit:junit:4.12")
    implementation("io.github.cdimascio:java-dotenv:5.1.1")
    testImplementation("io.cucumber:cucumber-java8:3.0.2")
    testImplementation("io.cucumber:cucumber-junit:3.0.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
