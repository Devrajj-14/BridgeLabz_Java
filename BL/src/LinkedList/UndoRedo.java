/*
  text editor history using doubly linked list
  each node is a snapshot of full text at that moment
*/
class TextEditorHistory {

    /*
      state node for doubly linked list
      prev = undo direction, next = redo direction
    */
    private static class StateNode {
        String text;
        StateNode prev;
        StateNode next;

        StateNode(String text) {
            this.text = text;
        }
    }

    private StateNode head;
    private StateNode tail;
    private StateNode current;

    private int size = 0;
    private final int limit;

    public TextEditorHistory(int limit) {
        this.limit = limit;

        // start with empty text state
        addState("");
    }

    // add a new state after current, clear redo chain
    public void addState(String newText) {
        // if current is not tail, cut redo history
        if (current != null && current.next != null) {
            // unlink forward nodes
            StateNode t = current.next;
            current.next = null;
            tail = current;

            // adjust size by recounting (simple and safe)
            recountSize();
        }

        StateNode node = new StateNode(newText);

        // first node case
        if (head == null) {
            head = tail = current = node;
            size = 1;
            return;
        }

        // attach after tail
        node.prev = tail;
        tail.next = node;
        tail = node;
        current = node;
        size++;

        // enforce fixed history size
        trimIfNeeded();
    }

    // undo -> move current back if possible
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    // redo -> move current forward if possible
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // current text
    public String getText() {
        return current == null ? "" : current.text;
    }

    // trim oldest states if limit exceeded
    private void trimIfNeeded() {
        while (size > limit) {
            // remove head
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // recount size from head to tail
    private void recountSize() {
        int count = 0;
        StateNode t = head;
        while (t != null) {
            count++;
            t = t.next;
        }
        size = count;
    }
}

/*
  demo runner for uc8
*/
public class UndoRedo {
    public static void main(String[] args) {
        TextEditorHistory editor = new TextEditorHistory(10);

        // typing actions
        editor.addState("h");
        editor.addState("he");
        editor.addState("hel");
        editor.addState("hell");
        editor.addState("hello");

        System.out.println("current: " + editor.getText());

        editor.undo();
        editor.undo();
        System.out.println("after undo x2: " + editor.getText());

        editor.redo();
        System.out.println("after redo: " + editor.getText());

        // new change should clear redo path
        editor.addState(editor.getText() + "!");
        System.out.println("after new state: " + editor.getText());

        editor.redo(); // should do nothing
        System.out.println("after redo try: " + editor.getText());
    }
}