class Pair {
    int height;
    int position;
    Pair(int height,int position) {
        this.height = height;
        this.position = position;
    }
}
class Solution {
    public int maximalRectangle(char[][] matrix) {
        List<Integer> data = new ArrayList<Integer>();
        for(int i=0;i<matrix[0].length;i++) {
            data.add(Integer.parseInt(String.valueOf(matrix[0][i])));
        }
        int maximum = MAH(data);
        for(int i =1;i<matrix.length;i++) {
           for(int j =0;j<matrix[0].length;j++) {
              if(matrix[i][j] != '0')
              {
                  data.set(j,data.get(j)+ Integer.parseInt(String.valueOf(matrix[i][j])));
              }
              else
              data.set(j,0);
           } 
           int d = MAH(data);
           maximum = d > maximum ? d : maximum;
        }
        return maximum;
    }
    public int MAH(List<Integer> data) {
        Stack<Pair> s = new Stack<Pair>();
        //Nearest smallest from left and right
        int left[] = new int[data.size()];
        int right[] = new int[data.size()];
        //left
        for(int i=0;i<data.size();i++) {
            if(s.size()==0)
            left[i] = -1;
            else if(s.peek().height<data.get(i))
            left[i] = s.peek().position;
            else {
               while(s.size()>0 && s.peek().height>=data.get(i))
               {
                   s.pop();
               }
               if(s.size()==0)
               left[i] = -1;
               else
               left[i] = s.peek().position;
            }
            s.push(new Pair(data.get(i),i));
        }
        s.clear();
        //right
        for(int i=data.size()-1;i>=0;i--) {
            if(s.size()==0)
            right[i] = data.size();
            else if(s.peek().height<data.get(i))
            right[i] = s.peek().position;
            else {
               while(s.size()>0 && s.peek().height>=data.get(i))
               {
                   s.pop();
               }
               if(s.size()==0)
               right[i] = data.size();
               else
               right[i] = s.peek().position;
            }
            s.push(new Pair(data.get(i),i));
        }
        int max = Integer.MIN_VALUE;
        for(int j=0;j<right.length;j++) {
            int w = data.get(j);
            int area = w * (right[j] - left[j] -1);
            max = area > max ? area : max;
        }
        return max;
    }
}