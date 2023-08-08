import java.net.URI

plugins {
  kotlin("jvm") version "1.8.21"
  kotlin("plugin.serialization") version "1.8.21"
  id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
  id("io.gitlab.arturbosch.detekt") version "1.23.0"
  `maven-publish`
  publishing
}

group = "br.com.openpix"
version = "0.0.3"

repositories {
  mavenCentral()
  mavenLocal()
}

dependencies {
  api("io.ktor:ktor-client-core:2.3.2")
  api("io.ktor:ktor-client-cio:2.3.2")
  api("io.ktor:ktor-client-logging:2.3.2")
  api("io.ktor:ktor-client-content-negotiation:2.3.2")
  api("io.ktor:ktor-serialization-kotlinx-json:2.3.2")
  api("io.ktor:ktor-client-cio-jvm:2.3.2")
  api("io.ktor:ktor-client-auth:2.3.2")

  api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.7.2")

  testImplementation("io.ktor:ktor-client-mock:2.3.2")
  testImplementation("io.mockk:mockk:1.13.5")
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
val sources by tasks.registering(Jar::class) {
  archiveBaseName.set(project.name)
  archiveClassifier.set("sources")
  archiveVersion.set(project.version.toString())
  from(sourceSets.main.get().allSource)
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["java"])
      artifact(sources.get())
    }
  }
  repositories {
    maven {
      name = "GitHubPackages"
      url = URI.create("https://maven.pkg.github.com/Open-Pix/java-sdk")
      credentials {
        username = System.getenv("GITHUB_ACTOR")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}

tasks.test {
  useJUnitPlatform()
}
