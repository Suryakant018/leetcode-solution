

class Solution {
    public String largestNumber(int[] nums) {
        
        int n=nums.length;
        String snums[]=new String[n];
        int countZero=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                countZero++;
            }
            snums[i]=Integer.toString(nums[i]);
        }
        if(countZero==n)
        {
            return "0";
        }
        Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
	     };
		
		Arrays.sort(snums, comp);
        String s="";
        for(int i=0;i<n;i++)
        {
            s=s+snums[i];
        }
        return s;
    }
}