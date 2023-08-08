# OpenPix/Woovi Java SDK

Welcome to the Woovi Java SDK! This SDK provides convenient access to the Woovi REST API, allowing you to easily integrate Woovi's video upload and management services into your Java applications.

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

### Adding to you project

You can use the locally published library for that, so follow the [tutorial](#publishing-to-maven-local), and add the following
code snippet to you gradle buildscript:

```groovy
repositories {
  mavenLocal()
}

dependencies {
  implementation('br.com.openpix:sdk-woovi-java:1.0.0')
}
```

## Basic usage

Here is the basic usage of the SDK. See [SDK documentation](https://developers.openpix.com.br/docs/sdk/java/java-sdk-usage) for more details.

```java
package br.com.openpix;

import br.com.openpix.sdk.ChargeBuilder;
import br.com.openpix.sdk.WooviSDK;

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

## Contributing

If you have suggestions for how OpenPix PHP SDK could be improved, or want to report a bug, open an issue! We'd love all and any contributions.

For more, check out the [Contributing Guide](CONTRIBUTING.md).

## License

OpenPix Java SDK is distributed under the terms of the [MIT license](LICENSE).
