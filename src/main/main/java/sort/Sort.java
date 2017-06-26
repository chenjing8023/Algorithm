package sort;

/**
 * Created by hadoop on 17-4-10.
 */
public class Sort {
    public static void insertSort(int[] arr){
        if(arr == null || arr.length==0)
            return;
        for(int i = 1;i < arr.length;i++){
            int tmp = arr[i];
            int j = i;
            while (j>0 && arr[j-1] > tmp){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
        for(int a: arr){
            System.out.print(a + " ");
        }
    }

    public static void selectSort(int[] arr){
        int length = arr.length;
        int temp = 0;
        for(int i=0;i<length-1;i++){
            int k=i;
            for(int j=i+1;j<length;j++){
                if(arr[k] > arr[j]){
                    k=j;
                }
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
        for(int a: arr){
            System.out.print(a + " ");
        }

    }
    public static void main(String[] args){
        int arr[]={10,9,12,6,8,20};
        selectSort(arr);
    }
}
