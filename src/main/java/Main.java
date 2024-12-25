import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);

        Heap heap = new Heap(new ArrayList<>());

        list.forEach(heap::insert);
        System.out.println(heap);
        System.out.println(heap.peek());
        heap.pop();
        System.out.println(heap);
    }
}