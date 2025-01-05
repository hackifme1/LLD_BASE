import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@Data
@ToString
public class Graph {
    private int numOfVertices;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public Graph(int numOfVertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        this.numOfVertices = numOfVertices;
        this.adjacencyList = adjacencyList;
    }

    public void dfsDriver(boolean isRecursive) {
        ArrayList<Boolean> vis = new ArrayList<>();

        for (int i = 0; i < numOfVertices; i++) {
            vis.add(false);
        }

        for(int node = 0; node < numOfVertices; node++) {
            if(!vis.get(node)) {
                if(isRecursive)
                    dfs(node, vis);
                else
                    iterativeDfs(node, vis);
                vis.set(node, true);
                System.out.println();
            }
        }
    }

    public void bfsDriver() {
        ArrayList<Boolean> vis = new ArrayList<>();

        for (int i = 0; i < numOfVertices; i++) {
            vis.add(false);
        }

        for(int node = 0; node < numOfVertices; node++) {
            if(!vis.get(node)) {
                vis.set(node, true);
                bfs(node, vis);
                System.out.println();
            }
        }
    }

    private void dfs(int node, ArrayList<Boolean> vis) {
        System.out.print(node + " -> " + " " );
        vis.set(node, true);
        for(int child : adjacencyList.get(node)) {
            if(!vis.get(child)) {
                vis.set(child, true);
                dfs(child, vis);
            }
        }
    }

    private void bfs(int node, ArrayList<Boolean> vis) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " -> " + " " );
            for(int child : adjacencyList.get(current)) {
                if(!vis.get(child)) {
                    vis.set(child, true);
                    queue.add(child);
                }
            }
        }
    }

    private void iterativeDfs(int node, ArrayList<Boolean> vis) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if(!vis.get(current)) {
                System.out.print(current + " -> " + " " );
            }
            vis.set(current, true);
            for(int i=adjacencyList.get(current).size()-1;i >=0;i--) {
                int child = adjacencyList.get(current).get(i);
                if(!vis.get(child)) {
                    stack.push(child);
                }
            }
        }
    }
}
