import java.util.*;
public class Scramble {
    public String original = "";

    public Scramble(String original) {
        this.original = original;
    }

    // Helper method to swap letters
    private static String swapLetters(String toSwap) { // Remember to insert substring of 'original'
        char a = toSwap.charAt(0);
        char b = toSwap.charAt(1);
        String swapped = "" + b + a;
        return swapped;
    }

    public static String scrambleWord(String original) {
        String scrambled = "";

        // og: ABRACADABRA
        // i = xxxxxxxxxx
        // re: BARCADABA

        for (int i = 0; i < original.length() - 2; i++) {
            if (original.charAt(i) == 'A' && original.charAt(i + 1) != 'A') {
                scrambled += swapLetters(original.substring(i, i + 2));
                i++;
            } else if (original.charAt(i) != 'A' && original.charAt(i + 1) == 'A' && original.charAt(i + 2) != 'A') {
                scrambled += original.charAt(i) + swapLetters(original.substring(i + 1, i + 3));
                i += 2;
            } else {
                scrambled += original.charAt(i);
            }
        }

        if (scrambled.length() == original.length() - 1) {
            return scrambled + original.charAt(original.length() - 1);
        } else if (scrambled.length() == original.length() - 2) {
            return scrambled + original.substring(original.length() - 2, original.length());
        } else {
            return scrambled;
        }
    }

    public static void scrambleOrRemove(List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            String scrambled = scrambleWord(word);
            if (word.equals(scrambled)) { // if word does not need to be scrambled, remove it from wordList
                wordList.remove(i);
                i--; // index needs to be adjusted
            } else { // if word is scrambled, update wordList
                wordList.set(i, scrambled);
            }

            // Debug :(
            for (String x : wordList) {
                System.out.println(x);
            }
        }
    }
}