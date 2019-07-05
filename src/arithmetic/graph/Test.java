package arithmetic.graph;

/**
 * Created by Administrator on 2018/4/22 0022.
 */
public class Test {
    public static void main(String[] args) {

        System.out.println("程序开始");
        DenseGraph denseGraph = new DenseGraph(13, false);
        ReadGraph.readGraph(denseGraph,"C:\\Users\\Administrator\\Desktop\\myCode\\ArithmeticDemo\\src\\graph\\testG1.txt");
        denseGraph.show();
        System.out.println("程序结束");

        SparseGraph sparseGraph = new SparseGraph(13, false);
        ReadGraph.readGraph(sparseGraph,"C:\\Users\\Administrator\\Desktop\\myCode\\ArithmeticDemo\\src\\graph\\testG1.txt");
        sparseGraph.show();
    }
}
