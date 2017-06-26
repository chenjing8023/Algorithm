package Leetcode;

import java.util.*;

/**
 * Created by hadoop on 17-6-1.
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], h = matrix[n-1][n-1];
        while (l <= h) {
            int m = l + (h - l)/2;
            int count = binarySearch(matrix, m);
            if (count < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }
    public int binarySearch(int[][] matrix, int target) {
        int n = matrix.length, i = n - 1, j = 0;
        int res = 0;
        while (i >= 0 && j <= n - 1) {
            if (matrix[i][j] > target) i--;
            else {
                j++;
                res += i + 1;
            }
        }
        return res;
    }
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2)
                    return -1;
                return 1;
            }
        });
        for(int i = 0;i < matrix.length;i++)
            for(int j = 0;j<matrix.length;j++){
                if((i+1)*(j+1)>k)
                    break;
                queue.offer(matrix[i][j]);
                if(queue.size() > k)
                    queue.poll();
            }
        return queue.peek();
    }
    public static void main(String args[]){
        KthSmallestElementinaSortedMatrix test = new KthSmallestElementinaSortedMatrix();
        int matrix[][]=new int[2][2];
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            for(int i = 0;i<2;i++)
                for(int j = 0;j<2;j++){
                    matrix[i][j] = in.nextInt();
                }
            System.out.println(test.kthSmallest2(matrix,1));
        }



    }
}
