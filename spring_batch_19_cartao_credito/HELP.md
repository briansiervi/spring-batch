# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.springbatch.fatura-cartao-credito-job' is invalid and this project uses 'com.springbatch.fatura_cartao_credito_job' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.9/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.9/maven-plugin/build-image.html)
* [Spring Batch](https://docs.spring.io/spring-boot/3.3.9/how-to/batch.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

