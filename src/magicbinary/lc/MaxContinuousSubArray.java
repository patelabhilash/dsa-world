package magicbinary.lc;

public class MaxContinuousSubArray {
    
    
    public static void main(String[] args) {
        
    }

    int getMaxContinuousSubarray(int[] arr){
        int maxValueOverAll = 0;
        int maxValueTemp = 0;

        for (int i = 0; i < arr.length; i++) {
            //Math.max(maxValueTemp + arr[i], arr[i]);

            if(maxValueTemp> 0 && arr[i] >0) maxValueTemp += arr[i];
           // if(maxValueTemp> 0 && arr[i] <0) maxValueTemp = maxValueTemp;
            if(maxValueTemp< 0 && arr[i] >0) maxValueTemp = arr[i];
            if(maxValueTemp< 0 && arr[i] <0) maxValueTemp = 0;
            //both positive 1; both negative 2; who ever is positive
            if(maxValueOverAll< maxValueTemp) maxValueOverAll = maxValueTemp;
        }

        return maxValueOverAll;
    }

    // this is accepted code too
    int getMaxContinuousSubarray2(int[] arr){
        int maxValueOverAll = 0;
        int maxValueTemp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(maxValueTemp> 0 && arr[i] >0) maxValueTemp += arr[i];
            if(maxValueTemp< 0 && arr[i] >0) maxValueTemp = arr[i];
            if(maxValueTemp< 0 && arr[i] <0) maxValueTemp = 0;
            if(maxValueOverAll< maxValueTemp) maxValueOverAll = maxValueTemp;
        }
        return maxValueOverAll;
    }
}
