class Solution {
    //aaabb
    //i=3 idx=0 count=3 idx=1 
    //if i>1 , <10 chars[idx] = 
    public int compress(char[] chars) {
        int i=0;
        int idx=0; // to track where to put an element
        int count=0; 
        while(i<chars.length){
            char c = chars[i];
            while( i<chars.length && chars[i]==c){
                count++;
                i++;
            }
            chars[idx]=c;
            idx++;
            if(count>1){ 
                int temp = count;
                int len = 0; // find the length of count
                while (temp != 0) {
                    temp /= 10;
                    len++;
                }
                int tidx=0; // find index where the count element will be placed 
                while (count != 0) {
                    chars[idx + len-1-tidx] = (char) ((count % 10) + '0');
                    count /= 10;
                    tidx++;
                }
                idx+=tidx;
            }
            count=0;
        }

        return idx;

        
    }
}