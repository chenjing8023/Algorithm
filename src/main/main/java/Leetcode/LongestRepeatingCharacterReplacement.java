package Leetcode;

/**
 * Created by hadoop on 17-6-17.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 0,res = 0,start = 0;
        int count[] = new int[26];
        for(int i = 0;i < s.length();i++){
            max = Math.max(max,++count[s.charAt(i)-'A']);
            if(i+1-start-max > k){
                count[s.charAt(i)-'A']--;
                ++start;
            }
            res = Math.max(res,i-start+1);
        }
        return res;
    }
}
