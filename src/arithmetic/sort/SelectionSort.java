package arithmetic.sort;

import arithmetic.graph.MyUtils;

/**
 * 选择排序
 * 用一个索引位置上的元素，与其他索引位置上的元素比较，小在前，大在后。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 6, 7, 9, 8, 9};
        selectionSort(arr);
        MyUtils.printArr(arr);
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    MyUtils.swap(arr, i, j);
                }
            }
        }
    }
}
