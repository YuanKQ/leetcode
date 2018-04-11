/******************************
 * User: yuan
 * Date: 18-4-10 下午3:51
 * Email: kq_yuan@outlook.com
 *
 * Description:
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 ******************************/
package JobHunter;

import java.util.ArrayList;

public class FindKSmallestElements {
    // 堆排序
    void buildMaxHeap(int[] array, int lastIndex){
        for (int j = (lastIndex - 1)/2; j >= 0; j --)
            adjustHeap(array, j, lastIndex);
    }

    private void adjustHeap(int[] array, int j, int lastIndex) {
        while (true) {
            int left = j * 2 + 1;
            int right = j * 2 + 2;
            int bigger = j;
            if (right <= lastIndex) {
                if (array[left] > array[j] && array[left] > array[right])
                    bigger = left;
                if (array[right] > array[j] && array[right] > array[left])
                    bigger = right;
            } else if (left <= lastIndex) {
                if (array[left] > array[j])
                    bigger = left;
            }

            if (bigger != j) {
                swap(array, j, bigger);
                j = bigger;
            } else return;
        }
    }

    // 前k个元素的lastIndex=k-1
    ArrayList<Integer> KHeapSort(int[] array, int k){
        ArrayList<Integer> rs = new ArrayList<>();
        if (array == null || array.length == 0 || k > array.length)
            return rs;
        int lastIndex = k - 1;
        buildMaxHeap(array, lastIndex);
        int nextIndex = k;
        while (nextIndex < array.length){
            if (array[nextIndex] < array[0]){
                swap(array, 0, nextIndex);
                adjustHeap(array, 0, lastIndex);
            }
            nextIndex ++;

        }
        for (int i = 0; i < k; i ++)
            rs.add(array[i]);
        return rs;
    }

    ArrayList<Integer> HeapSort(int[] array){
        ArrayList<Integer> rs = new ArrayList<>();
        if (array == null || array.length == 0)
            return rs;
        int lastIndex = array.length - 1;
        buildMaxHeap(array, lastIndex);
        while (lastIndex >= 0){
            swap(array, 0, lastIndex);
            rs.add(array[lastIndex]);
            lastIndex --;
            adjustHeap(array, 0, lastIndex);
        }

        return rs;
    }

    void swap(int[] array, int oldIndex, int newIndex){
        int tmp = array[oldIndex];
        array[oldIndex] = array[newIndex];
        array[newIndex] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 8, 3};
//        ArrayList<Integer> rs = new FindKSmallestElements().KHeapSort(array, 4);
        ArrayList<Integer> rs = new FindKSmallestElements().HeapSort(array);
        for (int item: rs)
            System.out.println(item);
    }
}
