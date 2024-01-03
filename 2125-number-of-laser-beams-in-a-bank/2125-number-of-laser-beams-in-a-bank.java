class Solution {
    public int count(String str){
        int c = 0;
        for(char i: str.toCharArray()){
            if(i == '1'){
                c++;
            }
        }return c;
    }
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int size = bank.length;
        int arr[] = new int[size];
        for(int i = 0; i < bank.length; i++){
            arr[i] = count(bank[i]);
        }
        // System.out.println(ans);
        int curr = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                if(curr == 0){
                    curr = arr[i];
                }else{
                    ans += curr*arr[i];
                    curr = arr[i];
                }
            }
        }
        return ans;
    }
}