class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> block = new ArrayList<>();
        for(int i=1;i<=n;i++){
           block.add(i);
        }
        ArrayList<Integer> s = new ArrayList<>();
        String ans="";
        find(s,block,n,k-1);
        for(int i=0;i<s.size();i++){
            ans+=s.get(i);
        }
        return ans;
    }
    public void find(ArrayList<Integer> s,ArrayList<Integer> block,int n,int k){
        if(block.size()==1){
            s.add(block.get(block.size()-1));
            return ;
        }
        int per=permutation(n-1);
        s.add(block.get((k)/per));
        block.remove((k)/per);
        find(s,block,block.size(),k%per);
    }
    public int permutation(int n){
        if(n==0||n==1){
            return 1;
        }
        int f=1;
        for(int i=2;i<=n;i++){
            f*=i;
        }
        return f;
    }
}