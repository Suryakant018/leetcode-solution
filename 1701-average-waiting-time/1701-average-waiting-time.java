class Solution {
    public double averageWaitingTime(int[][] customers) {
        //ArrayList<int[]> list = new ArrayList<>();
        double sum = 0;
        int curr_time = 0;
        for(int[] i:customers){
            if(i[0]>curr_time)
                curr_time=i[0];
            curr_time+=i[1]; 
            sum+=curr_time-i[0];
        }
        return sum/customers.length;
    }
}