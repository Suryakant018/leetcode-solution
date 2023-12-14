class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows= grid.length;
        int cols= grid[0].length;
        int diff[][]= new int[rows][cols];
            int onesRows[]= new int[rows];
            int onesCols[]= new int[cols];


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
               if(grid[i][j]==1){
                   onesRows[i]+= grid[i][j];
                   onesCols[j]+= grid[i][j]; 
               }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                 diff[i][j]= 2*(onesRows[i]+onesCols[j])-rows-cols;
            }
        }
        return diff;
    }
}