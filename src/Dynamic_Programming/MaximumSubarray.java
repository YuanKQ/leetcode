package Dynamic_Programming;

/**
 * [LeetCode #53]
 *
 * Created by yuan on 2018/2/18.
 *
 * Description:
   Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

   For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
   the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        /*
        dp[i]是子序列为nums[i]的最大子序列和。
         */
        int[] dp = new int[nums.length];
        // int[] start = new int[nums.length];
        // int startIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                dp[i] = nums[i];
                // start[i] = i;
            } else {
                if (nums[i] > nums[i] + dp[i - 1]) {
                    dp[i] = nums[i];
                    // start[i] = i;
                } else {
                    dp[i] = nums[i] + dp[i - 1];
                    // start[i] = start[i - 1];
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                // startIndex = start[i];
            }

        }

        return max;
    }


    public int maxSubArray_improved(int[] nums) {
        int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere += nums[i];
            if (maxEndingHere > maxSoFar) maxSoFar = maxEndingHere;
            if (maxEndingHere < 0) maxEndingHere = 0;
        }
        return maxSoFar;
    }

}
