package Leetcode;

/**
 * Created by hadoop on 17-6-17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0,max = 0;
        int[] letter = new int[26];
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            char b = s.charAt(start);
            while(letter[s.charAt(i)-'a'] == 1){
                letter[s.charAt(start)-'a'] = 0;
                start++;
            }
            letter[s.charAt(i)-'a'] = 1;
            max = Math.max(max,i-start+1);
        }
        return max;
    }
    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew");
    }
}
