package arithmetic.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二分查找树
 * 博客地址：https://blog.csdn.net/zy00000000001/article/details/69666544
 */
public class BinarySearchTree {
    private Node root;
    private int count;

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int key, int value) {
        root = insert(root, key, value);
    }

    /**
     * 插入一个节点.
     * 核心思想:从根节点开始找插入的位置，满足二叉搜索树的特性，比左子节点大，比右子节点小.
     * 步骤：
     * 1、从根节点开始，先比较当前节点，如果当前节点为null那么很明显就应该插入到这个节点。
     * 2、如果上面的节点不是null，那么和当前节点比较，如果小于节点就往左子树放，如果大于节点就往右子树放。
     * 3、然后分别对左子树或者右子树递归的递归进行如上1、2步骤的操作
     * <p>
     * 此时就用到了递归，那么递归是对某一个问题，它的子问题需要是同样的模型。
     * 此处的一个小的问题就是：对某个node，然后进行操作，所以参数应该有个node才能实现循环起来。
     * 此处向以node为根的二叉搜索树中,插入节点(key, value).此处就都用int类型了,外部的用户是
     * 不需要了解node的概念.它们只需要知道传入的的key和value就行。
     * 暂时的设计便于理解传入用户自己的key和value，到时候也方便用于自己根据key进行所以.
     *
     * @param node  因为要使用递归的思想，此时是要插入的节点。
     * @param key   外部传入的key
     * @param value 外部传入的value
     * @return 返回的是新插入二叉树节点后，二叉树的根。
     */
    private Node insert(Node node, int key, int value) {
        //如果要插入的节点是null，那么证明我们找到这个位置了，放在这即可
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key < node.getKey()) {//此时应该在左节点递归处理.把插入的节点最终放入到了左子节点，最终关联到左子树上.
            Node left = insert(node.getLeftChild(), key, value);
            node.setLeftChild(left);
        } else if (key > node.getKey()) {//此时应该在左节点递归处理.把插入的节点最终放入到了右子节点
            Node right = insert(node.getRightChild(), key, value);
            node.setRightChild(right);
        } else {//等于的时候直接更新数值
            node.setValue(value);
        }

        return node;
    }

    public int search(int key) {
        return search(root, key);
    }

    /**
     * @param node 第一开始传入的是根节点，从根节点开始索引，搜索完后，传入的是下一个要搜索的节点。
     * @param key  要查找的键值。
     * @return 返回查找的key对应的value.
     */
    private int search(Node node, int key) {
        if (node == null) {
            return (Integer) null;
        }
        if (node.getKey() == key) {
            return node.getValue();
        } else if (node.getKey() > key) {
            return search(node.getLeftChild(), key);
        } else {
            return search(node.getRightChild(), key);
        }

    }

    public boolean contains(int key) {
        return contains(root, key);
    }

    private boolean contains(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (node.getKey() == key) {
            return true;
        } else if (key < node.getKey()) {
            return contains(node.getLeftChild(), key);
        } else {
            return contains(node.getRightChild(), key);
        }

    }
/**
 * 二叉搜索树的遍历。
 * 遍历(Traversal)是指沿着某条搜索路线，依次对树中每个结点均做一次且仅做一次访问。二叉树的遍历有三种：
 *        前序遍历(Preorder Traversal)：先访问当前节点，再依次递归访问左右子树
 *        中序遍历(Inorder Traversal)：先递归访问左子树，再访问自身，再递归访问右子树
 *        后序遍历(Postorder Traversal)：先递归访问左右子树，最后再访问当前节点。
 * 属于深度优先的遍历。
 * 实际写起代码来十分简单，只要看 sout 是放在前面就是 前序遍历，在中间就是中序遍历，在后面就是 后序遍历
 */
    /**
     * 前序遍历
     * 遍历这块就用递归的思想很容易实现，那么最小的规模就是对一个节点,函数应该带有参数Node.
     */
    public void preTravelsal() {
        preTravelsal(root);
    }

    private void preTravelsal(Node node) {
        if (node != null) {
            System.out.println("key:" + node.getKey() + " value:" + node.getValue());
            preTravelsal(node.getLeftChild());
            preTravelsal(node.getRightChild());
        }
    }

    /**
     * 中序遍历,中序遍历的一个应用就是遍历完毕后就是有序的。
     */
    public void centerTravelsal() {
        //调用内部的递归实现.
        centerTravelsal(root);
    }

    private void centerTravelsal(Node node) {
        if (node != null) {
            //先遍历左节点
            centerTravelsal(node.getLeftChild());
            //然后当前节点
            System.out.println("key:" + node.getKey() + " value:" + node.getValue());
            //最后右节点
            centerTravelsal(node.getRightChild());
        }
    }

    /**
     * 后序遍历  一般用来释放树的空间
     */
    public void postTravelsal() {
        postTravelsal(root);
    }

    private void postTravelsal(Node node) {
        if (node != null) {
            //先遍历左节点
            postTravelsal(node.getLeftChild());
            //然后右节点
            postTravelsal(node.getRightChild());
            //最后当前节点
            System.out.println("key:" + node.getKey() + " value:" + node.getValue());
        }
    }

    /**
     * 层序遍历 广度优先
     * 我们前面提到的都是通过递归实现的深度优先遍历,只要往下的节点还有符合要求的条件,那么就会继续西先往下执行
     * 而层序遍历是一种广度优先的遍历方式,先遍历根节点这一层,再遍历第二层,依次这样从上到下,从左到右.
     */
    public void levelTravelsal() {
        if (isEmpty()) return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println("key:" + node.getKey() + " value:" + node.getValue());
            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }


    /**
     * 上面用到的 前中后序遍历都是使用的 递归的调用方法，那么不用递归如何做呢？这里以前序遍历为例
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println("key:" + node.getKey() + " value:" + node.getValue());
            if (node.getLeftChild() != null) {
                stack.push(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                stack.push(node.getRightChild());
            }
        }
    }

    /**
     * 获取最小元素
     * @return
     */
    public Node getMinNode() {
        if (count == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root);
    }

    private Node minimum(Node node) {
        if (node.getLeftChild() == null) {
            return node;
        }
        return minimum(node.getLeftChild());
    }
    /**
     * 获取最大元素
     * @return
     */
    public Node getMaxNode() {
        if (count == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return max(root);
    }

    private Node max(Node node) {
        if (node.getRightChild() == null) {
            return node;
        }
        return max(node.getRightChild());
    }

    /**
     * 删除最小节点
     * @return
     */
    public Node removeMin(){
        Node minNode = getMinNode();
       root =  removeMin(root);
        return minNode;
    }

    private Node removeMin(Node node) {
        if (node.getLeftChild() == null) {
            Node rightNode = node.getRightChild();
            node.setRightChild(null);
            count--;
            return rightNode;
        }
        node.setLeftChild(removeMin(node.getLeftChild()));
        return node;
    }

    /**
     * 删除最大节点
     * @return
     */
    public Node removeMax(){
        Node maxNode = getMaxNode();
        root =  removeMax(root);
        return maxNode;
    }

    private Node removeMax(Node node) {
        if (node.getRightChild() == null) {
            Node leftChild = node.getLeftChild();
            node.setLeftChild(null);
            count--;
            return leftChild;
        }
        node.setRightChild(removeMin(node.getRightChild()));
        return node;
    }

}
