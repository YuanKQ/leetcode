/******************************
 * User: yuan
 * Date: 18-4-17 下午11:08
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package Sort;

import com.sun.org.apache.regexp.internal.REUtil;

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

    public static void main(String[] args) {
        int[] array = {10, 1, 4, 7, 5, 9, 24};
        new MergeSort().mergeSort(array);
        for (int a: array)
            System.out.println(a);
    }
}
