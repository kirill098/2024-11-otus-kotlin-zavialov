rootProject.name = "2024-11-otus-kotlin-zavialov"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion
    }
}

include("hw1")