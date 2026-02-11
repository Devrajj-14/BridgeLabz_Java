package LeniarBinarySearchAndString;

class Specific {
    public static String check(String[] sentences, String word) {
        for (int i = 0; i < sentences.length; i++) {
            // if sentence contains the word anywhere
            if (sentences[i].contains(word)) {
                return sentences[i]; // return the sentence
            }
        }
        return "Not Found";
    }
}

public class FindSpecificLeniar {
    public static void main(String[] args) {
        String[] arr = {
                "Devraj studies in MBA",
                "He goes to SRM University",
                "This is abc example"
        };

        System.out.println(Specific.check(arr, "abc"));
    }
}