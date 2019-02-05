import java.io.IOException;
public class Q1 {
    public static void main(String[] args) throws IOException {
        Graph g = new Graph("Q1.txt");

        boolean isAcyclic;

        Cycle cycle = new Cycle(g);
        isAcyclic = cycle.hasCycle();

        if (isAcyclic)
            System.out.println("This graph is not acyclic");
        else
            System.out.println("This graph is acyclic");
    }
}
