/**
 * Created by chenjing on 17-3-16.
 */
public class QuitSort {
    public int partition(int arr[],int low,int high){

        int key = arr[low];
        while( low < high){
            while( arr[high] > key ){
                high--;
            }
            arr[low] = arr[high];
            while( arr[low] < key ){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[high] = key;
        return high;
    }
    public void sort(int arr[],int low,int high){
        if(low >= high){
            return ;
        }
        int index= partition(arr,low,high);
        sort(arr,low,index-1);
        sort(arr,index+1,high);
    }
}
