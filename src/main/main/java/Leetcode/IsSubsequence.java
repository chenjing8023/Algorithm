package Leetcode;

/**
 * Created by hadoop on 17-5-30.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int arr[][] = new int[len1+1][len2+1];
        for(int i=1; i <= len1;i++)
            for(int j=1; j <= len2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        if(arr[len1][len2] == len1 || arr[len1][len2]==len2)
            return true;
        return false;
    }
}
