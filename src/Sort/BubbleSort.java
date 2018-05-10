/******************************
 * User: yuan
 * Date: 18-5-10 上午10:25
 * Email: kq_yuan@outlook.com
 *
 * Description: 冒泡排序
 *              avg:   O(n^2)
 *              best:  O(n)  增加标识位
 *              worst: O(n^2)
 *              space: O(1)
 *              稳定
 *
 ******************************/
package Sort;

import java.util.Arrays;

public class BubbleSort {
    static void bubbleSortAscending(int[] arr) {
        System.out.println("Before: " + Arrays.toString(arr));
        boolean flag = false; // 加了标识位，使得bubblesort最佳情况下只需要O(n)
        for (int i = arr.length-1; i > 0 && !flag; i --) {
            flag = true;
            for (int j = 0; j + 1 <= i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }


    static void bubbleSortDescending(int[] arr) {
        System.out.println("Before: " + Arrays.toString(arr));
        boolean flag = false; // 加了标识位，使得bubblesort最佳情况下只需要O(n)
        for (int i = arr.length-1; i > 0 && !flag; i --) {
            flag = true;
            for (int j = 0; j + 1 <= i; j++) {
                if (arr[j] < arr[j + 1]) {
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        bubbleSortDescending(arr);
        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
        bubbleSortDescending(arr1);
        int[] arr2 = {61,92,13,4,35,26,77};
        bubbleSortDescending(arr2);
    }
}
