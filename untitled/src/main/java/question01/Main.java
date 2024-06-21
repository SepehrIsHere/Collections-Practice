package question01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void generatePermutations(String str){
        HashSet<String> permutations = new HashSet<>();
        permute(str, "",permutations);
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }

    private static void permute(String str, String prefix, HashSet<String> permutations){
        if(str.length() == 0){
            permutations.add(prefix);
        }else{
            for (int i = 0; i < str.length(); i++){
                permute(str.substring(0,i) + str.substring(i + 1),prefix + str.charAt(i), permutations);
            }
        }
    }

    public static void areAnagrams(String string1, String string2){
        if(string1.length() != string2.length()){
            System.out.println("Fail");
            return;
        }
        HashMap<Character, Integer> charCountMap1 = getCharCountMap(string1);
        HashMap<Character, Integer> charCountMap2 = getCharCountMap(string2);

        if (charCountMap1.equals(charCountMap2)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static HashMap<Character, Integer> getCharCountMap(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first word : ");
        String word = input.next();
        System.out.println("Enter the second word : ");
        String secondWord = input.next();
        System.out.println("Permutations of " + word + " :");
        generatePermutations(word);
        System.out.println("Permutations of " + secondWord + " :");
        generatePermutations(secondWord);

        System.out.println("Checking if " + word + " and " + secondWord + " are anagrams:");
        areAnagrams(word, secondWord);

    }
}