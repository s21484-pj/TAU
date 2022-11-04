package pl.pjatk.tau.zjazd2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pjatk.tau.Bytes;
import pl.pjatk.tau.SomethingToTest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Zjazd2Test {

    private Bytes bytes;
    private SomethingToTest somethingToTest;

    @BeforeEach
    public void init() {
        bytes = new Bytes();
        somethingToTest = new SomethingToTest();
    }

    @Test
    public void calculate_bits_to_bytes() {
        //GIVEN
        bytes.setBit(8);
        int bits = bytes.getBit();

        //WHEN
        int B = bytes.calculateBitsToBytes(bits);

        //THEN
        assertThat(1, is(B));
    }

    @Test
    public void calculate_bytes_to_kilobytes() {
        //GIVEN
        bytes.setB(1024);
        int bytess = bytes.getB();

        //WHEN
        int KB = bytes.calculateBytesToKilobytes(bytess);

        //THEN
        assertThat(1, is(KB));
    }

    @Test
    public void calculate_kilobytes_to_megabytes() {
        //GIVEN
        bytes.setKB(1024);
        int kilobytes = bytes.getKB();

        //WHEN
        int MB = bytes.calculateKilobytesToMegabytes(kilobytes);

        //THEN
        assertThat(1, is(MB));
    }

    @Test
    public void find_the_lowest_number_which_is_divisor_of_given_numbers() {
        //GIVEN
        int firstDivisor = 2;
        int secondDivisor = 3;
        int thirdDivisor = 5;

        //WHEN
        int number = somethingToTest.findTheLowestNumberWhichIsDivisorOfGivenNumbers(firstDivisor, secondDivisor, thirdDivisor);

        //THEN
        assertThat(30, is(number));
    }

    @Test
    public void find_the_lowest_number_which_is_divisor_of_given_numbers_2() {
        //GIVEN
        int firstDivisor = 3;
        int secondDivisor = 4;
        int thirdDivisor = 7;

        //WHEN
        int number = somethingToTest.findTheLowestNumberWhichIsDivisorOfGivenNumbers(firstDivisor, secondDivisor, thirdDivisor);

        //THEN
        assertThat(84, is(number));
    }

    @Test
    public void find_fifth_lowest_number_which_is_divisor_of_given_numbers() {
        //GIVEN
        int firstDivisor = 2;
        int secondDivisor = 3;
        int thirdDivisor = 11;

        //WHEN
        int number = somethingToTest.findFifthLowestNumberWhichIsDivisorOfGivenNumbers(firstDivisor, secondDivisor, thirdDivisor);

        //THEN
        assertThat(330, is(number));
    }

    @Test
    public void find_fifth_lowest_number_which_is_divisor_of_given_numbers_2() {
        //GIVEN
        int firstDivisor = 3;
        int secondDivisor = 4;
        int thirdDivisor = 7;

        //WHEN
        int number = somethingToTest.findFifthLowestNumberWhichIsDivisorOfGivenNumbers(firstDivisor, secondDivisor, thirdDivisor);

        //THEN
        assertThat(420, is(number));
    }

    @Test
    public void calculate_sum_of_even_numbers_in_given_range() {
        //GIVEN
        int from = 1;
        int to = 100;

        //WHEN
        int number = somethingToTest.calculateSumOfEvenNumbersInGivenRange(from, to);

        //THEN
        assertThat(2450, is(number));
    }

    @Test
    public void calculate_sum_of_even_numbers_in_given_range_2() {
        //GIVEN
        int from = 1;
        int to = 0;

        //WHEN
        int number = somethingToTest.calculateSumOfEvenNumbersInGivenRange(from, to);

        //THEN
        assertThat(0, is(number));
    }

    @Test
    public void calculate_sum_of_odd_numbers_in_given_range_which_are_divisors_of_given_number() {
        //GIVEN
        int from = 1;
        int to = 100;
        int divisor = 3;

        //WHEN
        int number = somethingToTest.calculateSumOfOddNumbersInGivenRangeWhichAreDivisorsOfGivenNumber(from, to, divisor);

        //THEN
        assertThat(867, is(number));
    }

    @Test
    public void calculate_sum_of_odd_numbers_in_given_range_which_are_divisors_of_given_number_2() {
        //GIVEN
        int from = 1;
        int to = 150;
        int divisor = 13;

        //WHEN
        int number = somethingToTest.calculateSumOfOddNumbersInGivenRangeWhichAreDivisorsOfGivenNumber(from, to, divisor);

        //THEN
        assertThat(468, is(number));
    }

    @AfterEach
    public void clean() {
        bytes = null;
        somethingToTest = null;
    }
}
