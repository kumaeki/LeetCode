package kuma.lc1381_Design_a_Stack_With_Increment_Operation;

<<<<<<< HEAD
=======
import org.junit.jupiter.api.Test;

>>>>>>> branch 'master' of https://github.com/kumaeki/LeetCode.git
class CustomStack {

    int[] arr;
    int cur;
    int size;

    public CustomStack(int maxSize) {
        size = maxSize;
        arr = new int[maxSize];
        cur = 0;
    }

    public void push(int x) {
        if (cur < size)
            arr[cur++] = x;
    }

    public int pop() {
        if (--cur >= 0)
            return arr[cur];
        else {
            cur = 0;
            return -1;
        }
            
    }

    public void increment(int k, int val) {
        k = Math.min(k, Math.min(cur + 1, size));
        for (int i = 0; i < k; i++)
            arr[i] += val;
    }

    public static void main(String[] args) {
        CustomStack obj = new CustomStack(3);
        obj.push(1);
        obj.push(2);
        obj.pop();
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.increment(5, 100);
        obj.increment(2, 100);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
    }
}
