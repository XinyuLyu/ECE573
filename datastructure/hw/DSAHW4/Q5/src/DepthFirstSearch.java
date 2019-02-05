public class DepthFirstSearch {

    private boolean[] marked;
    int count = 0;

    public DepthFirstSearch(EdgeWeightedGraph G, int s) {
        marked = new boolean[G.V()];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        marked[s] = true;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            count++;
            System.out.println("vertex[" + v +"] visited");

            for (Edge e : G.adj(v)) {
                if (!marked[e.other(v)]) {
                    stack.push(e.other(v));
                    marked[e.other(v)] = true;
                }
            }
        }

        System.out.println(count + " vertex has been visited in DFS");
    }


}
