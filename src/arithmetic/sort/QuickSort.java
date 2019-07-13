package arithmetic.sort;


import arithmetic.graph.MyUtils;

import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {
    public static void quickSort(int arr[], int left, int right) {
        if (left > right) return;
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
    }

    private static int partition(int arr[], int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                MyUtils.swap(arr, i, index);
                index++;
            }
        }
        MyUtils.swap(arr, pivot, index - 1);
        return index - 1;
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
        quickSort(arr, 0, arr.length-1);
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println("快速排序 50000 个元素所用时间：" + (currentTimeMillis2 - currentTimeMillis));

        quickSort(arr2, 0, arr2.length - 1);
        MyUtils.printArr(arr2);
    }


}
