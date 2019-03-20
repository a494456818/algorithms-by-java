/**
 * 动态规划：
 * 时间复杂度：O(n)
 * 空间复杂度：O(n^2)
 */
public class Solution1 {

    int getLongestCommonSubsequence(String s, String t) {
        if (s == null || t == null)
            throw new IllegalArgumentException("Invalid s or t");
        if (s.length() == 0 || t.length() == 0)
            return 0;
        int m = s.length(), n = t.length();

        int[][] memo = new int[m + 1][n + 1];
        memo[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        String s = "123456";
        String t = "34353869";
        Solution1 solution = new Solution1();
        int ans = solution.getLongestCommonSubsequence(s,t);
        System.out.println(ans);
    }

}
