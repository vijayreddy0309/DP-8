//Iterate over the entire array and check all the possible slices (Bruteforce)
// TC: O(n2)
// SC:O(1)
class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n-2;i++) {
            for(int j=i+2;j<n;j++) {
                if(nums[j] - nums[j-1] != nums[j-1] - nums[j-2]) break;
                else count++;
            }
        }
        return count;
    }
}


// DP Solution
// TC: O(n)
// SC: O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;
        for(int i=2;i<n;i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}


// DP Solution
// TC: O(n)
// SC: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int current = 0;
        int count = 0;
        for(int i=2;i<n;i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                current += 1;
                count+= current;
            } else {
                current = 0;
            }
        }
        return count;
    }
}