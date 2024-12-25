import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> heap;
    public Heap(ArrayList<Integer> heap) {
        this.heap = heap;
    }
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size()-1);
    }

    public void pop() {
        swap(heap.size()-1, 0);
        heap.removeLast();
        heapifyDown(0);
    }

    public int peek() {
        return heap.getFirst();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void heapifyUp(int index) {

        int i = index;
        if (i == 0)
            return;
        while (i >= 0) {
            int temp = heap.get((i-1)/2);
            if (temp > heap.get(i)) {
                swap(i, (i-1)/2);
                i = (i-1)/2;
            } else {
                break;
            }
        }
    }

    public void heapifyDown(int index) {
        int i = index;
        int n = heap.size();

        while (getLeftChild(i) != -1) {
           int lft = getLeftChild(i);
           int rgt = getRightChild(i) == -1 ? lft : getRightChild(i);
           if (lft <= rgt) {
               swap(i, 2*i+1);
               i = 2*i+1;
           } else {
               swap(i, 2*i+2);
               i = 2*i+2;
           }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public String toString() {
        return heap.toString();
    }

    private int getRightChild(int i) {
        return 2*i+2 < heap.size() ? heap.get(2*i+2) : -1;
    }

    private int getLeftChild(int i) {
        return 2*i+1 < heap.size() ? heap.get(2*i+1) : -1;
    }
}
