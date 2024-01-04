class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        
        int CriticalPoint[][]=new int[buildings.length*2][2];

        for(int i=0,j=0;i<buildings.length;i++){
            CriticalPoint[j][0]=buildings[i][0];
            CriticalPoint[j][1]=buildings[i][2];
            CriticalPoint[j+1][0]=buildings[i][1];
            CriticalPoint[j+1][1]=-1*buildings[i][2];
            j=j+2;
        }

        Arrays.sort(CriticalPoint,(a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        List<List<Integer>> res=new ArrayList<List<Integer>>();

        for(int i=0;i<CriticalPoint.length;i++){
            //System.out.println(CriticalPoint[i][0]+" "+CriticalPoint[i][1]);
                

            if(CriticalPoint[i][1]>0){
                if(maxHeap.peek()==null || CriticalPoint[i][1]>maxHeap.peek()){
                    maxHeap.add(CriticalPoint[i][1]);
                    if(res.size()>0 && res.get(res.size()-1).get(0)==CriticalPoint[i][0]){
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(CriticalPoint[i][0]);
                        temp.add(CriticalPoint[i][1]);
                        res.remove(res.size()-1);
                        res.add(temp);

                    }
                    else{
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(CriticalPoint[i][0]);
                        temp.add(CriticalPoint[i][1]);
                        res.add(temp);
                    }
                }
                else{
                    maxHeap.add(CriticalPoint[i][1]);
                }
            }
            else{
                int height=-1*CriticalPoint[i][1];
                if(height==maxHeap.peek()){
                    maxHeap.remove(height);
                    if(maxHeap.peek()==null){
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(CriticalPoint[i][0]);
                        temp.add(0);
                        res.add(temp);
                    }
                    else{                    
                        if(maxHeap.peek()==height)
                            continue;
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(CriticalPoint[i][0]);
                        temp.add(maxHeap.peek());
                        res.add(temp);
                    }
                }
                else{
                    maxHeap.remove(height);
                }
            }

        }

    

        return(res);
        
    }
}