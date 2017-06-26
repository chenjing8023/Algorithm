/**
 * Created by hadoop on 17-4-11.
 */
public class GetKth {
    public int getKthMax(int[] arr, int k){
        int p=search(arr,k,0,arr.length);
        if(p>0)
            return arr[p];
        return -1;
    }
    public int partition(int[] arr,int start, int end){
        int key=arr[start];
        while (start<end){
            while (arr[end]>key)
                end--;
            arr[start]=arr[end];
            while (arr[start]<key)
                start++;
            arr[start]=arr[end];
        }
        arr[start]=key;
        return start;
    }

    public int search(int[] arr,int k,int start, int end){
        int partition=partition(arr,start,end);
        if(partition-start+1==k){
            return partition;
        }
        else if(partition<k){
            search(arr,k-(partition-start+1),partition+1,end);
        }else {
            search(arr,k,start,partition-1);
        }
        return -1;
    }
}
