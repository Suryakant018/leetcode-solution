
class Solution {
    public void solve(int col,char[][] board,List<List<String>> ans,int[] leftRow,int[] lowerDiagonal,int[] upperDiagonal){
        if(col==board.length){
            ans.add(cunstruct(board));
            return ;
        }
        int n = board.length;
        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && upperDiagonal[row+col]==0 && lowerDiagonal[n-1 + row -col]==0)
            {
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[n-1+row-col]=1;
                upperDiagonal[row+col]=1;
                solve(col+1,board,ans,leftRow,lowerDiagonal,upperDiagonal);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiagonal[n-1+row-col]=0;
                upperDiagonal[row+col]=0;
            }
        }
    }
    public List<String> cunstruct(char[][] board){
        List<String> res=new LinkedList<String>();
        for (int i =0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res =new ArrayList<>();
        int[] leftRow=new int[n];
        int[] lowerDiagonal=new int[2*n-1];
        int[] upperDiagonal=new int[2*n-1];
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                board[i][j]='.';
            }
        }
         solve(0,board,res,leftRow,lowerDiagonal,upperDiagonal);
        return res;

    }
}