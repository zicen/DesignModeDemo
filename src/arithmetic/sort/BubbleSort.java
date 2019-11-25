package arithmetic.sort;


import arithmetic.graph.MyUtils;

import java.util.Arrays;

/**
 * 冒泡排序：轻的上浮，沉的下降。两个相邻位置比较，如果前面的元素比后面的元素大就换位置
 * 第一次：arr[0]与arr[1],arr[1]与arr[2],arr[2]与arr[3],arr[3]与arr[4] 比较4次
 * 第二次:arr[0]与arr[1],arr[1] arr[2],arr[2] arr[3]  比较3次
 * 第三次:arr[0]与arr[1],arr[1] arr[2],  比较2次
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 6, 7, 9, 8, 9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{2, 1, 3, 4, 6, 7, 9, 8, 9};
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 第一版 冒泡排序
     *
     * @param arr 待排序集合
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
//                    arr[j] = arr[j] ^ arr[j + 1];
//                    arr[j + 1] = arr[j] ^ arr[j + 1];
//                    arr[j] = arr[j] ^ arr[j + 1];
                    MyUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 第二版冒泡排序 当判断数列已经有序，做出标记，提前结束工作
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                boolean isSorted = true;
                if (arr[j] > arr[j + 1]) {
                    MyUtils.swap(arr,j,j+1);
                    isSorted = false;
                }
                if (isSorted) {
                    break;
                }
            }
        }
    }

}
