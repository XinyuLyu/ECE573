import java.io.FileNotFoundException;

public class Q5 {

        public static void main(String[] args) throws FileNotFoundException {
            EdgeWeightedGraph nyc = new EdgeWeightedGraph("NYC.txt");
            int s = 1;
            DepthFirstSearch dfs = new DepthFirstSearch(nyc, s);
            BreadthFirstSearch bfs = new BreadthFirstSearch(nyc, s);
        }
    }

