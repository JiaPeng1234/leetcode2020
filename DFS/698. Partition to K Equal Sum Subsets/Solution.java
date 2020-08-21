// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

/**
By Jiapeng
DFS
Runtime: 2 ms, faster than 68.25% of Java online submissions for Partition to K Equal Sum Subsets.
Memory Usage: 37.3 MB, less than 60.73% of Java online submissions for Partition to K Equal Sum Subsets.
**/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1)
            return true;
        if(k > nums.length)
            return false;
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if(sum % k != 0)
            return false;
        
        int target = sum / k;
        sortByReverse(nums);
        if(nums[0] > target)
            return false;
        
        int[] mask = new int[nums.length];
        return dfs(target, target, nums, k, mask);
    }
    
    private boolean dfs(int target, int rest, int[] nums, int k, int[] mask){
        if(rest == 0){
            k -= 1;
            rest = target;
        }
        if(k == 0)
            return true;
        for(int i = 0; i < nums.length; i++){
            if(mask[i] == 1 || nums[i] > rest)
                continue;
            mask[i] = 1;
            if(dfs(target, rest - nums[i], nums, k, mask))
                return true;
            mask[i] = 0;
        }
        return false;
    }
    
    // sort, from greater to smaller
    private void sortByReverse(int[] nums){
        int l = nums.length;
        for(int i = 0; i < l - 1; i++)
            for(int j = 0; j < l - i - 1; j++){
                if(nums[j] < nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
    }
}
