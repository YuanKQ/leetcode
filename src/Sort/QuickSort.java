package Sort;

import java.util.Stack;

/******************************
 * User: yuan
 * Date: 18-5-9 上午10:05
 * Email: kq_yuan@outlook.com
 *
 * Description: 希尔排序
 *              avg:    O(nlogn)
 *              best:   O(nlogn)
 *              worst:  O(n^2)
 *              space:  O(1)
 *              不稳定
 ******************************/

public class QuickSort <T> {
    static int partition(int[] nums, int left, int right) {
        /**
         * 从小到大的排序：将大于pivot的数往后移，将小于pivot的数往前移
         */
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) // skip nums[i] that equals pivot
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) // skip nums[i] that equals pivot
                left++;
            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;

//        // Init pivot, better to be random
//        int pivot = nums[left];
//
//        // Begin partition
//        while (left < right) {
//            while (left < right && nums[right] >= pivot) { // skip nums[i] that equals pivot
//                right--;
//            }
//            nums[left] = nums[right];
//            while (left < right && nums[left] <= pivot) { // skip nums[i] that equals pivot
//                left++;
//            }
//            nums[right] = nums[left];
//        }
//
//        // Recover pivot to array
//        nums[left] = pivot;
//        return left;

        /*
        // 虽然更容易理解，但时间复杂度略高
        int pivot = nums[right];
        int preL = left, preR = right;
        while (left < right) {
            while (nums[left] < pivot)
                left ++;
            while (nums[right] > pivot)
                right --;
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return right;*/
    }

    static int partition_reverse(int[] nums, int left, int right) {
        /**
         * 从大到小的排序：将小于pivot的数往后移，将大于pivot的数往前移
         */

        int pivot = nums[left];
        while (left < right) {  // 注意循环结束的条件
            while (left < right && nums[right] <= pivot)
                right --;
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot)
                left ++;
            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;

        /*
        // 虽然更容易理解，但时间复杂度略高
        int pivot = nums[(left + right) / 2];
        int preL = left, preR = right;
        while (left < right) {
            while (nums[left] > pivot)
                left ++;
            while (nums[right] < pivot)
                right --;
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return right;
        */
    }

    static void quickSortRecursive(int[] nums, int left, int right) {
        if (left >= right)
            return ;
        int middle = partition(nums, left, right);
        quickSortRecursive(nums, left, middle - 1);
        quickSortRecursive(nums, middle + 1, right);
    }



    static void quickSortIteration(int[] nums) {
        int middle = 0, left = 0, right = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(nums.length - 1);
        while (! stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            middle = partition(nums, left, right);
            if (left < middle - 1) {
                stack.push(left);
                stack.push(middle - 1);
            }
            if (middle + 1 < right) {
                stack.push(middle + 1);
                stack.push(right);
            }
        }
    }

    static void printArray(int[] nums) {
        for (int num: nums) {
            System.out.print(num);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 1, 9, 8, 6, 5};
        printArray(nums);
        quickSortRecursive(nums, 0, nums.length - 1);
//        quickSortIteration(nums);
        printArray(nums);

    }
}
