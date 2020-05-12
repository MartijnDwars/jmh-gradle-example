package jmh.example;

import java.util.Arrays;

public class Library {

  public static long addLoop(int[] numbers) {
    long accumulator = 0;
    for (int number : numbers) {
      accumulator += number;
    }
    return accumulator;
  }

  public static long addStream(int[] numbers) {
    return Arrays.stream(numbers).sum();
  }
}
