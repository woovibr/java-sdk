import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.8.21"
  kotlin("plugin.serialization") version "1.8.21"
  id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
  id("io.gitlab.arturbosch.detekt") version "1.19.0"
}

group = "br.com.openpix"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.ktor:ktor-client-core:2.3.2")
  implementation("io.ktor:ktor-client-cio:2.3.2")
  implementation("io.ktor:ktor-client-logging:2.3.2")
  implementation("io.ktor:ktor-client-content-negotiation:2.3.2")
  implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.2")
  implementation("io.ktor:ktor-client-cio-jvm:2.3.2")
  implementation("io.ktor:ktor-client-auth:2.3.2")

  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

ktlint {
  version.set("0.45.2")
  android.set(false)
  additionalEditorconfigFile.set(rootProject.file(".editorconfig"))
}

detekt {
  buildUponDefaultConfig = true
  allRules = false

  config = files("${rootProject.projectDir}/config/detekt.yml")
  baseline = file("${rootProject.projectDir}/config/baseline.xml")
}

kotlin {
  jvmToolchain(8)
  explicitApi()

  sourceSets {
    all {
      languageSettings {
        optIn("kotlin.RequiresOptIn")
        optIn("kotlin.contracts.ExperimentalContracts")
      }
    }
  }
}

tasks.test {
  useJUnitPlatform()
}
