class Solution {

    // first i have tried to convert (sx,sy) to (tx,ty) but that does not work as TLE T.C = 2^n
    // then tried to convert (tx,ty) to (sx,sy) T.C = log(n)

    static boolean helper(int sx, int sy, int tx, int ty){

        while(tx>sx && ty>sy){
            if(tx>ty) tx = tx%ty;    
            else ty = ty%tx;   // why (ty-sy)%sx == 0?

            // sy will translate to ty only by (sx+sy), if they translate then (sx, sy+k*sx) = ty for some k
            //sy+k*sx = ty => (ty-sy) / sx = k.
        }     

        if(tx==sx && ty>=sy && (ty-sy)%sx==0) return true;

        if(ty==sy && tx>=sx && (tx-sx)%sy==0) return true;

        return false;
    }
 public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

        return helper(sx,sy,tx,ty);
    }
}

