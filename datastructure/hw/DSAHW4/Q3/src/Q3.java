import java.io.IOException;

public class Q3 {
    public static void main(String[] args) throws IOException {
        EdgeWeightedDigraph g1 = new EdgeWeightedDigraph("Q3.txt");
        EdgeWeightedDigraph g2 = new EdgeWeightedDigraph("Q3.txt");
        int s =5;
        AcyclicSP sp=new AcyclicSP(g1,s);
        AcyclicLP lp=new AcyclicLP(g2,s);
        System.out.println("SP");
        for (int v = 0; v < g1.V(); v++) {
            if (sp.hasPathTo(v)) {
                System.out.printf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                for (DirectedEdge e : sp.pathTo(v)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", s, v);
            }
        }
        System.out.println("LP");
        for (int v = 0; v < g2.V(); v++) {
            if (lp.hasPathTo(v)) {
                System.out.printf("%d to %d (%.2f)  ", s, v, lp.distTo(v));
                for (DirectedEdge e : lp.pathTo(v)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", s, v);
            }
        }
    }
}
