package com.dhruv.slidingWindow;

public class KBeauty {
    public static void main(String[] args) {
        int num = 240 ;
        int k = 2 ;
        String str = String.valueOf(num);
        System.out.println(str);
        int cnt = 0 ;

        for( int i = 0 ; i<str.length() ; i++ ){
            StringBuilder sb = new StringBuilder( );
            for( int j = i ; j<i+k && j<str.length(); j++ ){
                sb.append(str.charAt(j));
                if( sb.length() == k ){
                    int val = Integer.parseInt(sb.toString()) ;
                    if( num % val == 0 ){
                        cnt ++ ;
                    }
                }
            }

        }
        System.out.println(cnt);
    }
}
