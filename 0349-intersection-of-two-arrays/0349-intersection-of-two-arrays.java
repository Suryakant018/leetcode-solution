class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hs.add(nums1[i]);
        }
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(hs.contains(nums2[i])){
                if(!l.contains(nums2[i])){
                    l.add(nums2[i]);
                }
            }
        }
        int a[]=new int[l.size()];
        for(int i=0;i<l.size();i++){
            a[i]=l.get(i);
        }
        return a;
    }
}