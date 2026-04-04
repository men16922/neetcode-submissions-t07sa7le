class Solution {
    public int minCostClimbingStairsDfs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    public int dfs(int [] cost, int i) {
        if (i >= cost.length) return 0;
        return cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
    }

    public int minCostClimbingStairsDp(int[] cost) {
        int len = cost.length;
        int [] dp = new int [len + 1];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }

    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }

}
