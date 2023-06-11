package zadania_lab09_ararys.zadanie5;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> IntegerList = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        List<Integer> IntegerList2 = new ArrayList<>(List.of(10, 11, 12, 13, 14, 15, 16));

        ListIterator<Integer> iterator = IntegerList.listIterator(IntegerList.size());
        while (iterator.hasPrevious()) {
            int element = iterator.previous();
            System.out.println(element);
            IntegerList2.add(element);
        }

        for (Integer element : IntegerList2) {
            System.out.println(element);
        }
        Random random = new Random();
        int losuj = random.nextInt(3)-1;
        System.out.println(losuj);

    }
}
