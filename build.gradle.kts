plugins {
    kotlin("jvm") apply false
}

group = "ru.otus.kotlin.zavialov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    group = rootProject.group
    version = rootProject.version
    repositories {
        mavenCentral()
    }
}
