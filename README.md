# Lord of the rings SDK

LOTR API

- API version: 1.0.0
    - Build date: 2022-07-19T15:04:09.670Z[GMT]

You can use this api to retrieve lotr information.

## Requirements

Building the API client library requires:

1. Java 18+
2. Maven

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

### Maven users

Add this dependency to your project's POM:

```xml

<dependency>
    <groupId>org.liblab</groupId>
    <artifactId>lord-of-the-rings-sdk</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.liblab:lord-of-the-rings-sdk:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/lord-of-the-rings-sdk-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import org.liblab.client.Configuration;
import org.liblab.client.api.LotrApi;
import org.liblab.client.model.*;

public class DefaultApiExample {

  public static void main(String[] args) {
    final var accessToken = "TOKEN";
    final LotrApi api = new LotrApi(new Configuration().setAccessToken(accessToken));
    try {
      Book result = api.getBooks().getData().get(0);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getBooks");
      e.printStackTrace();
    }
  }
}
```

## Documentation for Authorization

Authentication schemes defined for the API:

### bearerAuth

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential
issues.

## Author

tenaz3.comp@gmail.com


## TODO

* Pagination
  * limit 
  * page
  * offset
* Sort
* Aggregate calls in a generic response data