class Solution {
    public int minOperations(String s) {
                int i,j,k=0;
        char a[]=s.toCharArray();
        if(a.length==1)
        return 0;
        for(i=0;i<a.length;i++)
        {
            if(i%2==0 &&  a[i]=='1')
            k++;
            if(i%2!=0 && a[i]=='0')
            k++;
        }
        return Math.min(k,a.length-k);
    }
}
  