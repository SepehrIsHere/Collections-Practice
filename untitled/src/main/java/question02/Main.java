package question02;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    private static TreeSet<Character> first = new TreeSet<>();
    private static TreeSet<Character> second = new TreeSet<>();
    private static Random random = new Random();
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public void fill(TreeSet<Character> treeSet){
        for (int i = 0; i < 10; i++) {
            treeSet.add(alphabet.charAt(random.nextInt(alphabet.length())));
        }
    }

    public TreeSet<Character> combinedSet(TreeSet<Character> first, TreeSet<Character> second){
        TreeSet<Character> combinedSet = new TreeSet<>(first);
        combinedSet.addAll(second);
        return combinedSet;
    }

    public TreeSet<Character> commonSet(TreeSet<Character> first, TreeSet<Character> second){
        TreeSet<Character> commonSet = new TreeSet<>();
        Iterator<Character> firstIterator = first.iterator();
        Iterator<Character> secondIterator = second.iterator();
        while(firstIterator.hasNext()){
            if(firstIterator.next().equals(secondIterator.next())){
                commonSet.add(firstIterator.next());
            }
        }
        return commonSet;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.fill(first);
        main.fill(second);
        System.out.println("characters of first TreeSet:" + first);
        System.out.println("characters of second TreeSet:" + second);
        System.out.println(main.combinedSet(first, second));
        System.out.println(main.commonSet(first, second));
    }


}
