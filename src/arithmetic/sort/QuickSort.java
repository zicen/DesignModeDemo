package arithmetic.sort;


import arithmetic.graph.MyUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

/**
 * 快速排序
 * <p>
 * 在每一轮挑选一个基准元素，并让其他比他大的元素移动到数列的一边，比他小的元素移动到数列的另一边，从而把数列拆解成两个部分（这种思路就叫做分治法）
 * 平均时间复杂度 O（nlogn）
 */
public class QuickSort {
    /**
     * 递归实现
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int arr[], int left, int right) {
        if (left > right) return;
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
    }

    /**
     * 非递归实现
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort2(int arr[], int startIndex, int endIndex) {
        final String START_INDEX = "startIndex";
        final String END_INDEX = "endIndex";

        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        Map rootParm = new HashMap();
        rootParm.put(START_INDEX, startIndex);
        rootParm.put(END_INDEX, endIndex);
        quickSortStack.push(rootParm);
        // 循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partition2(arr, param.get(START_INDEX), param.get(END_INDEX));
            //根据基准元素分成两部分
            if (param.get(START_INDEX) < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put(START_INDEX, param.get(START_INDEX));
                leftParam.put(END_INDEX, pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if (pivotIndex + 1 < param.get(END_INDEX)) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put(START_INDEX, pivotIndex + 1);
                rightParam.put(END_INDEX, param.get(END_INDEX));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 单边循环法
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int arr[], int startIndex, int endIndex) {
        // 取第一个位置 （也可以选择随机位置） 的元素作为基准元素
        int pivot = startIndex;
        int mark = startIndex + 1;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < arr[pivot]) {
                MyUtils.swap(arr, i, mark);
                mark++;
            }
        }
        MyUtils.swap(arr, pivot, mark - 1);
        return mark - 1;
    }

    /**
     * 双边循环法
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    private static int partition2(int arr[], int startIndex, int endIndex) {
        // 取出第一个位置作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            // 控制 right 指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // 控制 left 指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 交换 left 和 right 指针所指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        // pivot 和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int arr[] = new int[50000];
        int arr2[] = {3, 1, 2, 6, 5, 8, 9, 44, 32};
        for (int i = 0; i < 50000; i++) {
            int randNum = rand.nextInt() + 1;
            arr[i] = randNum;
        }
        long currentTimeMillis = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println("快速排序 50000 个元素所用时间：" + (currentTimeMillis2 - currentTimeMillis));

        quickSort2(arr2, 0, arr2.length - 1);
        MyUtils.printArr(arr2);
    }


}
