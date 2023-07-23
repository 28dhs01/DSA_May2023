package com.dhruv.dp.pattern5_mcm;

public class PalindromePartitioningRecursive {
    public static void main(String[] args) {
        String s = "aab" ;
        System.out.println(minCut(s));
    }
    public static int minCut(String s) {
        return solve(s,0,s.length()-1);
    }
    static int solve( String s, int i, int j ){
        if (i>=j){
            return 0 ;
        }
        if( isPalindrome(s,i,j)){
            return 0 ;
        }
        int ans = Integer.MAX_VALUE ;
        for( int k = i ; k<=j-1 ; k++ ){
            int tempAns = solve(s,i,k)+solve(s,k+1,j)+1 ;
            ans = Math.min(ans,tempAns) ;
        }
        return ans ;
    }
    static boolean isPalindrome(String s, int i, int j){
        String f = s.substring(i,j+1);
        String snd = "" ;
        for( int k = j ; k>=i ; k-- ){
            char ch = s.charAt(k) ;
            snd+=ch ;
        }
        return f.equals(snd) ;
    }
}
