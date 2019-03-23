/**
 * 最长公共子序列（Longest common subsequence）
 * 递归思想：
 * 假设有字符串s和t
 * if (s[i] == t[j]) 最长公共子序列长度+1，i++,j++
 * if (s[i] != t[j]) 有两种情况：
 * 1. 比较s[i+1]和t[j]
 * 2. 比较s[i]和t[j+1]
 */
public class Solution {

    int getLongestCommonSubsequence(String s, String t) {
        if (s == null || t == null)
            throw new IllegalArgumentException("Invalid s or t");
        if (s.length() == 0 || t.length() == 0)
            return 0;
        int m = s.length(), n = t.length();
        return getLongestCommonSubsequence(s, 0, t, 0);
    }

    // 在s[si,...,s.length())和t[ti,...,t.length())中寻找最长公共子串
    private int getLongestCommonSubsequence(String s, int si, String t, int ti) {
        if (si >= s.length() || ti >= t.length())
            return 0;
        if (s.charAt(si) == t.charAt(ti))
            return 1 + getLongestCommonSubsequence(s, si + 1, t, ti + 1);
        return Math.max(getLongestCommonSubsequence(s, si + 1, t, ti), getLongestCommonSubsequence(s, si, t, ti + 1));
    }

    public static void main(String[] args) {
        String s = "123456";
        String t = "34353869";
        Solution solution = new Solution();
        int ans = solution.getLongestCommonSubsequence(s,t);
        System.out.println(ans);
    }

}
