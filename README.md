# OpenPix/Woovi Java SDK

Welcome to the Woovi Java SDK! This SDK provides convenient access to the Woovi REST API, allowing you to easily integrate Woovi's video upload and management services into your Java applications.

## Docs

How do I use it? You can have a look in the following example:

```java,no
package br.com.openpix;

import br.com.openpix.sdk.WooviSDK;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        WooviSDK sdk = new WooviSDK(System.getenv("APP_ID"));

        try {
            System.out.println(sdk.allPixQrCodesAsync().get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
```

You can use it with Kotlin too, as it is written in Kotlin:

```kotlin
import br.com.openpix.sdk.WooviSDK
import br.com.openpix.sdk.getSubscription

suspend fun main() {
  val sdk = WooviSDK(appId = System.getenv("APP_ID"))
  println(sdk.getSubscription("id.."))
}
```

## Consuming from GitHub Packages

You can add the library to the project with the maven local, or with github packages, to get from github packages registry, you can
use the following snippet:

```groovy
repositories {
  maven("https://maven.pkg.github.com/Open-Pix/java-sdk")
}

dependencies {
  implementation('br.com.openpix:sdk-java:0.0.1')
}
```

## Publishing to Maven Local

Publishing to maven local, is a step to make the projects accessible from another projects. To make it you can execute
the following commands in the cli:

```bash
$ ./gradlew publishMavenPublicationToMavenLocal
```

or if you are in a Windows environment, you can do the following

```pwsh
.\gradlew.bat publishMavenPublicationToMavenLocal
```

## Adding to you project

You can use the locally published library for that, so follow the [tutorial](#publishing-to-maven-local), and add the following
code snippet to you gradle buildscript:

```groovy
repositories {
  mavenLocal()
}

dependencies {
  implementation('br.com.openpix:sdk-java:0.0.1')
}
```

## Contributing

We welcome contributions to the Woovi Java SDK! If you would like to contribute, please follow these steps:

- Fork the repository
- Create a new branch for your feature or bug fix
- Write your code and tests
- Commit your changes and push your branch to GitHub
- Submit a pull request

Please make sure to adhere to the [code of conduct](#code-of-conduct).

## Code of Conduct

Our Pledge
We pledge to make participation in our project and our community a harassment-free experience for everyone, regardless of age, body size, disability, ethnicity, gender identity and expression, level of experience, nationality, personal appearance, race, religion, or sexual identity and orientation.

Our Standards
Examples of behavior that contributes to creating a positive environment include:

Using welcoming and inclusive language
Being respectful of differing viewpoints and experiences
Gracefully accepting constructive criticism
Focusing on what is best for the community
Showing empathy towards other community members
Examples of unacceptable behavior by participants include:

The use of sexualized language or imagery and unwelcome sexual attention or advances
Trolling, insulting/derogatory comments, and personal or political attacks
Public or private harassment
Publishing others' private information, such as a physical or electronic address, without explicit permission
Other conduct which could reasonably be considered inappropriate in a professional setting
Our Responsibilities
As project maintainers, we are responsible for clarifying the standards of acceptable behavior and are expected to take appropriate and fair corrective action in response to any instances of unacceptable behavior.

As contributors, you have the responsibility to adhere to these standards and report any instances of unacceptable behavior.

Enforcement
Instances of abusive, harassing, or otherwise unacceptable behavior may be reported to the project team at <developers@woovi.com>. The project team will review and investigate all complaints and will respond in a way that it deems appropriate to the circumstances. The project team is obligated to maintain confidentiality with regard to the reporter of an incident. Further details of specific enforcement policies may be posted separately.

Project maintainers who do not follow or enforce the code of conduct in good faith may face temporary or permanent repercussions as determined by other members of the project's leadership.

Attribution
This Code of Conduct is adapted from the Contributor Covenant, version 1.4, available at http://contributor-covenant.org/version/1/4.

## License

MIT License.
