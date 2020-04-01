package kuma.p03.lc0380_Insert_Delete_GetRandom_O1;

import java.util.*;

// Runtime: 269 ms, faster than 5.02% of Java online submissions for Insert Delete GetRandom O(1).
// Memory Usage: 47.8 MB, less than 46.00% of Java online submissions for Insert Delete GetRandom O(1).
public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random ran;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        ran = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        int index = list.size();
        list.add(index, val);
        map.put(val, index);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val).intValue();
        map.remove(val);
        list.remove(index);
        while (index < list.size()) {
            int v = list.get(index++);
            map.put(v, map.get(v) - 1);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(0));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }
}
