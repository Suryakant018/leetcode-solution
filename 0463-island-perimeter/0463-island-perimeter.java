class Solution {
    public int islandPerimeter(int[][] grid) {
        int lengthRow = grid.length;
        int lengthColumn = grid[0].length;
        int perimeter = 0;
        for(int i=0; i<lengthRow; i++) {
            for(int j=0; j<lengthColumn; j++) {
                if(grid[i][j]==1) {
                    if(i==0) perimeter++;
                    if(i==(lengthRow-1)) perimeter++;
                    if(i<lengthRow-1 && grid[i+1][j]==0) perimeter++;
                    if(i>0 && grid[i-1][j]==0) perimeter++;
                    if(j==0) perimeter++;
                    if(j==(lengthColumn-1)) perimeter++;
                    if(j<(lengthColumn-1) && grid[i][j+1]==0) perimeter++;
                    if(j>0 && grid[i][j-1]==0) perimeter++;
                }   
            }
        }
        return perimeter;
    }
}
