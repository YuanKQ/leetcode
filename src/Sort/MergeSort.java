/******************************
 * User: yuan
 * Date: 18-4-17 下午11:08
 * Email: kq_yuan@outlook.com
 *
 * Description:  归并排序
 *               avg:  O(nlogn)
 *               best: O(nlogn)
 *               worst:O(nlogn)
 *               space:O(n)
 *               稳定
 *
 ******************************/
package Sort;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] array){
        if (array == null || array.length == 0 || array.length == 1)
            return ;
        int[] copy = new int[array.length];
       helpMergeSort(array, copy, 0, array.length-1);
    }

    private void helpMergeSort(int[] array, int[] copy, int low, int high) {
        if (low >= high)
            return ;
        int mid = (low + high) >> 1;
        helpMergeSort(array, copy, low, mid);
        helpMergeSort(array, copy, mid+1, high);
        int icopy = high;
        int i = mid;
        int j = high;
        while (i >= low && j > mid){
            if (array[i] > array[j])
                copy[icopy --] = array[i --];
            else
                copy[icopy --] = array[j --];
        }
        while (i >= low)
            copy[icopy --] = array[i --];
        while (j > mid)
            copy[icopy --] = array[j --];
        for (int s = low; s <= high; s ++)
            array[s] = copy[s];
        return ;
    }

    private static void helpMergeSort(int[] array, int low, int mid, int high) {
        int[] copy = array.clone();
        int i = mid;
        int j = high;
        int cIndex = high;
        while (i >= low && j > mid){
            if (array[i] > array[j])
                copy[cIndex --] = array[i--];
            else
                copy[cIndex --] = array[j--];
        }
        while (i >= low){
            copy[cIndex --] = array[i--];
        }
        while (j > mid){
            copy[cIndex --] = array[j--];
        }

        for (int s = low; s <= high; s ++)
            array[s] = copy[s];
        return ;
    }

    public static void mergeSortIterative(int[] array){
        System.out.println("Before: " + Arrays.toString(array));
        int len = 1;
        int low = 0, mid = 0, high = 0;
        while (len < array.length){
            for(int i = 0; i + len < array.length; i += 2*len){
                low = i;
                mid = i + len - 1;
                high = i + 2*len > array.length? array.length-1: i + 2*len-1;
                helpMergeSort(array, low, mid, high);
            }
            len *= 2;
        }
        System.out.println("After: " + Arrays.toString(array));
        System.out.println("=================");
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        mergeSortIterative(arr);
        int[] arr1 = {91,82,73,64,55,46,37,25,14,3};
        mergeSortIterative(arr1);
        int[] arr2 = {61,92,13,4,35,26,77};
        mergeSortIterative(arr2);

    }
}
