/******************************
 * User: yuan
 * Date: 18-5-9 上午9:21
 * Email: kq_yuan@outlook.com
 *
 * Description: 插入排序
 *              avg:   O(n^2)
 *              best:  O(n)
 *              worst: O(n^2)
 *              space: O(1)
 *              稳定
 ******************************/
package Sort;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSortAscending(int arr[]){
        System.out.println("Before: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i ++)
            for (int j = i+1; j > 0; j --){
                if (arr[j-1] < arr[j]) {
                    break;
                }
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("============");
    }

    static void insertionSortDescending(int arr[]){
        System.out.println("Before: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i ++)
            for (int j = i+1; j > 0; j --){
               if (arr[j-1] > arr[j])
                   break;
               int tmp = arr[j];
               arr[j] = arr[j-1];
               arr[j-1] = tmp;
            }
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("===========");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        insertionSortDescending(arr);
        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
        insertionSortDescending(arr1);
        int[] arr2 = {61,92,13,4,35,26,77};
        insertionSortDescending(arr2);
    }
}
