package TimeComplaxity;
import java.util.HashSet;

public class HashSetSearch {
    public static boolean search(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(search(set, 3));
    }
}