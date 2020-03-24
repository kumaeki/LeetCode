package kuma.p03.lc0338_Counting_Bits;

public class Solution2 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        String str;
        int count;
        for (int i = 1; i <= num; i++) {
            str = Integer.toBinaryString(i);
            count = 0;
            for (char c : str.toCharArray())
                if (c == '1')
                    count++;
            res[i] = count;
        }
        return res;
    }
}
