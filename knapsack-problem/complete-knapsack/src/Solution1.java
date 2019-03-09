// 完全背包问题
// 动态规划
// 时间复杂度：O(n*C) n为物品数量，C为背包容量
// 空间复杂度：O(n*C)
// f(i,C) = max(v(i)+f(i-1,C-w(i)):选择物品i并选择物品i-1,
//          v(i)+f(i,C-w(i):选择物品i并选择物品i,
//          f(n-1,C):不选择物品i))
public class Solution1 {

    /**
     * @param w : weight 物品的重量
     * @param v : value 物品的价值
     * @param C : Capacity 背包的容量
     * @return
     */
    public int complteKnapsack(int[] w, int[] v, int C) {
        if (w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v.");
        if (C < 0)
            throw new IllegalArgumentException("C must be greater or equal to 0.");
        int n = w.length;
        int[][] memo = new int[n][C + 1];
        int t = 1;

        // 初始化第一个物品
        for (int i = 0; i < C + 1; i++) {
            if (i - t * w[0] < 0)
                memo[0][i] = (t - 1) * v[0];
            else
                memo[0][i] = (t++) * v[0];
        }

        for (int i = 1; i < n; i++)
            for (int j = 0; j < C + 1; j++) {
                memo[i][j] = memo[i - 1][j];// 不选择物品i
                if (j - w[i] >= 0) {
                    int temp1 = v[i] + memo[i - 1][j - w[i]]; //选择物品i并选择物品i-1
                    int temp2 = v[i] + memo[i][j - w[i]]; //选择物品i并选择物品i
                    memo[i][j] = Math.max(memo[i][j], Math.max(temp1, temp2));
                }
            }

        return memo[n - 1][C];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int ans = solution.complteKnapsack(new int[]{2, 3, 4, 7}, new int[]{1, 3, 5, 9}, 10);
        System.out.println("answer is : " + ans);
    }
}
