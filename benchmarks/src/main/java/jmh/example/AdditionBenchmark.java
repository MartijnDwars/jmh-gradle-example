package jmh.example;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import static java.util.concurrent.TimeUnit.SECONDS;

@Warmup(iterations = 5, time = 1, timeUnit = SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = SECONDS)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class AdditionBenchmark {
    int[] numbers;

    @Param({"100", "1000", "10000"})
    public int size;

    @Setup
    public void setup() {
        Random random = new Random();
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(10);
        }
    }

    @Benchmark
    public long addLoop() {
        return Library.addLoop(numbers);
    }

    @Benchmark
    public long addStream() {
        return Library.addStream(numbers);
    }
}
