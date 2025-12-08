plugins {
    val kotlinVersion = project.property("kotlin_version") as String
    val loomVersion = project.property("loom_version") as String
    
    kotlin("jvm") version kotlinVersion
    id("fabric-loom") version loomVersion
}

group = "tech.sethi.pebbles.pokeplushie"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.terraformersmc.com/") // Optional: for modmenu, rei, etc.
    maven("https://maven.shedaniel.me/") // Optional: for rei, cloth config
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.1")
    mappings("net.fabricmc:yarn:1.21.1+build.2:v2")
    modImplementation("net.fabricmc:fabric-loader:0.16.7")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.103.0+1.21.1")

    implementation(kotlin("stdlib"))
}

tasks {
    jar {
        from("src/main/resources")
    }
    
    // Add these common Fabric tasks if needed
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }
    
    java {
        withSourcesJar()
    }
}