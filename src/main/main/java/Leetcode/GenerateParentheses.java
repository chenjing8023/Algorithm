package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 17-6-6.
 */
public class GenerateParentheses {
    private List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        generate("",n,n);
        for(String s : result)
            System.out.println(s);
        return result;
    }
    public void generate(String cur,int left,int right){
        if(right < left || left < 0 || right < 0)
            return;
        if(right == 0 && left == 0)
            result.add(cur);
        if(left > 0 )
            generate(cur+"(",left-1,right);
        if(right > 0)
            generate(cur+")",left,right-1);
    }
    public static void main(String[] args){
        GenerateParentheses test = new GenerateParentheses();
        test.generateParenthesis(3);
    }
}
