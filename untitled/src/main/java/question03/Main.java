package question03;

import java.util.ArrayList;


public class Main {
   public static void removeUnsuitablePairs(ArrayList<Integer> list){
      for(int i = 0; i < list.size() - 1; i += 2){
         if(list.get(i) > list.get(i + 1)){
            list.remove(i);
            list.remove(i);
            i -= 2;
         }
      }
      if(list.size() % 2 != 0){
         list.remove(list.size() -1);
      }
   }
   public static void main(String[] args) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(1); list.add(3); list.add(7); list.add(4); list.add(3); list.add(6);
      list.add(5); list.add(8); list.add(5); list.add(5); list.add(2);
      list.add(7); list.add(3);

      System.out.println("Original List: " + list);
      removeUnsuitablePairs(list);
      System.out.println("Modified List: " + list);
   }
}
