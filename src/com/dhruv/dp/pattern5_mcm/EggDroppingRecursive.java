package com.dhruv.dp.pattern5_mcm;

public class EggDroppingRecursive {
    public static void main(String[] args) {
        int ans = superEggDrop(3,5) ;
        System.out.println(ans);
    }
    public static int superEggDrop(int k, int n) {
        return solve(k,n) ;
    }
    static int solve(int e, int f){
//        bc
        if( e==1 || f==1 || f==0){
            return f ;
        }
//        k loop
        int mn = Integer.MAX_VALUE ;
        for ( int k = 1 ; k<=f ; k++ ){
            int tmpAns =1+ Math.max ( solve(e-1,k-1),solve(e,f-k) )  ;
            mn = Math.min(mn,tmpAns) ;
        }
        return mn ;
    }
}
