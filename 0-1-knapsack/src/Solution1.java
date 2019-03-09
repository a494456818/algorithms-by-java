// 0-1背包问题
// 记忆化搜索
// 时间复杂度：O(n*C) n为物品的个数；C为背包容量
// 空间复杂度：O(n*C)
public class Solution1 {

    private int[][] memo;

    /**
     * @param w : 物品的重量
     * @param v : 物品的价值
     * @param C : 背包的容量
     * @return
     */
    public int knapsack01(int[] w, int[] v, int C) {

        if (w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if (C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if (n == 0 || C == 0)
            return 0;

        memo = new int[n][C + 1];
        return bestValue(w, v, n - 1, C);
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (c <= 0 || index < 0)
            return 0;

        if (memo[index][c] != 0)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c);
        if (c > w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        return memo[index][c] = res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int ans = solution.knapsack01(new int[]{2, 2, 6, 5, 4}, new int[]{6, 3, 5, 4, 6}, 10);
        System.out.println("answer is : " + ans);
    }
}
