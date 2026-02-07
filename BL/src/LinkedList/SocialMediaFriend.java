import java.util.ArrayList;
import java.util.List;

/*
  social network using singly linked list of users
  each user node stores basic profile and friend ids list
*/
class SocialNetwork {

    /*
      user node for singly linked list
      friends stored as simple int list for clarity
    */
    private static class UserNode {
        int userId;
        String name;
        int age;
        List<Integer> friends;
        UserNode next;

        UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
        }
    }

    private UserNode head;

    // add a new user at end
    public void addUser(int userId, String name, int age) {
        UserNode node = new UserNode(userId, name, age);

        // empty list case
        if (head == null) {
            head = node;
            return;
        }

        // traverse to end
        UserNode t = head;
        while (t.next != null) t = t.next;
        t.next = node;
    }

    // search by user id
    public UserNode findById(int userId) {
        UserNode t = head;
        while (t != null) {
            if (t.userId == userId) return t;
            t = t.next;
        }
        return null;
    }

    // search by name (first match)
    public UserNode findByName(String name) {
        UserNode t = head;
        while (t != null) {
            if (t.name.equalsIgnoreCase(name)) return t;
            t = t.next;
        }
        return null;
    }

    // add friend connection both ways
    public boolean addFriendConnection(int a, int b) {
        // prevent self connection
        if (a == b) return false;

        UserNode ua = findById(a);
        UserNode ub = findById(b);

        // users must exist
        if (ua == null || ub == null) return false;

        // add if not already present
        if (!ua.friends.contains(b)) ua.friends.add(b);
        if (!ub.friends.contains(a)) ub.friends.add(a);

        return true;
    }

    // remove friend connection both ways
    public boolean removeFriendConnection(int a, int b) {
        UserNode ua = findById(a);
        UserNode ub = findById(b);

        if (ua == null || ub == null) return false;

        boolean removedA = ua.friends.remove((Integer) b);
        boolean removedB = ub.friends.remove((Integer) a);

        return removedA || removedB;
    }

    // mutual friends between two users
    public List<Integer> mutualFriends(int a, int b) {
        List<Integer> mutual = new ArrayList<>();

        UserNode ua = findById(a);
        UserNode ub = findById(b);

        if (ua == null || ub == null) return mutual;

        // compare ids
        for (int id : ua.friends) {
            if (ub.friends.contains(id)) mutual.add(id);
        }

        return mutual;
    }

    // display all friends of a user
    public void displayFriends(int userId) {
        UserNode u = findById(userId);

        if (u == null) {
            System.out.println("user not found");
            return;
        }

        System.out.println("friends of " + u.name + " (" + u.userId + "): " + u.friends);
    }

    // count friends for each user
    public void countFriendsForEachUser() {
        UserNode t = head;
        while (t != null) {
            System.out.println(t.name + " (" + t.userId + ") has " + t.friends.size() + " friends");
            t = t.next;
        }
    }
}

/*
  demo runner for uc7
*/
public class SocialMediaFriend {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();

        // sample users
        sn.addUser(1, "dev", 21);
        sn.addUser(2, "raj", 22);
        sn.addUser(3, "sam", 20);
        sn.addUser(4, "maya", 23);

        // connections
        sn.addFriendConnection(1, 2);
        sn.addFriendConnection(1, 3);
        sn.addFriendConnection(2, 3);
        sn.addFriendConnection(2, 4);

        sn.displayFriends(1);
        sn.displayFriends(2);

        System.out.println("mutual friends of 1 and 2: " + sn.mutualFriends(1, 2));

        sn.removeFriendConnection(1, 3);
        sn.displayFriends(1);

        sn.countFriendsForEachUser();
    }
}