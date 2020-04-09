package kuma.p07.lc0717_1bit_and_2bit_Characters;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for 1-bit and
    // 2-bit Characters.
    // Memory Usage: 39.2 MB, less than 11.11% of Java online submissions for 1-bit
    // and 2-bit Characters.
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index < bits.length) {
            if (index == bits.length - 1)
                return true;
            if (bits[index] == 1)
                index += 2;
            else
                index++;
        }
        return false;
    }
}
