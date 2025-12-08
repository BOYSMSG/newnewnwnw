plugins {
    kotlin("jvm") version "1.9.22"
    id("fabric-loom") version "1.7.4"
}

group = "tech.sethi.pebbles.pokeplushie"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
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
}