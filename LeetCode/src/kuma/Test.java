package kuma;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    // 试试中文
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2)
            return false;

        int[] arr1 = new int[26];
        for (char s : s1.toCharArray())
            arr1[s - 'a']++;
        int left = 0, right = 0, count = n1;
        while(right < n2) {
            if(arr1[s2.charAt(right++) - 'a']-- > 0)
                count--;
            if(count == 0)
                return true;
            if(right - left >= n1 && arr1[s2.charAt(left++)-'a']++ >= 0)
                count++;
        }
        return false;
    }


    @org.junit.Test
    public void simple1() {
        assertEquals(true, new Test().checkInclusion("abc", "bcba"));
    }

    @org.junit.Test
    public void simple2() {
        assertEquals(true, new Test().checkInclusion("ab", "eidbaooo"));
    }

    @org.junit.Test
    public void simple3() {
        assertEquals(false, new Test().checkInclusion("ab", "eidbeaooo"));
    }
    
    @org.junit.Test
    public void simple4() {
        assertEquals(false, new Test().checkInclusion("a", "o"));
    }
}
