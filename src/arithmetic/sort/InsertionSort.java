package arithmetic.sort;


import arithmetic.graph.MyUtils;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 6, 7, 9, 8, 9};
        insertionSort(arr);
        MyUtils.printArr(arr);
    }

    public static void insertionSort(int arr[]) {
        //这个排序只要从第二个元素开始就可以了，第一个元素是不动的
        for (int i = 1; i < arr.length; i++) {
            //为什么j>0而不是>=0?  我们想象当我们的j到索引为1的时候，这时候我们就应该考虑j是否应该和索引0的位置交换，
            //如果j>=0，则根本不需要进行此比较了
            //为什么j=i?  因为我们是从i的位置向前推导选择合适位置的
            /**
             * 其实排序算法可以这样去理解，第一层循环我们是找我们要进行排序的元素是哪一个，第二层循环是我们要和哪些元素去进行比较
             */
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                MyUtils.swap(arr, j, j - 1);
            }
        }
    }
}
