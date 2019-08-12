package arithmetic.sort;

import java.util.Random;

public class MergeSort {
    //第一步：我们对传递的数组从位置0到n-1进行归并排序，因为我们的定义是前闭后闭，当然你也可以使用前闭后开的定义。
    public static void mergeSort(int arr[], int n) {
        mergeSortT(arr, 0, n - 1);
    }

    //第二步：递归归并
    public static void mergeSortT(int arr[], int L, int r) {
        if (L >= r) {
            return;
        }
        int mid = (L + r) / 2;
        mergeSortT(arr, L, mid);
        mergeSortT(arr, mid + 1, r);
        merge(arr, L, mid, r);
    }

    //第三步：归并操作
    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(int[] arr, int L, int mid, int r) {
        //1、开辟临时数组（因为是闭区间所以这里临时数组的大小为：r-l+1）
        int temp[] = new int[r - L + 1];
        for (int i = L; i <= r; i++) { //注意是L,不是1
            temp[i - L] = arr[i];
        }
        //2、定义索引：i=L,j,k
        int i = L, j = mid + 1;
        for (int k = L; k <= r; k++) { //K=L...
            //判断索引越界
            if (i > mid) {
                arr[k] = temp[j - L];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - L];
                i++;
            }
            //比较临时数组两边的大小
            else if (temp[i - L] < temp[j - L]) {
                arr[k] = temp[i - L];
                i++;
            } else {
                arr[k] = temp[j - L];
                j++;
            }
        }

    }

    /**
     * 自底向上的归并排序
     *
     * @param arr
     * @param n
     */
    public static void mergeSortBottom2Up(int arr[], int n) {
        for (int size = 1; size <= n; size += size) {
            for (int i = 0; i + size < n; i += size + size) {
                merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int arr[] = new int[50000];
        int arr2[] = new int[50000];
        for (int i = 0; i < 50000; i++) {
            int randNum = rand.nextInt() + 1;
            arr[i] = randNum;
            arr2[i] = randNum;
        }
        long currentTimeMillis = System.currentTimeMillis();
        mergeSort(arr, 50000);
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println("基础归并排序所用时间：" + (currentTimeMillis2 - currentTimeMillis));

        long currentTimeMillis3 = System.currentTimeMillis();
        mergeSortBottom2Up(arr2, 50000);
        long currentTimeMillis4 = System.currentTimeMillis();
        System.out.println("自底向上归并排序所用时间：" + (currentTimeMillis4 - currentTimeMillis3));
    }


}
