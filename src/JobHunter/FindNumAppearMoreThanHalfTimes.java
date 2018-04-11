/******************************
 * User: yuan
 * Date: 18-4-10 上午10:28
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

public class FindNumAppearMoreThanHalfTimes {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null)
            return 0;
        if (array.length == 1)
            return array[0];
        int k = (array.length + 1) / 2;
        return array[findKthElement(array, k, 0, array.length-1)];
    }

    int findKthElement(int[] array, int k, int start, int end){
        if (start >= end)
            return start;
        int split = partition(array, start, end);
        if (k == split)
            return array[split];
        if (k > split)
            return findKthElement(array, k, split+1, end);
        else
            return findKthElement(array, k, start, split-1);
    }

    int partition(int[] array, int start, int end){
        int flag = array[start];
        while (start < end){
            while (start < end && array[end] >= flag)
                end --;
            array[start] = array[end];
            while (start < end && array[start] <= flag)
                start ++;
            array[end] = array[start];
        }

        array[start] = flag;
        return start;
    }

    public static void main(String[] args) {
     int[] array = {1,2,3,2,2,2,5,4,2};
     System.out.println(new FindNumAppearMoreThanHalfTimes().MoreThanHalfNum_Solution(array));
    }
}
