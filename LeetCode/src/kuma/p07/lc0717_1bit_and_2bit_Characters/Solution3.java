package kuma.p07.lc0717_1bit_and_2bit_Characters;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for 1-bit and
    // 2-bit Characters.
    // Memory Usage: 39.2 MB, less than 11.11% of Java online submissions for 1-bit
    // and 2-bit Characters.
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1)
            i--;
        return ((bits.length - 2 - i) & 1) == 0;
    }

}
