class Solution {
    int[] nearestSmallerInRight(int[] heights){
        int n=heights.length;
        int[] ans=new int[n];
        Arrays.fill(ans,0);
        Stack<Integer>stack=new Stack<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            if(stack.empty())
            {
                ans[i]=n;
            }
            else
            {
                while(!stack.empty()&&heights[stack.peek()]>=heights[i])
                {
                    stack.pop();
                }
                if(stack.empty())
                {
                    ans[i]=n;
                }
                else
                {
                    ans[i]=stack.peek();
                }
            }
            stack.push(i);
        }
        return ans;
    }

    int[] nearestSmallerInLeft(int[] heights){
        int n=heights.length;
        int[] ans=new int[n];
        Stack<Integer>stack=new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            if(stack.empty())
            {
                ans[i]=-1;
            }
            else
            {
                while(!stack.empty()&&heights[stack.peek()]>=heights[i])
                {
                    stack.pop();
                }
                if(stack.empty())
                {
                    ans[i]=-1;
                }
                else
                {
                    ans[i]=stack.peek();
                }
            }
            stack.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nearestRight=nearestSmallerInRight(heights);
        int[] nearestLeft=nearestSmallerInLeft(heights);
        int[] width=new int[n];
        Arrays.fill(width,0);
        for(int i=0;i<n;i++)
        {
            width[i]=nearestRight[i]-nearestLeft[i]-1;
        }
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            maxArea=Math.max(maxArea,width[i]*heights[i]);
        }
        return maxArea;
        
        
    }
}