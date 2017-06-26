package Leetcode;

/**
 * Created by hadoop on 17-6-6.
 */
public class TargetSum {
    /*public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < S || (S + sum) % 2 > 0)
            return 0;
        sum = (S+sum)/2;

        //int[] dp = new int[sum+1];
        int[][] dp = new int[nums.length][sum+1];
        dp[0] = 1;
        for(int i = 0;i<nums.length;i++){
            for(int num: nums){
                dp[i][]
            }
        }
        for(int num : nums){
            for(int i = sum;i >= num;i--){
                dp[][] += dp[i - num];
            }
        }

        return dp[sum];
    }*/
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
    public static void main(String[] args){
        int[] arr = {1,1,1,1,1};
        TargetSum test = new TargetSum();
        System.out.println(test.findTargetSumWays(arr,3));
    }
}
