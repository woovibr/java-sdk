# OpenPix/Woovi Java SDK

Welcome to the Woovi Java SDK! This SDK provides convenient access to the Woovi REST API, allowing you to easily integrate payment services into your Java applications.

## Documentation

See [SDK documentation](https://developers.openpix.com.br/docs/sdk/java/java-sdk-what-is) and [Rest API documentation](https://developers.openpix.com.br/api).

How do I use it? You can have a look in the following example:

## Installation

### Publishing to Maven Local

Publishing to maven local, is a step to make the projects accessible from another projects. To make it you can execute
the following commands in the cli:

```bash
$ ./gradlew publishToMavenLocal
```

or if you are in a Windows environment, you can do the following

```pwsh
.\gradlew.bat publishToMavenLocal
```

#### Adding to you project

You can use the locally published library for that, so follow the [tutorial](#publishing-to-maven-local), and add the following
code snippet to you gradle buildscript:

```groovy
repositories {
  mavenLocal()
}

dependencies {
    implementation('com.openpix:sdk-java:0.0.11')
}
```

### Consuming from Sonatype

You can add the library to the project with the maven local, or with github packages, to get from Sonatype registry, you can
use the following snippet:

```groovy
repositories {
  mavenCentral()
}

dependencies {
  implementation('com.openpix:sdk-java:0.0.11')
}
```

## Basic usage

Here is the basic usage of the SDK. See [SDK documentation](https://developers.openpix.com.br/docs/sdk/java/java-sdk-usage) for more details.

#### Java:

```java
package com.openpix;

import com.openpix.sdk.ChargeBuilder;
import com.openpix.sdk.WooviSDK;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        WooviSDK sdk = new WooviSDK("YOUR-API-ID-HERE");

        try {
            ChargeBuilder charge = new ChargeBuilder()
                .value(100)
                .correlationID("2d296a52-360d-11ee-be56-0242ac120002");

            System.out.println(sdk.createChargeAsync(charge).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
```

#### Kotlin:

```kotlin
import com.openpix.sdk.WooviSDK
import com.openpix.sdk.getSubscription

suspend fun main() {
  val sdk = WooviSDK(appId = "YOUR-API-ID-HERE")
  println(sdk.getSubscription("id.."))
}
```

## Contributing

If you have suggestions for how OpenPix PHP SDK could be improved, or want to report a bug, open an issue! We'd love all and any contributions.

For more, check out the [Contributing Guide](CONTRIBUTING.md).

## License

OpenPix Java SDK is distributed under the terms of the [MIT license](LICENSE).
