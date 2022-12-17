package pl.pjatk.zjazd5;

import java.util.stream.IntStream;

public class SomethingToTest {

    public Integer findTheLowestNumberWhichIsDivisorOfGivenNumbers(Integer a, Integer b, Integer c) {
        return IntStream.range(1, Integer.MAX_VALUE)
                .filter(i -> i % a == 0)
                .filter(i -> i % b == 0)
                .filter(i -> i % c == 0)
                .findFirst()
                .orElse(0);
    }

    public Integer findFifthLowestNumberWhichIsDivisorOfGivenNumbers(Integer a, Integer b, Integer c) {
        return IntStream.range(1, Integer.MAX_VALUE)
                .filter(i -> i % a == 0)
                .filter(i -> i % b == 0)
                .filter(i -> i % c == 0)
                .skip(4)
                .findFirst()
                .orElse(0);
    }

    public int calculateSumOfEvenNumbersInGivenRange(int from, int to) {
        return IntStream.range(from, to)
                .filter(i -> i % 2 == 0)
                .sum();
    }

    public int calculateSumOfOddNumbersInGivenRangeWhichAreDivisorsOfGivenNumber(int from, int to, int divisor) {
        return IntStream.range(from, to)
                .filter(i -> i % 2 == 1)
                .filter(i -> i % divisor == 0)
                .sum();
    }
}
