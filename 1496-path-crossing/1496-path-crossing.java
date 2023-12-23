class Solution {
    public boolean isPathCrossing(String path) {
        int n=path.length();
       Set<String> visited = new HashSet<>();      
        int x=0, y=0;
        String key=x+"!"+y;
         visited.add(key);
        for(char ch:path.toCharArray()){
            if(ch=='E')
            y++;
            else if(ch=='W')
            y--;
            else if(ch=='N')
            x++;
            else if(ch=='S')
            x--;
            key=x+"!"+y;
           if(visited.contains(key))
           return true;
           else 
           visited.add(key);

        }
        return false;
    }
}