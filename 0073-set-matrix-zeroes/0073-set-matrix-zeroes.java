class Solution {
    public void setZeroes(int[][] matrix) {
 int zero [][]= new int [matrix.length*matrix[0].length][2]; 
        int count=0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    zero[count][0]=i;
                    zero[count][1]=j;
                    count++;
                }
            }
    for(int i=0;i<count;i++)
    {
        int y = zero[i][0];
        for(int l = 0;l<matrix[y].length;l++)
        {
            matrix[y][l]=0;
        }
        int z = zero[i][1];
        for(int k = 0;k<matrix.length;k++)
        {
            matrix[k][z]=0;
        }
    }
}
}