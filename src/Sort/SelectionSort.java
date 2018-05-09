/******************************
 * User: yuan
 * Date: 18-5-9 上午11:27
 * Email: kq_yuan@outlook.com
 *
 * Description: 选择排序：在未排序序列中找到最小（大）元素，存放到未排序序列的起始位置，减少了移动次数
 *              avg:  O(n^2)
 *              best: O(n^2)
 *              worst:O(n^2)
 *              space:O(1)
 *              不稳定
 ******************************/
package Sort;

import java.util.Arrays;

public class SelectionSort {
    static void selectionSortAscending(int[] arr){
        System.out.println("Before:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i ++){
            int min = i;
            for (int j = i+1; j < arr.length; j ++)
                if (arr[j] < arr[min])
                    min = j;
            if (min != i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("=========");
    }

    static void selectionSortDescending(int[] arr){
        System.out.println("Before:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i ++){
            int min = i;
            for (int j = i+1; j < arr.length; j ++)
                if (arr[j] > arr[min])  // 改动在这里！！！
                    min = j;
            if (min != i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("=========");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        selectionSortAscending(arr);
        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
        selectionSortAscending(arr1);
        int[] arr2 = {61,92,13,4,35,26,77};
        selectionSortAscending(arr2);
    }
}
