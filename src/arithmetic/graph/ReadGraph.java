package arithmetic.graph;

import java.io.*;

/**
 * Created by Administrator on 2018/4/22 0022.
 */
public class ReadGraph {
    public static void readGraph(Graph graph,String filename){
        File file = new File(filename);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String s = reader.readLine();
            String[] split = s.split(" ");
            graph.n = Integer.parseInt(split[0]);
            graph.m = Integer.parseInt(split[1]);

            for (int i = 0; i < graph.m; i++) {
                String s1 = reader.readLine();
                if ( s1!= null) {
                    String[] split1 = s1.split(" ");
                    graph.addEdge(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
