package arithmetic.sort;

import arithmetic.graph.MyUtils;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * 场景：大部分元素已经有序的情况
 */
public class CocktailSort {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 6, 7, 9, 8, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            // 有序标记
            boolean isSorted = true;
            // 奇数轮，从左往右比较和交换
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    MyUtils.swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            // 在偶数轮之前，将 isSorted 重新标记为 true
            isSorted = true;
            // 偶数轮，从右往左比较和交换
            for (int j = arr.length - i - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    MyUtils.swap(arr, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
