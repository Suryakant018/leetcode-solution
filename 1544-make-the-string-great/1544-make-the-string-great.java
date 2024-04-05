class Solution {
    public String makeGood(String s) {
        //If length of the string is 1, character at i + 1 index will be inaccessible
        if(s.length() == 0 || s.length() == 1) return s;
        //Create stringbuilder for deleting the characters
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length() - 1;){
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(i + 1);
//Checking both the conditions if lowercase and uppercase characters are side by side, then remove them using deleteCharAt method of stringbuilder
            if((int)ch1 == (int)ch2 + 32 || (int)ch1 == (int)ch2 - 32){
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i);
//This condition is necessary if after deleeting the character at the i and i + 1 index, then if suppose the i was greater than 0 and the index at i + 2(before deleting the characters) are also following the same conditions, so moving the i pointer back to check for that pair as well. So, we cant move the i pointer forwards. And also the condition i != 0 is only selected for i-- because if i == 0, then the element would not be accessible at -1 index.
                if(i != 0) i--;
            }
//Moving the i pointer forwards only if we don't find a pair like the condition above.
            else i++;
        }
        return sb.toString();
    }
}