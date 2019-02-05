import java.io.FileNotFoundException;

public class Q6 {
    public static void main(String[] args) throws FileNotFoundException {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph("Q4(a).txt");//Q4(b).txt
        int s = 0;
        DijkstraSP sp = new DijkstraSP(G, s);
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", s, t);
            }
        }
    }
}
