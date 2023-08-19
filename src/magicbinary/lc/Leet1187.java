package magicbinary.lc;

import java.util.Arrays;

public class Leet1187 {
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length ==1 || arr1.length == 0) return 0;
        if(arr2 == null || arr2.length == 0) return checkIfStrictlySorted(arr1);

        //
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            /* if(includei){
                continue;
            }else{
                if(replacefrom arr 2 possible){
                    replaced
                }else{
                    return -1;
                }
            } */
        }
        return -1;
    }

    int take(int itaken, int[] arr1, int[] arr2){
        if(itaken>= arr1.length) return 0;
        if(arr1[itaken]>arr1[itaken-1]){
            return take(itaken+1, arr1, arr2);
        }else{
            int replacedI = getAlternative(arr1[itaken]+1, arr2);
            if(replacedI>0){
                return 1 + take(itaken+1, arr1, arr2);
            }else{
                return Integer.MIN_VALUE;
            }
        }
    }

    int getAlternative(int i, int[] arr2){
        int location  = Arrays.binarySearch(arr2, i);
        return arr2[Math.abs(location)];
    }

    int checkIfStrictlySorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>=arr[i+1]){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 3);

    }
}
