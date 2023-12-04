class Solution {
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();
        int slow = 0;
        int val = -1;
        int count = 0;
        for(int fast = 0; fast < chars.length; fast++){
            if(chars[slow] != chars[fast]){
                count = 0;
                slow = fast;
            }
            if(count == 2){
                val = Math.max(val, chars[slow] - '0');
                count = 0; // reset
            }
            count++;
        }
        return val != -1?buildStr(val): "";
    }

    public String buildStr(int result){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append((char)(48 + result));
        }
        return builder.toString();
    }
}

    