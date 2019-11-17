package arithmetic.sort;


import arithmetic.graph.MyUtils;

import java.util.Random;

/**
 * 快速排序
 *
 * 在每一轮挑选一个基准元素，并让其他比他大的元素移动到数列的一边，比他小的元素移动到数列的另一边，从而把数列拆解成两个部分（这种思路就叫做分治法）
 * 平均时间复杂度 O（nlogn）
 *
 */
public class QuickSort {
    public static void quickSort(int arr[], int left, int right) {
        if (left > right) return;
        int partitionIndex = partition2(arr, left, right);
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
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

        quickSort(arr2, 0, arr2.length - 1);
        MyUtils.printArr(arr2);
    }


}
