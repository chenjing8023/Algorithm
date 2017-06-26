package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 17-5-29.
 */
public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int num[] = new int[size];
        for(int i =0;i<size;i++){
            String tmp[] = timePoints.get(i).split(":");
            num[i] = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
        }
        Arrays.sort(num);
        int min = 24*60 - num[size-1] + num[0];
        int tmp = 0;
        for(int i =0;i<size-1;i++){
            tmp = num[i+1] - num[i];
            if(tmp < min)
                min = tmp;
        }
        return min;
    }
    public static void main(String args[]){
        List<String> tmp = new ArrayList<String>();
        tmp.add("23:59");
        tmp.add("00:00");
        tmp.add("21:10");
        System.out.print(findMinDifference(tmp));
    }
}
