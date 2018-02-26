package Sort;

import java.util.Stack;

/**
 * Created by yuan on 2018/2/19.
 */
public class QuickSort {
    static int partition(int[] nums, int left, int right) {
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > tmp)
                right --;
            nums[left] = nums[right];

            while (left < right && nums[left] < tmp)
                left ++;
            nums[right] = nums[left];
        }
        nums[left] = tmp;

        return left;
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
//        quickSortRecursive(nums, 0, nums.length - 1);
        quickSortIteration(nums);
        printArray(nums);

    }
}
