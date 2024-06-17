package question03;

import java.util.ArrayList;


public class Main {
    public ArrayList<Integer> removeInappropriatePairs(ArrayList<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input list cannot be null.");
        }

        if (numbers.isEmpty()) {
            return numbers;
        }

        boolean isLengthOdd = numbers.size() % 2 != 0;
        int limit = isLengthOdd ? numbers.size() - 1 : numbers.size();

        for (int i = 0; i < limit; i += 2) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                numbers.remove(i + 1);
                numbers.remove(i);
                i -= 2;
                if (i < -2) i = -2;
                limit -= 2;
            }
        }

        if (isLengthOdd) {
            numbers.remove(numbers.size() - 1);
        }

        return numbers;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(7);
        numbers.add(4);
        numbers.add(3);
        numbers.add(6);
        numbers.add(5);
        numbers.add(8);
        numbers.add(5);
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);
        numbers.add(7);
        numbers.add(3);
        System.out.println(main.removeInappropriatePairs(numbers));
    }
}
