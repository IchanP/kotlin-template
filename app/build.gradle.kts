/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.6/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Kotlin test library
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.0")

    // Kotlin JUnit 5 integration
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.9.0")

    // JUnit 5 engine
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    // Use the kotlin standar dlibrary for linting
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.3")
}

ktlint {
    verbose.set(true)
    android.set(false)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN) // Output to terminal
    }
}

detekt {
    toolVersion = "1.23.3"
    buildUponDefaultConfig = true // Use default Detekt config
}

application {
    // Define the main class for the application.
    mainClass.set("app.AppClassKt")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(20))
    }
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(20))
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.named("build") {
    dependsOn("detekt")
}
