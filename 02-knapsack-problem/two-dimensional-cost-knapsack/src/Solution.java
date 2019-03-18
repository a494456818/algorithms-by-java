/**
 * 二维费用的背包问题是指：对于每件物品，具有两种不同的费用，
 * 选择这件物品就必须付出这两种代价，每种代价都有可付出的最大值（背包容量）
 * 问怎么选择物品才能得到最大价值.费用增加了一维，那么只需要状态增加一维就可以了、
 * dp[i][j][k]  前i件物品付出两种代价为j和k的最大价值
 * dp[i][j][k] = max(dp[i-1][j][k],dp[i-1][j-a[i]][k-b[i]]);
 * 根据背包的思想，可将状态压缩为二维的.
 * 只不过是费用增加了一维，所以01背包，完全背包，多重完全背包的思想完全
 * 可以用在这里
 */
public class Solution {

    /**
     * @param w：                  物品的重量（cost1）
     * @param volume：物品的体积（cost2）
     * @param v：                  物品的价值
     * @param nums：               每个物品的数量
     * @param C：                  背包的最大重量
     * @param V：                  背包的最大体积
     * @return 在限制条件C和V下，背包装的最大价值量
     */
    public int twoDimensionalCostKnapsack(int[] w, int[] volume, int[] v, int[] nums, int C, int V) {
        if (w == null || v == null || volume == null || w.length != v.length || w.length != nums.length || w.length != volume.length)
            throw new IllegalArgumentException("Invalid w, volume, v or nums");
        if (C < 0 || V < 0)
            throw new IllegalArgumentException("C or V must be greater or equal to zero.");
        int n = nums.length; // 物品的数量
        int[][][] memo = new int[n][C + 1][V + 1];
        // 初始化第1件物品
        for (int i = 0; i < C; i++) { // 重量
            for (int j = 0; j < V; j++) { // 体积
                if (w[0] <= C && volume[0] <= V)
                    memo[0][i][j] = v[0];
            }
        }
        // 动态规划
        for (int i = 1; i < n; i++) { // 物品
            for (int j = 0; j < C; j++) { // 重量
                for (int k = 0; k < V; k++) { // 体积
                    memo[i][j][k] = Math.max(memo[i - 1][j][k], memo[i - 1][j - w[i]][k - volume[i]]);
                }
            }
        }
        return memo[n - 1][C][V];
    }

}
