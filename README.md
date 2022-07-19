# swagger-java-client

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

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        
        DefaultApi apiInstance = new DefaultApi();
        try {
            BookResponse result = apiInstance.getBooks();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getBooks");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();


        DefaultApi apiInstance = new DefaultApi();
        String _id = "_id_example"; // String | 
        try {
            CharacterResponse result = apiInstance.getCharacter(_id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getCharacter");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *https://the-one-api.dev/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**getBooks**](docs/DefaultApi.md#getBooks) | **GET** /book | 
*DefaultApi* | [**getCharacter**](docs/DefaultApi.md#getCharacter) | **GET** /character | 

## Documentation for Models

 - [Book](docs/Book.md)
 - [BookResponse](docs/BookResponse.md)
 - [Character](docs/Character.md)
 - [CharacterResponse](docs/CharacterResponse.md)
 - [InlineResponse401](docs/InlineResponse401.md)
 - [OneOfCharacterBirth](docs/OneOfCharacterBirth.md)
 - [OneOfCharacterDeath](docs/OneOfCharacterDeath.md)

## Documentation for Authorization

Authentication schemes defined for the API:
### bearerAuth



## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

tenaz3.comp@gmail.com
