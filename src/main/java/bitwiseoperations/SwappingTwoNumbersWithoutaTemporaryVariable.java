package bitwiseoperations;

public class SwappingTwoNumbersWithoutaTemporaryVariable {

    public static void main(String[] args) {
        int a = 244;
        int b = 4;

        a = a ^ b; System.out.println(a + " - " + String.format("%16s", Integer.toBinaryString(a)).replace(" ","0"));
        b = a ^ b; System.out.println(b + " - " + String.format("%16s", Integer.toBinaryString(b)).replace(" ","0"));
        a = a ^ b; System.out.println(a + " - " + String.format("%16s", Integer.toBinaryString(a)).replace(" ","0"));

        // (244) 0000000011110100 ^
        // (4)   0000000000000100 =
        // (240) 0000000011110000

        // (240) 0000000011110000 ^
        // (4)   0000000000000100 =
        // (244) 0000000011110100

        // (240) 0000000011110000 ^
        // (244) 0000000011110100 =
        // (4)   0000000000000100
    }
}
