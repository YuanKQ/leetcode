/******************************
 * User: yuan
 * Date: 18-5-10 上午9:01
 * Email: kq_yuan@outlook.com
 *
 * Description: 堆排序
 *              avg:   O(nlogn)
 *              best:  O(nlogn)
 *              worst: O(nlogn)
 *              space: O(1)
 *              不稳定
 *
 ******************************/
package Sort;

import java.util.Arrays;

public class HeapSort {
    static void heapSortAscending(int[] arr, int k){
        System.out.println("Before: " + Arrays.toString(arr));
        for (int i = arr.length; i > arr.length - k; i --){
            maxHeapify(arr, i);

            int tmp = arr[i-1];
            arr[i-1] = arr[0];
            arr[0] = tmp;
        }
        System.out.println("After: "+ Arrays.toString(arr));
    }


    private static void maxHeapify(int[] arr, int limit) {
        /**
         * heapSortAscending + maxHeapify:正序
         */
        int parrent = limit / 2;
        int left = 0;
        int right = 0;
        for (; parrent >= 0; parrent --){
            left = parrent * 2;
            if (left < limit) {
                right = left + 1 >= limit ? left : left + 1;
                int biggerIndex = arr[left] > arr[right] ? left : right;
                if (arr[parrent] < arr[biggerIndex]) {
                    int tmp = arr[biggerIndex];
                    arr[biggerIndex] = arr[parrent];
                    arr[parrent] = tmp;
                }
            }
        }
    }

    static void heapSortDescending(int[] arr, int k) {
        System.out.println("Before: " + Arrays.toString(arr));
        for (int i = arr.length; i > arr.length - k; i --){
            minHeapify(arr, i);

            int tmp = arr[i-1];
            arr[i-1] = arr[0];
            arr[0] = tmp;
        }
        System.out.println("After: "+ Arrays.toString(arr));
    }

    private static void minHeapify(int[] arr, int limit) {
        /**
         * heapSortDescending + minHeapify:逆序
         */
        int parentIndex = (limit-1) / 2;
        int left = 0, right = 0;
        for (; parentIndex >= 0; parentIndex --){
            left = parentIndex * 2+1;
            if (left < limit){
                right = left + 1 >= limit? left: left+1;
                int childIndex = arr[left] < arr[right]? left: right; // 找到最小的子节点
                if (arr[parentIndex] > arr[childIndex]) { // 保证父节点小于子节点
                    int tmp = arr[parentIndex];
                    arr[parentIndex] = arr[childIndex];
                    arr[childIndex] = tmp;
                }
            }
        }
    }

    static void kLargestElements(int[] arr, int k) {
        heapSortAscending(arr, k);
        System.out.println("K max elements: ");
        for (int i = arr.length-1; i >= arr.length-k; i --){
            System.out.print(arr[i]);
            System.out.println(" ");
        }
    }

    static void kSmallestElements(int[] arr, int k) {
        heapSortDescending(arr, k);
        System.out.println("K min elements: ");
        for (int i = arr.length-1; i >= arr.length-k; i --){
            System.out.print(arr[i]);
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        kSmallestElements(arr, 4);
        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
        kSmallestElements(arr1, 4);
        int[] arr2 = {61,92,13,4,35,26,77};
        kSmallestElements(arr2, 4);

//        int[] arr = {1,2,3,4,5,6,7};
//        heapSortDescending(arr, arr.length);
//        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
//        heapSortDescending(arr1, arr.length);
//        int[] arr2 = {61,92,13,4,35,26,77};
//        heapSortDescending(arr2, arr.length);
        /*int[] arr = {1,2,3,4,5,6,7};
        kLargestElements(arr, 4);
        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
        kLargestElements(arr1, 4);
        int[] arr2 = {61,92,13,4,35,26,77};
        kLargestElements(arr2, 4);
         */

    }

}
