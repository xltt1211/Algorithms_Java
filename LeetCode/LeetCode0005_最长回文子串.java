package LeetCode;

/***
 *题目描述
 给你一个字符串 s，找到 s 中最长的回文子串
 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

 示例 1：
 输入：s = "babad"
 输出："bab"
 解释："aba" 同样是符合题意的答案。

 示例 2：
 输入：s = "cbbd"
 输出："bb"

 提示：
 1 <= s.length <= 1000
 s 仅由数字和英文字母组成

 * 解题思想
 * https://www.bilibili.com/video/BV1AA411B7XV/?spm_id_from=333.337.search-card.all.click&vd_source=535474508e5ca95a86f0603784e2b70d
 *
 *
 */
public class LeetCode0005_最长回文子串 {
    public static String LongestSubstring(String str) {
        int n = str.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for(int l=0; l<n;l++) {
            for(int i=0; i+l<n;i++) {
                int j = i+l;
                if(l==0) {
                    dp[i][j] = true;
                } else if (l==1) {
                    dp[i][j] = (str.charAt(i)==str.charAt(j));
                }else {
                    dp[i][j] = str.charAt(i)==str.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && l+1>ans.length()) {
                    ans = str.substring(i,i+l+1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(LongestSubstring(str));
    }
}
