package question03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void removeUnsuitablePairs(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            if (list.get(i) > list.get(i + 1)) {
                list.remove(i);
                list.remove(i);
                i -= 2;
                if (i < -1) {
                    i = -1;
                }
            }
        }
        if (list.size() % 2 != 0) {
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        try {
            System.out.println("Enter how many numbers you want to enter: ");
            int size = input.nextInt();

            if (size <= 0) {
                throw new IllegalArgumentException("Size must be a positive integer.");
            }

            for (int i = 0; i < size; i++) {
                System.out.println("Number " + (i + 1) + " : ");
                int num = input.nextInt();
                list.add(num);
            }

            System.out.println("Original List: " + list);
            removeUnsuitablePairs(list);
            System.out.println("Modified List: " + list);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}
