
class RandomizedSet {
    Set<Integer> set;
    Random rand;
    public RandomizedSet() {
        set=new HashSet<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        List<Integer> list=new ArrayList<>(set);
        int randIdx=rand.nextInt(set.size());
        return list.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */