package arithmetic.tree;

import java.util.Arrays;

/**
 * 二叉堆的代码实现
 * 1
 * 3      2
 * 6   5  7  8
 * 9  10
 * <p>
 * 1 3 2 6 5 7 8 9 10
 * 二叉堆是存在一个数组中，假设父节点的下标是 parent，那么他的左孩子下标就是 2 * parent + 1 ，右孩子下标就是 2 * parent +2
 * 例如 节点 6 的下标是 3 ，其左孩子下标就是 7 右孩子下标就是 8
 */
public class BinaryHeap {
    /**
     * 上浮 调整
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        // 父节点的坐标 = （子节点坐标 - 1）/ 2
        int parentIndex = (childIndex - 1) / 2;
        // temp 保存插入的叶子节点的值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            // 无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉 调整
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp 保存父节点的值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，则直接跳出
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;

    }

    /**
     * 构建堆
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做“下沉”调整
        for (int i = (array.length-2)/2; i >= 0 ; i--) {
            downAdjust(array,i,array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
