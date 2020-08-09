// from yangjiacheng
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        std::sort(candidates.begin(), candidates.end());
        vector<vector<int>> res;
        vector<int> curr;
        dfs(candidates, target, 0, curr, res);
        return res;
    }
private:
    void dfs(vector<int>& candidates, int target, int index, vector<int>& curr, vector<vector<int>>& res){
        if(target == 0)
        {
            res.push_back(curr);
            return;                    // 这个return貌似可加可不加
        }
        for(int i = index; i < candidates.size(); i++)
        {
            if(candidates[i] > target)
                break;
            curr.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], i, curr, res);
            curr.pop_back();
        }
    }
};
