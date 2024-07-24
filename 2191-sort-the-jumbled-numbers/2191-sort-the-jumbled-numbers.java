class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int len = nums.length;
        int[][] resIndMap = new int[len][2];
        for(int i = 0; i < len; i++) {
            int num = nums[i];
            if(num == 0) {
                resIndMap[i][0] = i;
                resIndMap[i][1] = mapping[0];
                continue;
            }
            int temp = 0, ind = 0;
            while(num > 0) {
                int rem = num % 10;
                int numFromMap = mapping[rem];
                temp += numFromMap * (Math.pow(10, ind));
                ind++;
                num /= 10;
            }
            resIndMap[i][0] = i;
            resIndMap[i][1] = temp;
        }

        Arrays.sort(resIndMap, (a,b) -> a[1]-b[1]);
        int[] res = new int[len];
        int ind = 0;
        for(int i[] : resIndMap) {
            res[ind] = nums[i[0]];
            ind++;
        }

        return res;
    }
}
