package arithmetic.graph;

/**
 * Created by Administrator on 2018/4/22 0022.
 * 稠密图 - 邻接矩阵
 * 用一个一维数组存放图中所有顶点数据；用一个二维数组存放顶点间关系（边或弧）的数据，这个二维数组称为邻接矩阵。邻接矩阵又分为有向图邻接矩阵和无向图邻接矩阵
 *    0  1  2  3
 * 0  0  1  0  0
 * 1  0  0  1  0
 * 2  0  0  0  1
 * 3  0  1  0  0
 */
public class DenseGraph extends Graph {
    private boolean directed; //是否是有向图
    private int[][] g; //保存此两个节点之间是否有连接，有的话为1否则为0

    public DenseGraph() {
    }

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new int[n][n];
        for (int i = 0; i < g.length; i++) {
            for (int i1 = 0; i1 < g[i].length; i1++) {
                g[i][i1] = 0;
            }
        }
    }

    /**
     * 添加一条边（就是连起来两个元素）
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v,w))
            return;

        g[v][w] = 1;
        if (!directed)
            g[w][v] = 1;

        m++;
    }

    /**
     * 判断是否已经有一条边
     * @param v
     * @param w
     */
    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w]==1;
    }

    public void show(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("  "+g[i][j]);
            }
            System.out.println();
        }
    }
    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public boolean isDirected() {
        return directed;
    }

    public int[][] getG() {
        return g;
    }
}
