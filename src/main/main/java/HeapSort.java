/**
 * Created by hadoop on 17-4-11.
 */
public class HeapSort {
    public void heapAdjust(int[] arr,int start,int length){
        int child=0;
        int temp=0;
        for(;2*start+1<length;start=child){
            child=2*start+1;
            if (child<length-1 && arr[child]<arr[child+1]) child++;
            if(arr[start]<arr[child]){
                temp=arr[child];
                arr[child]=arr[start];
                arr[start]=temp;
            }else
                break;
        }

    }
    public void bulidHeap(int[] arr){
        int lenght=arr.length;
        for(int i=(lenght-1)/2;i>=0;i--)
            heapAdjust(arr,i,lenght);

    }
    public int getKth(int[] arr,int k){
        bulidHeap(arr);
        int tmp=0;
        int len=arr.length-1;
        for(int i=0;i<k;i++){
            tmp=arr[0];
            arr[0]=arr[len];
            arr[len]=tmp;
            len--;
            heapAdjust(arr,0,len-1);
        }
        System.out.print(tmp);
        return tmp;
    }
    public static void main(String[] args){
        HeapSort sort=new HeapSort();
        int arr[]={5,4,2,6,7};
        sort.getKth(arr,3);
    }
}
