import java.net.URI

plugins {
  kotlin("jvm") version "1.8.21"
  kotlin("plugin.serialization") version "1.8.21"
  id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
  id("io.gitlab.arturbosch.detekt") version "1.23.0"
  `maven-publish`
  publishing
  signing
}

group = "com.openpix"
version = "0.0.18-SNAPSHOT"

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
  testImplementation("org.assertj:assertj-core:3.24.2")
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

val isReleaseVersion = !version.toString().endsWith("SNAPSHOT")

configure<PublishingExtension> {
  publications {
    create<MavenPublication>("OSSRH") {
      groupId = project.group.toString()
      artifactId = project.name
      version = project.version.toString()
      from(components["java"])

      pom {
        name.set(project.name)
        description.set(project.description)
        url.set("https://github.com/Open-Pix/java-sdk")
        inceptionYear.set("2023")

        licenses {
          license {
            name.set("MIT")
            url.set("https://github.com/Open-Pix/java-sdk/blob/main/LICENSE")
          }
        }

        developers {
          developer {
            name.set("Woovi Developers")
            email.set("developers@woovi.com")
            url.set("https://github.com/Open-Pix/java-sdk")
          }
        }

        scm {
          connection.set("scm:git:git:github.com/Open-Pix/java-sdk.git")
          developerConnection.set("scm:git:https://github.com/Open-Pix/java-sdk.git")
          url.set("https://github.com/Open-Pix/java-sdk")
        }
      }
    }
  }

  repositories {
    maven("OSSRH") {
      name = "OSSRH"
      url = if (isReleaseVersion) {
        uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
      } else {
        uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
      }

      credentials {
        username = project.findProperty("ossrhUsername")?.toString() ?: System.getenv("OSSRH_USERNAME")
        password = project.findProperty("ossrhPassword")?.toString() ?: System.getenv("OSSRH_PASSWORD")
      }
    }
  }
}

configure<SigningExtension> {
  isRequired = isReleaseVersion
  useInMemoryPgpKeys(
    project.findProperty("signing.keyId")?.toString() ?: System.getenv("OSSRH_SIGNING_KEY")?.replace("\\n", "\n"),
    project.findProperty("signing.password")?.toString() ?: System.getenv("OSSRH_SIGNING_PASSWORD"),
  )
  sign(extensions.getByType(PublishingExtension::class.java).publications.getByName("OSSRH"))
}
