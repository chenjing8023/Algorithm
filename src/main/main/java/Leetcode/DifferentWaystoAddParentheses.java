package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 17-6-10.
 */
public class DifferentWaystoAddParentheses {
    private Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String l = input.substring(0, i);
                String r = input.substring(i + 1);
                List<Integer> left;
                List<Integer> right;
                if(map.containsKey(l))
                    left = map.get(l);
                else
                    left = diffWaysToCompute(l);
                if(map.containsKey(r))
                    right = map.get(r);
                else
                    right= diffWaysToCompute(r);
                for (int n : left) {
                    for (int m : right) {
                        switch (ch) {
                            case '+':
                                res.add(n + m);
                                break;
                            case '-':
                                res.add(n - m);
                                break;

                            case '*':
                                res.add(n * m);
                                break;
                        }
                    }
                }
            }
        }

        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        map.put(input,res);
        return res;
    }
    public static List<Integer> diffWaysToCompute2(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i < input.length(); i++){
            char tmp = input.charAt(i);
            if(tmp == '+' || tmp == '-' || tmp=='*'){
                List<Integer> left = diffWaysToCompute2(input.substring(0,i));
                List<Integer> rigth = diffWaysToCompute2(input.substring(i+1));
                for(int n :left)
                    for(int m : rigth){
                        switch(tmp){
                            case '+':
                                res.add(n+m);
                                break;
                            case '-':
                                res.add(n-m);
                                break;
                        }

                    }
            }
        }
        if(res.size()==0)
            res.add(Integer.parseInt(input));
        return res;
    }
    public static void main(String[] args){
        //diffWaysToCompute("2*3-4*5");
    }
}
