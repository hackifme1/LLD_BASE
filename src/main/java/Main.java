import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

/* Heap
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
*/

        // Graph: BFS and DFS
        int numOfNodes = 7;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>(numOfNodes);
        for(int i=0; i < numOfNodes; i++) {
            arrayList.add(new ArrayList<>());
        }
        arrayList.get(0).addAll(Arrays.asList(0,3));
        arrayList.get(1).addAll(Arrays.asList(2,4));
        arrayList.get(2).addAll(Arrays.asList(1,4));
        arrayList.get(3).add(0);
        arrayList.get(4).addAll(Arrays.asList(1,2));
        arrayList.get(5).add(6);
        arrayList.get(6).add(5);
        Graph graph = new Graph(numOfNodes, arrayList);
        System.out.println("DFS of the graph: ");
        graph.dfsDriver(true);
        System.out.println("Iterative DFS of the graph: ");
        graph.dfsDriver(false);
        System.out.println("BFS of the graph: ");
        graph.bfsDriver();
    }
}