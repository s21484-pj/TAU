package pl.pjatk.tau.zjazd1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pjatk.tau.Bytes;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BytesTest {

    private Bytes bytes;

    @BeforeEach
    public void init() {
        bytes = new Bytes();
    }

    @Test
    public void calculate_bits_to_bytes() {
        //GIVEN
        bytes.setBit(1024);
        int bits = bytes.getBit();

        //WHEN
        int B = bytes.calculateBitsToBytes(bits);
        bytes.setB(B);

        //THEN
        assertThat(128, is(B));
    }

    @Test
    public void calculate_bits_to_kilobytes() {
        //GIVEN


        //WHEN

        //THEN
    }

    @AfterEach
    public void clean() {
        bytes = null;
    }
}
