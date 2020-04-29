package kuma.p00.lc0068_Text_Justification;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Text
    // Justification.
    // Memory Usage: 37.8 MB, less than 5.55% of Java online submissions for Text
    // Justification.
    String[] spaces;

    public List<String> fullJustify(String[] words, int maxWidth) {
        spaces = new String[maxWidth];
        spaces[0] = "";
        for (int i = 1; i < maxWidth; i++)
            spaces[i] = spaces[i - 1] + " ";

        List<String> res = new ArrayList<String>();
        int i = 0;
        while (i < words.length) {

            int start = i;
            String word = words[i++];
            int len = word.length(), wordlen = len;
            while (i < words.length && len + 1 + words[i].length() <= maxWidth) {
                word = words[i++];
                wordlen += word.length();
                len += (word.length() + 1);
            }
            StringBuilder sb = new StringBuilder();
            word = words[start];
            sb.append(word);
            int size = i - start;
            if (i != words.length) {
                if (size == 1) {
                    addSpace(sb, maxWidth - word.length());
                } else {
                    int d = (maxWidth - wordlen) / (size - 1);
                    int e = (maxWidth - wordlen) % (size - 1);
                    for (int j = 1; j < size; j++) {
                        if (e-- > 0)
                            addSpace(sb, 1);
                        addSpace(sb, d);
                        sb.append(words[start + j]);
                    }
                }
            } else {
                for (int j = 1; j < size; j++)
                    sb.append(" ").append(words[start + j]);
                addSpace(sb, maxWidth - sb.length());
            }
            res.add(sb.toString());
        }
        return res;
    }

    private void addSpace(StringBuilder sb, int count) {
        sb.append(spaces[count]);
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "This    is    an", "example  of text", "justification.  " };
        List<String> actuals = new Solution()
                .fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16);
        assertArrayEquals(expecteds, actuals.toArray(new String[3]));

    }

    @Test
    public void simple2() {
        String[] expecteds = new String[] { "Science  is  what we", "understand      well", "enough to explain to",
                "a  computer.  Art is", "everything  else  we", "do                  " };
        List<String> actuals = new Solution()
                .fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to",
                        "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20);
        actuals.forEach(x -> System.out.println(x));
        assertArrayEquals(expecteds, actuals.toArray(new String[6]));

    }
}
