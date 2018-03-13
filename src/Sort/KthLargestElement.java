/******************************
 * User: yuan
 * Date: 18-3-11 上午11:20
 * Email: kq_yuan@outlook.com
 *
 * Description: [LeetCode #215]
   Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
   For example,
   Given [3,2,1,5,6,4] and k = 2, return 5.

   Note:
   You may assume k is always valid, 1 ≤ k ≤ array's length.

   Credits:
   Special thanks to @mithmatt for adding this problem and creating all test cases.
 *
 ******************************/
package Sort;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int p = nums[start + (end - start) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && nums[i] < p) {
                i++;
            }
            while (i <= j && nums[j] > p) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        if (k <= j) {
            return quickSelect(nums, start, j, k);
        } else if (k >= i) {
            return quickSelect(nums, i, end, k);
        }
        return nums[k];
    }
}
