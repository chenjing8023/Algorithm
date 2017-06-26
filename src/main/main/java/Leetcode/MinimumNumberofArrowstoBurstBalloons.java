package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hadoop on 17-6-7.
 */
public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points,new Comparator<int []>(){
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points[0].length;j++){
                System.out.print(points[i][j]+" ");
            }
            System.out.println();
        }
        int count = 1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0] > end){
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
    public static void main(String[] args){
        MinimumNumberofArrowstoBurstBalloons test = new MinimumNumberofArrowstoBurstBalloons();
        int[][] arr = {{10,16},{2,8},{1,6},{7,12}};
        test.findMinArrowShots(arr);
    }
}
