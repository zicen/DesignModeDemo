package arithmetic.search;

/**
 * 非递归二分查找法
 */
public class BinarySearch {
    public static int search(int key, int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (key < arr[mid]) {
                end = mid-1;
            } else if (key > arr[mid]) {
                start = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 3, 5, 6, 7, 8, 8, 9};
        int resultPosition = search(3, arr);
        System.out.println("3所在位置：" + resultPosition);
    }


}
