package ListInterface;

import java.util.*;

/*
 * Reverse a LinkedList without using built-in reverse.
 * Method 1 (easy + clean): use two pointers via ListIterator (swap values).
 */
class ReverseLinkedList {

    static void reverse(LinkedList<Integer> list) {
        // left iterator starts from beginning
        ListIterator<Integer> left = list.listIterator();

        // right iterator starts from end (size position)
        ListIterator<Integer> right = list.listIterator(list.size());

        int swaps = list.size() / 2; // number of swaps needed

        while (swaps-- > 0) {
            // move left forward and get value
            int lVal = left.next();

            // move right backward and get value
            int rVal = right.previous();

            // swap by setting values
            left.set(rVal);
            right.set(lVal);
        }
    }
}


class ReverseArrayList {

    static void reverse(List<Integer> list) {
        int left = 0, right = list.size() - 1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}

public class ReverseList {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        ReverseLinkedList.reverse(ll);

        System.out.println(ll); // [5, 4, 3, 2, 1]

        List<Integer> arrList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ReverseArrayList.reverse(arrList);
        System.out.println(arrList);
    }
}