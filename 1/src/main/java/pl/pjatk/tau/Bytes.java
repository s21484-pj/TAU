package pl.pjatk.tau;

public class Bytes {

    private int bit;

    private int B;

    private int KB;

    private int MB;

    public Bytes() {
    }

    public Bytes(int b) {
        B = b;
    }

    public Bytes(int bit, int b, int KB, int MB) {
        this.bit = bit;
        this.B = b;
        this.KB = KB;
        this.MB = MB;
    }

    public int calculateBitsToBytes(int bit) {
        return bit / 8;
    }

    public int calculateBitsToKilobytes(int bit) {
        return bit / 8 / 1024;
    }

    public int calculateBitsToMegabytes(int bit) {
        return bit / 8 / 1024 / 1024;
    }

    public int calculateBytesToBits(int B) {
        return B * 8;
    }

    public int calculateBytesToKilobytes(int B) {
        return B / 1024;
    }

    public int calculateBytesToMegabytes(int B) {
        return B / 1024 / 1024;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getKB() {
        return KB;
    }

    public void setKB(int KB) {
        this.KB = KB;
    }

    public int getMB() {
        return MB;
    }

    public void setMB(int MB) {
        this.MB = MB;
    }
}
