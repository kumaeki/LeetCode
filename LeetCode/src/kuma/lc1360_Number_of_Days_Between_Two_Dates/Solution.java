package kuma.lc1360_Number_of_Days_Between_Two_Dates;

class Solution {

    static int[] DAYS = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDaysFrom1971(date1) - getDaysFrom1971(date2));
    }

    private int getDaysFrom1971(String str) {
        int res = 0;
        String[] arr = str.split("-");
        int y = Integer.valueOf(arr[0]);
        int m = Integer.valueOf(arr[1]);
        int d = Integer.valueOf(arr[2]);
        for (int i = 1971; i < y; i++) {
            res += 365;
            if (isLeap(i))
                res++;
        }

        for (int i = 1; i < m; i++)
            res += DAYS[i];

        if (m > 2 && isLeap(y))
            res++;

        return res + d;
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}