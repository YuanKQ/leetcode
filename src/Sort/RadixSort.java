/******************************
 * User: yuan
 * Date: 18-5-11 下午3:56
 * Email: kq_yuan@outlook.com
 *
 * Description: 基数/桶排序，适用于n值很大而关键字较小的序列 【d 为位数，r 为基数，n 为原数组个数】
 *              avg:  O(d*n)
 *              best: O(d*n)
 *              worst:O(d*n))
 *              space:链式基数排序为O(r+n)，数组实现方式为O(rn)
 *              稳定
 *              本题的基数为10,位数为3。倘若对单词进行基数排序，基数为26，位数
 *
 ******************************/
package Sort;

import java.util.Arrays;

public class RadixSort {
    static void radixSort(int[] arr){
        System.out.println("Before: " + Arrays.toString(arr));
        int max = Integer.MIN_VALUE;
        for (int a: arr)
            if (max < a) {
                max = a;
            }
        int digit = 1;
        while (max / 10 > 0){
            max /= 10;
            digit ++;
        }

        int[][] buckets = new int[10][arr.length];
        int n = 1;
        int bucketIndex = 0;
        while (digit > 0){
            int[] bucketLen = new int[10];
            for (int a: arr){
                bucketIndex = (a / n) % 10;
                buckets[bucketIndex][bucketLen[bucketIndex]] = a;
                bucketLen[bucketIndex] ++;
            }
            int k = 0;
            for (int i = 0; i <= 9; i ++){
                if (bucketLen[i] > 0) {
                    for (int j = 0; j < bucketLen[i]; j++)
                        arr[k++] = buckets[i][j];
                    bucketLen[i] = 0;
                }
            }
            n *= 10;
            digit --;
        }
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("==================");
    }

    public static void main(String[] args) {
        int[] arr = {101, 1, 11, 111, 121, 51};
        radixSort(arr);
        int[] arr1 = {101, 1, 24, 77, 8, 15, 11, 111, 121, 51, 1000};
        radixSort(arr1);

    }

}
