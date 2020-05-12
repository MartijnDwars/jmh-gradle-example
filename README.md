# Example using JMH with Gradle

An example project that uses JMH with Gradle, but without [melix/jmh-gradle-plugin](https://github.com/melix/jmh-gradle-plugin).

## Usage

First, build a shadowJar of the project and benchmarks:

```
./gradlew clean :benchmark:shadowJar
```

Then run the benchmarks:

```
java -jar benchmarks/build/libs/benchmarks.jar
```
