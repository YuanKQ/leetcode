package Dynamic_Programming;

/**
 *  [LeetCode #198]
 *
 * Created by yuan on 2018/2/19.
 *
 * Description:
   You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
   the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
   it will automatically contact the police if two adjacent houses were broken into on the same night.

   Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
   money you can rob tonight without alerting the police.
 */


public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int max = nums[0] > nums[1] ? nums[0]: nums[1];
        if (nums.length == 2)
            return max;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i ++) {
            dp[i] = dp[i - 1];
            for (int j = 2; j <= i; j ++)
                if (dp[i - j] + nums[i] > dp[i])
                    dp[i] = dp[i - j] + nums[i];

            if (max < dp[i])
                max = dp[i];
        }

        return max;
    }


    public int robImproved(int[] nums) {
        int rob = 0, not_rob = 0, tmp = 0;
        for (int i = 0; i < nums.length; i ++) {
            tmp = rob;
            rob = not_rob + nums[i];
            not_rob = Math.max(tmp, not_rob);
        }

        return Math.max(rob, not_rob);
    }

}
