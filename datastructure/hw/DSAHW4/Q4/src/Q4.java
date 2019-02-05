import java.io.FileNotFoundException;

public class Q4 {
    public static void main(String []args) throws FileNotFoundException {
    EdgeWeightedDigraph G = new EdgeWeightedDigraph("Q4(b).txt");//Q4(b).txt
        int s =0;
        BellmanFordSP sp=new BellmanFordSP(G,s);
        System.out.println("Bellman-Ford SP");
        if (sp.hasNegativeCycle()) {
            for (DirectedEdge e : sp.negativeCycle())
                System.out.println(e);
        }
        else {
            for (int v = 0; v < G.V(); v++) {
                if (sp.hasPathTo(v)) {
                    System.out.printf("%d to %d (%5.2f)  ", s, v, sp.distTo(v));
                    for (DirectedEdge e : sp.pathTo(v)) {
                        System.out.print(e + "   ");
                    }
                    System.out.println();
                }
                else {
                    System.out.printf("%d to %d           no path\n", s, v);
                }
            }
        }
  }
}
