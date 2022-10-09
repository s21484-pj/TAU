package pl.pjatk.tau;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BytesTest {

    private Bytes bytes;

    @BeforeEach
    public void init() {
        bytes = new Bytes();
    }

    @AfterEach
    public void clean() {
        bytes = null;
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
        assertEquals(128, B);
    }

    @Test
    public void calculate_bits_to_kilobytes() {
        //GIVEN


        //WHEN

        //THEN
    }
}
