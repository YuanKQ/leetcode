/******************************
 * User: yuan
 * Date: 18-5-9 上午10:05
 * Email: kq_yuan@outlook.com
 *
 * Description: 希尔排序
 *              avg:    < O(n^2), it depends gap
 *              best:   O(nlogn)
 *              worst:  O(n^2) for gap here, different gaps have different worst time complexity
 *              space:  O(1)
 *              不稳定
 ******************************/
package Sort;

import java.util.Arrays;

public class ShellSort {
    static void shellSortAscending(int[] arr){
        System.out.println("Before: " + Arrays.toString(arr));
        //int gap = 1;
        //while (gap < arr.length/3)
        //    gap = gap * 3 + 1;
        for (int gap = arr.length/2; gap > 0; gap /= 2)
            for (int i = gap; i < arr.length; i ++){
                int tmp = arr[i];
                int j = i - gap;
                for (; j >= 0 && arr[j] > tmp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = tmp;
            }
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("============");
    }


    static void shellSortDescending(int[] arr){
        System.out.println("Before: "+ Arrays.toString(arr));
        // int gap = 1;
        // while (gap < arr.length / 3)
        //     gap = gap * 3 + 1;
        for (int gap = arr.length/2; gap > 0; gap /= 2)
            for (int i = gap; i < arr.length; i ++){
                int tmp = arr[i];
                int j = i - gap;
                for (; j >= 0 && arr[j] < tmp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = tmp;
            }

        System.out.println("After:  "+ Arrays.toString(arr));
        System.out.println("=============");
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        shellSortDescending(arr);
        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
        shellSortDescending(arr1);
        int[] arr2 = {61,92,13,4,35,26,77};
        shellSortDescending(arr2);
    }
}
