package Leetcode;

/**
 * Created by hadoop on 17-6-7.
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] hash = new int[len];
        for(int i = 0;i<len;i++){
            char[] tmp = words[i].toCharArray();
            for(int j = 0;j<tmp.length;j++){
                hash[i] |= 1<<(tmp[j]-'a');
            }
        }
        int result = 0;
        int tmp = 0;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if( (hash[i]&hash[j])== 0){
                    tmp = words[i].length()*words[j].length();
                    if(tmp > result)
                        result = tmp;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        String[] arr = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        MaximumProductofWordLengths test =  new MaximumProductofWordLengths();
        System.out.println(test.maxProduct(arr));
    }
}
