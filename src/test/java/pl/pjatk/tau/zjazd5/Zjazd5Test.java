package pl.pjatk.tau.zjazd5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.tau.SomethingToTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Zjazd5Test {

    @Mock
    private SomethingToTest somethingToTest;

    @Test
    public void shouldCreateClassInstance() {
        assertThat(somethingToTest, is(notNullValue()));
    }

    @Test
    public void shouldInvokeMethod() {
        somethingToTest.findTheLowestNumberWhichIsDivisorOfGivenNumbers(1, 2, 3);

        verify(somethingToTest).findTheLowestNumberWhichIsDivisorOfGivenNumbers(1, 2, 3);
    }

    @Test
    public void shouldInvokeMethodOneTime() {
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 10);

        verify(somethingToTest, times(1)).calculateSumOfEvenNumbersInGivenRange(anyInt(), anyInt());
    }

    @Test
    public void shouldInvokeMethodWithGivenParamsAtMostOnce() {
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 10);
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 5);
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(2, 7);

        verify(somethingToTest, atMostOnce()).calculateSumOfEvenNumbersInGivenRange(1, 5);
    }

    @Test
    public void shouldNeverInvokeMethodWithGivenParams() {
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 10);
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 5);
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(2, 7);

        verify(somethingToTest, never()).calculateSumOfEvenNumbersInGivenRange(1, 100);
    }

    @Test
    public void shouldInvokeMethodWithGivenParamsAtLeastOnce() {
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 10);
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 5);
        somethingToTest.calculateSumOfEvenNumbersInGivenRange(1, 7);

        verify(somethingToTest, atLeastOnce()).calculateSumOfEvenNumbersInGivenRange(1, 5);
    }
}
