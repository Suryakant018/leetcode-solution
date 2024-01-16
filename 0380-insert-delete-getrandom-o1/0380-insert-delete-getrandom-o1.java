class RandomizedSet {

    Set<Integer> set;

    public RandomizedSet() {
        this.set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int size = set.size();
        int max = size; 
        Random rand = new Random();
        int randomNum = rand.nextInt(max) + 1; 
        int i = 1;
        for(int num : set) {
            if(i == randomNum) return num;
            i++;
        }

        return 0;       
    }
}