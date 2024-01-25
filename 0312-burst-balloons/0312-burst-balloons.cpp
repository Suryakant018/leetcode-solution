class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int s = nums.size();
        nums.insert(nums.begin(),1);
        nums.push_back(1);

        vector<vector<int>> dp(s+2,vector<int>(s+2,0));

        for(int i=s;i>=1;i--){
            for(int j=1;j<=s;j++){
                if(i>j) continue;

                int maxi = INT_MIN;
                for(int ind = i;ind<=j;ind++){
                    int ans = (nums[i-1]*nums[ind]*nums[j+1]) + (dp[i][ind-1] + dp[ind+1][j]);

                    maxi = max(maxi,ans);
                }

                dp[i][j] = maxi;
            }
        }

        return dp[1][s];
    }
};

