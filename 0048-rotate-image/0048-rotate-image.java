
class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        
        // swapping upper triangle with lower triangle (transpose)
        for(int i=0; i<r; i++){ 
            for(int j=i+1; j<c; j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        // reverse all rows
        for(int i=0; i<c; i++){
            int low=0;
            int high=r-1;
            while(low<high){
                int temp=matrix[i][low];
                matrix[i][low]=matrix[i][high];
                matrix[i][high]=temp;
                low++;
                high--;
            }
        }
        
    }
}
        