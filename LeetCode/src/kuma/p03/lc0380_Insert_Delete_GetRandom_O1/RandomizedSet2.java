package kuma.p03.lc0380_Insert_Delete_GetRandom_O1;

import java.util.*;

// Runtime: 7 ms, faster than 99.98% of Java online submissions for Insert Delete GetRandom O(1).
// Memory Usage: 44.1 MB, less than 94.00% of Java online submissions for Insert Delete GetRandom O(1).
public class RandomizedSet2 {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random ran;

    /** Initialize your data structure here. */
    public RandomizedSet2() {
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
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        int index = map.getOrDefault(val, -1);
        if (index == -1)
            return false;
        // swap the target and the last one
        Collections.swap(list, index, list.size() - 1);
        // update the last one's position from map
        map.put(list.get(index), index);
        // remove the target item from map
        map.remove(val);
        // remove the target from list(the last one)
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet2 obj = new RandomizedSet2();
//        System.out.println(obj.insert(0));
//        System.out.println(obj.insert(1));
//        System.out.println(obj.remove(0));
//        System.out.println(obj.insert(2));
//        System.out.println(obj.remove(1));
//        System.out.println(obj.getRandom());

        System.out.println(obj.insert(3));
        System.out.println(obj.remove(3));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(3));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(3));
    }
}
