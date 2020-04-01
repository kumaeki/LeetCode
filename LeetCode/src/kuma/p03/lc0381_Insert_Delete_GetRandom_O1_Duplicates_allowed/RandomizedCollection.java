package kuma.p03.lc0381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

public class RandomizedCollection {

    // Runtime: 10 ms, faster than 89.05% of Java online submissions for Insert
    // Delete GetRandom O(1) - Duplicates allowed.
    // Memory Usage: 43.7 MB, less than 100.00% of Java online submissions for
    // Insert Delete GetRandom O(1) - Duplicates allowed.

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random ran;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
        ran = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set_index = map.getOrDefault(val, new HashSet<Integer>());
        set_index.add(list.size() - 1);
        map.put(val, set_index);
        return set_index.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained
     * the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        // get the info of the target
        Set<Integer> set_index = map.get(val);
        int index = set_index.iterator().next();
        set_index.remove(index);

        if (index != list.size() - 1) {
            // swap the target and the last one
            Collections.swap(list, index, list.size() - 1);

            // update the last one's info
            int item_last = list.get(index);
            Set<Integer> set_last = map.get(item_last);
            set_last.remove(list.size() - 1);
            set_last.add(index);
        }

        // remove the target
        list.remove(list.size() - 1);
        if (set_index.size() == 0)
            map.remove(val);
        else
            map.put(val, set_index);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        System.out.println(r.insert(0));
        System.out.println(r.remove(0));
        System.out.println(r.insert(-1));
        System.out.println(r.remove(0));
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
    }
}
