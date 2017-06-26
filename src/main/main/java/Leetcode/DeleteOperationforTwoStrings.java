package Leetcode;

/**
 * Created by hadoop on 17-6-6.
 */
public class DeleteOperationforTwoStrings {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int len1 = w1.length;
        int len2 = w2.length;
        int[][] arr = new int[len1+1][len2+1];
        for(int i = 1;i <=len1 ;i++)
            for(int j = 1;j <=len2 ;j++){
                if( w1[i-1] == w2[j-1]){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        int result = len1 - arr[len1][len2] + len2 - arr[len1][len2];
        return result;
    }
    public static void main(String[] args){
        DeleteOperationforTwoStrings test = new DeleteOperationforTwoStrings();
        System.out.println(test.minDistance("sea","eat"));
    }
}
