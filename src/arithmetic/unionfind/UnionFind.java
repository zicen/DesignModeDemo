package arithmetic.unionfind;

/**
 * 并查集
 * https://blog.csdn.net/qq_41593380/article/details/81146850
 * <p>
 * 并查集的数学模型是一组不相交的动态集合的集合S={A,B,C,...}，它支持以下的运算：
 * (1)union(A,B)：将集合A和B合并，其结果取名为A或B；
 * (2)find(x)：找出包含元素x的集合，并返回该集合的名字。
 */
public class UnionFind {
    //父亲数组
    Node[] node;

    // 并查集中的节点
    private static class Node {
        int parent;
        boolean root;

        private Node() {
            parent = 1;
            root = true;
        }
    }

    public UnionFind(int n) {
        node = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            node[i] = new Node();
        }
    }

    /**
     * find运算就是从元素e相应的结点走到树根处，找出所在集合的名字。
     *
     * @param e
     * @return
     */
    public int find(int e) {
        while (!node[e].root) {
            e = node[e].parent;
        }
        return e;
    }

    /**
     * union运算，合并两个集合，只要将表示其中一个集合的树的数根改为表示另一个集合的树的数根的儿子结点。
     * <p>
     * 容易看出，在最坏情况下，合并可能使n个结点的树退化成一条链，导致对所有元素各执行一次find将耗时O(n^2)。可做出以下改进来加速find运算。
     * 1. 小树合并到大树
     * 2. 路径压缩技术
     * https://blog.csdn.net/why_still_confused/article/details/51497973
     */
    public void union(int a, int b) {
        node[a].parent += node[b].parent;
        node[b].root = false;
        node[b].parent = a;
    }
}
