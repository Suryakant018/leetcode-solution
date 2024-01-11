class Solution {
public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] temp = new int[101]; // 101 because input values are between 0 and 100.
        Arrays.fill(temp, Integer.MIN_VALUE); // Keeping it min value to distingush from other values.
        int[] res = new int[2];
        int f=0, s=0;
        for (int i : nums1){
            temp[i]=temp[i]==Integer.MIN_VALUE?1:(temp[i]+1);
        }
        for (int j: nums2){
            if(temp[j]!=Integer.MIN_VALUE){
                if (temp[j]>0) {
                    res[0]+=temp[j];
                    temp[j]=-1; // if we find the element in second array then assign a value which is not Integer.MIN_VALUE to notify the next iteration that the first array had this element and also to notify that the it shouldnt be accounted for res[0] again as it is already been counted. 
                }
                res[1]+=1;
            }
        }
        return res;
    }
}