class NumArray {
public:
    vector<int> block, v;
    int n, bs;
    NumArray(vector<int>& nums) {
        v = nums;
        n = nums.size();
        bs = ceil(sqrt(n));
        block.resize(n, 0);
        for (int i = 0; i < nums.size(); i++)
            block[i / bs] += nums[i];
    }
    
    void update(int index, int val) {
        block[index / bs] += val - v[index];
        v[index] = val;
    }
    
    int sumRange(int left, int right) {
        int sum = 0;
        int stB = left / bs;
        int endB = right / bs;
        // if start block and end block same
        if (stB == endB) {
            for (int i = left; i <= right; i++)
                sum += v[i];
            return sum;
        }
        else {
            // for the blocks in between
            for (int i = stB + 1; i < endB; i++) {
                sum += block[i];
            }
            // for first block only
            while (left / bs == stB)
                sum += v[left++];
            // for the last block
            while (right / bs == endB)
                sum += v[right--];
        }
        return sum;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */