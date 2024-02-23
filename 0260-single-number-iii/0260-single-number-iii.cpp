class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        vector<int> ans;
        unordered_map<int , int> m;
        int n= nums.size(); 
        for(int i=0; i<n; i++){
            m[nums[i]] += 1;
        }
        for(auto it:m){
            if( it.second == 1){
                ans.emplace_back(it.first);
            }
        }
        return ans;
    }
};