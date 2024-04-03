class Solution {
    public boolean exist(char[][] board, String word) {
        boolean exists = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(ifExists(board, word, i, j, 0))
                    return true;
                }
            }
        }
        return false;
    }
    public boolean ifExists(char[][] board, String word, int i, int j, int len){
        if(len == word.length()){
            return true;
        }
        if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(len))
        return false;
        board[i][j] = '*';
        boolean result = ifExists(board, word, i-1, j, len+1) || ifExists(board, word, i, j-1, len+1) || ifExists(board, word, i+1, j, len+1) || ifExists(board, word, i, j+1, len+1);
        board[i][j] = word.charAt(len);
        return result;
    }
}