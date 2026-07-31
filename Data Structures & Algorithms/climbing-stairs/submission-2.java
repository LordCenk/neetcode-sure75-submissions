class Solution {
    public int climbStairs(int n) {
        Integer[] memo = new Integer[n + 1];
        return dfs(n, 0, memo);
    }
    public int dfs(int n, int i, Integer[] memo){
        if(i >= n) return i == n ? 1 : 0;
        if(memo[i] != null) return memo[i];
        return memo[i] = dfs(n, i + 1, memo) + dfs(n, i + 2, memo);
    }
}