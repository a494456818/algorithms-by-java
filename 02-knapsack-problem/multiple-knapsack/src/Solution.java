// 多重背包问题
// 动态规划
// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
// 空间复杂度: O(n * C)

import java.util.ArrayList;
import java.util.List;

/**
 * 只需要将多重背包问题转换成01背包问题即可。
 */
public class Solution {

    /**
     * @param w    : 物品的重量
     * @param v    : 物品的价值
     * @param nums : 每个物品的数量
     * @param C    : 背包的容量
     * @return
     */
    public int knapsack01(int[] w, int[] v, int[] nums, int C) {
        if (w == null || v == null || w.length != v.length || w.length != nums.length)
            throw new IllegalArgumentException("Invalid w or v or nums");

        if (C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        // 将相同数量的商品视为不同的商品存储起来
        List<Integer> new_w = new ArrayList<>();
        List<Integer> new_v = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                new_w.add(w[i]);
                new_v.add(v[i]);
            }
        }
        w = new int[new_w.size()];
        v = new int[new_v.size()];
        for (int i = 0; i < new_w.size(); i++) {
            w[i] = new_w.get(i);
            v[i] = new_v.get(i);
        }

        // 以下为01背包的逻辑
        int n = w.length;
        if (n == 0 || C == 0)
            return 0;

        int[][] memo = new int[n][C + 1];

        for (int j = 0; j <= C; j++)
            memo[0][j] = (j >= w[0] ? v[0] : 0);

        for (int i = 1; i < n; i++)
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i])
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }

        return memo[n - 1][C];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.knapsack01(new int[]{2, 2, 6, 5, 4}, new int[]{6, 3, 5, 4, 6}, new int[]{1, 2, 3, 3, 5}, 10);
        System.out.println("answer is : " + ans);
    }
}
