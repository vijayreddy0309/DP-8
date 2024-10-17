// Recursive solution. Checking all paths
// TC: exponential-- O(2^n)
// SC: O(n)
class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle,0,0);
    }
    private int helper(List<List<Integer>> triangle, int i, int j) {
        if(i == triangle.size()) 
            return 0;
        int case1 = helper(triangle, i+1, j);
        int case2 = helper(triangle, i+1, j+1);
        return triangle.get(i).get(j) + Math.min(case1,case2);
    }
}

// Recursion with memoization
// TC: O(n2)
// SC: O(n2)
class Solution {
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        this.memo = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        return helper(triangle,0,0);
    }
    private int helper(List<List<Integer>> triangle, int i, int j) {
        if(i == triangle.size()) 
            return 0;
        if(memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        int case1 = helper(triangle, i+1, j);
        int case2 = helper(triangle, i+1, j+1);
        int re = triangle.get(i).get(j) + Math.min(case1,case2);
        memo[i][j] = re;
        return re;
    }
}

// DP Solution
// TC: O(n2)
// SC: O(n2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(
                    dp[i+1][j], dp[i+1][j+1]
                );
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}


//DP Solution
//TC: O(n2)
//SC: O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,triangle.get(i).get(j)+min);
            }
        }
        return triangle.get(0).get(0);
    }
}