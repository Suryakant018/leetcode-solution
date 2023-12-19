
class Solution {
    public int calculatePixelValue(int [][] img,int row,int column){
        int sum = 0;
        int count = 0;
        if(row-1 >= 0 && 
        column-1 >= 0 ){
            sum += img[row-1][column-1];
            count++;
        }
        if(row-1 >= 0){
            sum += img[row-1][column];
            count++;
        }
        if(row-1 >= 0 && 
        column+1 <= img[0].length-1 ){
            sum += img[row-1][column+1];
            count++;
        }
        if(column-1 >= 0 ){
            sum += img[row][column-1];
            count++;
        }
        if(column+1 <= img[0].length-1 ){
            sum += img[row][column+1];
            count++;
        }
        if(row+1 <= img.length-1 && 
        column-1 >= 0 ){
            sum += img[row+1][column-1];
            count++;
        }
        if(row+1 <= img.length-1 ){
            sum += img[row+1][column];
            count++;
        }
        if(row+1 <= img.length-1 && 
        column+1 <= img[0].length-1){
            sum += img[row+1][column+1];
            count++;
        }
         
        sum += img[row][column];
        count++;

        return sum/count;
        
    }
  
    public int[][] imageSmoother(int[][] img) {
        int [][] ans = new int[img.length][img[0].length];
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){
                ans[i][j] = calculatePixelValue(img,i,j);
            }
        }
 

    return ans;

    }
}