class MedianFinder {
    /**
    At any point of the solution the given stream of data is divided into two parts -
    1- smallValuesMaxQueue -> it contains approximately half of the stream data which is 
    of smaller values and stored into maxHeap to have the median value means max value at the top.
    2- largeValuesMinQueue -> it contains approximately half of the stream data which is 
    of larger values and stored into minHeap to have the median value means min value at the top.
     */
    PriorityQueue<Integer> smallValuesMaxQueue;
    PriorityQueue<Integer> largeValuesMinQueue;

    public MedianFinder() {
        smallValuesMaxQueue = new PriorityQueue<>(Collections.reverseOrder());
        largeValuesMinQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        /* Adding element to the smaller values queue so that we get the till now 
        larger element at the top*/
        smallValuesMaxQueue.add(num);
        /* Now moving larger element of the smallValuesMaxQueue into the largeValues
        queue so that we have the larger element of the max heap into the largerVlues Min heap.*/ 
        largeValuesMinQueue.add(smallValuesMaxQueue.poll());

        /* Assuimg prior inserting new element the heap was balanced and as we have 
        finally inserted new eleemnt into the min heap so we have to check if the min 
        heap is having more element then we will move top elemnt of the min heap 
        which is the smallest element of the heap into the max heap.
        
        So at the end everytime eother both the haeap are of same size or the 
        smallValuesMaxQueue is of larger size beacuse if the largeValuesMinQueue 
        is of largersize then we always move the element to smallValuesMaxQueue*/
        if(smallValuesMaxQueue.size() < largeValuesMinQueue.size()){
            smallValuesMaxQueue.add(largeValuesMinQueue.poll());
        }

    }

    public double findMedian() {
        if(smallValuesMaxQueue.size() == largeValuesMinQueue.size()){
            return (smallValuesMaxQueue.peek() + largeValuesMinQueue.peek())/2.0;
        }
        return smallValuesMaxQueue.peek();
    }
}