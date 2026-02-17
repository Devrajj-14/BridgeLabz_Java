package TimeComplaxity;

import java.util.TreeSet;

public class TreeSetSearch {
    public static boolean search(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(search(set, 3));
    }
}