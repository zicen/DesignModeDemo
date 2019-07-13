package arithmetic.sort;

import arithmetic.graph.MyUtils;

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
        MyUtils.printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

}
