public class BreadthFirstSearch {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    int count = 1;


    public BreadthFirstSearch(EdgeWeightedGraph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
        System.out.println(count + "vertex has been visited in BFS");
    }

    // breadth-first search from a single source
    private void bfs(EdgeWeightedGraph G, int s) {
        Queue<Integer> q = new Queue<Integer>();

        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (Edge e : G.adj(v)) {
                if (!marked[e.other(v)]) {
                    count++;
                    q.enqueue(e.other(v));
                    marked[e.other(v)] = true;
                    System.out.println("vertex[" + e.other(v) +"] visited");
                }
            }
        }
    }

}
