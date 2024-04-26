class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5)
            return false;

        int[] arr = { 0, 0, 0 };
        for (int ele : bills) {

            if (ele == 5)
                arr[0]++;

            else if (ele == 10) {
                if (arr[0] == 0)
                    return false;

                arr[0]--;
                arr[1]++;
            }

            else {//for 20
                if (arr[0] > 0 && arr[1] > 0) {
                    arr[0]--;
                    arr[1]--;
                }

                else if (arr[0] >= 3)
                    arr[0] -= 3;
                   
                 else
                    return false;
            }

        }
        return true;
    }
}
