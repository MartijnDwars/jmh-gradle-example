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

Running this on Oracle Java 1.8.0 u251:

```
Benchmark                    (size)  Mode  Cnt      Score      Error  Units
AdditionBenchmark.addLoop       100  avgt   20     32.703 ±    5.149  ns/op
AdditionBenchmark.addLoop      1000  avgt   20    326.507 ±   95.740  ns/op
AdditionBenchmark.addLoop     10000  avgt   20   2751.446 ±   30.586  ns/op
AdditionBenchmark.addStream     100  avgt   20    304.372 ±   56.959  ns/op
AdditionBenchmark.addStream    1000  avgt   20   2614.029 ±  440.807  ns/op
AdditionBenchmark.addStream   10000  avgt   20  23403.941 ± 1006.349  ns/op
```

Running this on GraalVM EE 19.3.1:

```
Benchmark                    (size)  Mode  Cnt     Score     Error  Units
AdditionBenchmark.addLoop       100  avgt   20    14.577 ±   1.583  ns/op
AdditionBenchmark.addLoop      1000  avgt   20   123.712 ±  17.867  ns/op
AdditionBenchmark.addLoop     10000  avgt   20  1419.690 ± 189.796  ns/op
AdditionBenchmark.addStream     100  avgt   20    63.078 ±   0.376  ns/op
AdditionBenchmark.addStream    1000  avgt   20   549.273 ±   7.554  ns/op
AdditionBenchmark.addStream   10000  avgt   20  5377.951 ±  33.166  ns/op
```
