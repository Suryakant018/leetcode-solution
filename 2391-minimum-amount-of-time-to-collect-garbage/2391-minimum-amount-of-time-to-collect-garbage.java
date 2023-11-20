class Solution {
  public int garbageCollection(String[] garbage, int[] travel) {
    int tot = 0, G = 0, M = 0, P = 0, tg = 0, tm = 0, tp = 0;  
    
    for(int i = 0, ch; i != garbage[0].length(); i++)
      switch(garbage[0].charAt(i)){
        case 'G' : G++; break;
        case 'M' : M++; break;
        case 'P' : P++; break;
      }
    
    
    for(int i = 1; i != garbage.length; i++){
      int g = 0, m = 0, p = 0;
      tot += travel[i-1];
      
      for(int j = 0; j != garbage[i].length(); j++)
        switch(garbage[i].charAt(j)){
          case 'G' : g++; break;
          case 'M' : m++; break;
          case 'P' : p++; break;
        }
      
      if(g != 0){G += g; tg = tot;}
      if(m != 0){M += m; tm = tot;}
      if(p != 0){P += p; tp = tot;}
    }
        
    return G + M + P + tg + tm + tp;       
  }
}