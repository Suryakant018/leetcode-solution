class Solution {
    public int minOperations(int[] nums, int k) {
        // finding the xor of all the elements
        // T.C -> O(n)
        int xor = 0;
        for(int num: nums){
            xor ^= num;
        }

        // now taking xor of the above value and k(given)
        // xor of these values gives us the numer of bits that are different in both values
        int diff = xor ^ k, operations = 0;

        // now just counting the set bits to get the different bits
        // which is going to be our number of operations required
        // T.C -> O(32), in worst case if all bits are set in diff 
        while(diff != 0){
            diff = (diff & (diff - 1));
            operations++;
        }

        return operations;
    }
}