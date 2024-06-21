package question02;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;
import java.util.NoSuchElementException;

public class Main {
    private static TreeSet<Character> first = new TreeSet<>();
    private static TreeSet<Character> second = new TreeSet<>();
    private static Random random = new Random();
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public void fill(TreeSet<Character> treeSet) {
        try {
            for (int i = 0; i < 10; i++) {
                treeSet.add(alphabet.charAt(random.nextInt(alphabet.length())));
            }
        } catch (Exception e) {
            System.out.println("An error occurred while filling the TreeSet: " + e.getMessage());
        }
    }

    public TreeSet<Character> combinedSet(TreeSet<Character> first, TreeSet<Character> second) {
        try {
            TreeSet<Character> combinedSet = new TreeSet<>(first);
            combinedSet.addAll(second);
            return combinedSet;
        } catch (Exception e) {
            System.out.println("An error occurred while combining sets: " + e.getMessage());
            return new TreeSet<>();
        }
    }

    public TreeSet<Character> commonSet(TreeSet<Character> first, TreeSet<Character> second) {
        TreeSet<Character> commonSet = new TreeSet<>();
        try {
            Iterator<Character> firstIterator = first.iterator();
            while (firstIterator.hasNext()) {
                Character element = firstIterator.next();
                if (second.contains(element)) {
                    commonSet.add(element);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while finding common elements: " + e.getMessage());
        }
        return commonSet;
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.fill(first);
            main.fill(second);
            System.out.println("Characters of first TreeSet: " + first);
            System.out.println("Characters of second TreeSet: " + second);
            System.out.println("Combined Set: " + main.combinedSet(first, second));
            System.out.println("Common Set: " + main.commonSet(first, second));
        } catch (Exception e) {
            System.out.println("An error occurred in the main method: " + e.getMessage());
        }
    }
}
