
import java.io.IOException;

public class Q2 {
    public static void main(String[] args) throws IOException {
        EdgeWeightedGraph g = new EdgeWeightedGraph("Q1.txt");
            double k = 0;
            double p = 0;
            for (int i = 0; i <8192; i++) {
                long start1 = System.currentTimeMillis();
                KruskalMST kmst = new KruskalMST(g);
                long end1 = System.currentTimeMillis();
                k += (end1 - start1);

                long start2 = System.currentTimeMillis();
                PrimMST pmst = new PrimMST(g);
                long end2 = System.currentTimeMillis();
                p += (end2 - start2);
            }
            System.out.println("Krustal " + k / 8192 + "ms");
            System.out.println("Prim " + p / 8192 + "ms");
        }

}