class Solution {
   public int findContentChildren(int[] g, int[] s) {
      //  if(s.length==0 || g.length==0){
        //    return 0;
                                                
       // }
       int cookie=0;
        Arrays.sort(g);
        Arrays.sort(s);

        for(int i=0;i<g.length;i++){
            for(int j=0;j<s.length;j++){
                if(s[j]>=g[i]){
                    cookie++;
                    s[j]=-1;
                    break;
                }
                
                  
                

                
            }
        }
        return cookie;
        
    }
}