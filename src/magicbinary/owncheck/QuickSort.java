package magicbinary.owncheck;

import java.util.Arrays;

public class QuickSort {

    void quickSort(int[] arr){
        if (arr == null) return ;
         quickSort(arr, 0, arr.length-1);
    }
    
    void quickSort(int[] arr, int start, int end){
        if(start>=end) return;
        int pivot = arr[(start+end)/2];
        int i= start;
        int j = end;
        while(i<=j){
            while(arr[i]<pivot) ++i;
            while(arr[j]>pivot) --j;
            if(i<=j) {
                swap(arr,i,j);
                ++i;--j;
            }
        }
        if(start<j) quickSort(arr, start, j);
        if(i<end) quickSort(arr, i, end);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int quickSelect(int[] arr, int k){
        quickSelectSort(arr, 0, arr.length-1,k);
        return arr[k];
    }

    private void quickSelectSort(int[] arr, int start, int end, int k){
        int i = start;
        int j = end;
        int pivot  = arr[(i+j)/2];
        while(i<=j){
            while(arr[i]<pivot) ++i;
            while(arr[j]>pivot) --j;
            if(i<=j){
                swap(arr, i, j);
                ++i;--j;
            }
        }
        ///call it by sorting only the portion where k is present
        if(start<j && start<=k && k<=j) quickSelectSort(arr, start, j, k);
        if(i<end && k>=i && k<=end) quickSelectSort(arr, i, end, k);
    }

    

    public void sort(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int x = array[start+(end-start) / 2];
        do {
            while(array[i] < x) ++i;
            while(array[j] > x) --j;
            if(i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i ++ ;
                j --;
             }
         }while(i <= j);
         
         if(start < j) sort(array, start, j);
         if(i < end) sort(array, i, end);
    }

    public static void main(String[] args) {
        // int[] vals = {1,27,3,4,10,-10,-20, -1};
        int[] vals = {10,27,3,10,10,-10,-20, -1};
        System.out.println(new QuickSort().quickSelect(vals, 3));

        new QuickSort().quickSort(vals);
        //new QuickSort().sort(vals,0,vals.length-1);
        System.out.println(Arrays.toString(vals));
    }
}
