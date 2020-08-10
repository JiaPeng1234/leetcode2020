https://leetcode.com/problems/permutations/
// Jiacheng Yang
// Runtime: 4 ms
// Memory Usage: 7.5 MB

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> visited(nums.size());
        vector<int> curr;
        dfs(nums, visited, curr, res);
        return res;            
    }
private:
    void dfs(const vector<int>& nums, vector<int>& visited, vector<int>& curr, vector<vector<int>>& res){
        if(curr.size() == nums.size())
            res.push_back(curr);
        for(int i = 0; i < nums.size(); i++)
        {
            if(!visited[i])
            {
                visited[i] = 1;
                curr.push_back(nums[i]);
                dfs(nums, visited, curr, res);
                curr.pop_back();
                visited[i] = 0;
            }
        }
    }
};

