package magicbinary.lc;

import java.util.Arrays;

public class Leet1802 {
    
    public int maxValue2(int n, int index, int maxSum) {
        maxSum = maxSum - n;
        int i,left,right,leftDeduct, rightDeduct, totalLayerPoint;
        if (maxSum < 0)
            return -1;

        for (i = 1; maxSum > 0; i++) {
            left = i - 1;
            right = i - 1;
            leftDeduct = (index - left < 0) ? left - index : 0;
            rightDeduct = (index + right > n - 1) ? (right + index) - n + 1 : 0;
            totalLayerPoint = 2 * i - 1 - leftDeduct - rightDeduct;
            maxSum -= totalLayerPoint;
        }
        Arrays.binarySearch(null, index, index, null, null);
        if (maxSum == 0)
            return i;
        if (maxSum < 0)
            return i - 1;
        return -1;
    }

    public int maxValue(int n, int index, int maxSum) {
        int low =1;
        int high = maxSum;
        int mid =  (low+high)/2;
        int localSum;
        int l = index;
        int r = n-1-index;
        while(low<=high){
            localSum = getSum(mid, n, index);
            if(localSum == maxSum) return mid;
            if(localSum > maxSum) high = mid-1;
            if(localSum < maxSum) low = mid+ 1;
            mid = (low+high)/2;
        }
        return mid;
    }

    private int getSum(int midl, int n, int index){
            int mid = midl -1;
            int ls = (mid >= index)?(mid*(mid+1))/2 - ((mid - index)* (mid -index + 1))/2: (mid*(mid+1))/2 + (mid -index);
            int rs = (mid >= n-1-index)? (mid*(mid+1))/2 - ((mid - (n-1-index))* (mid -(n-1-index) + 1))/2 : (mid*(mid+1))/2 + (mid -(n-1-index)) ;
            return midl + ls + rs;
    }

    public static void main(String[] args) {
        System.out.println(new Leet1802().maxValue(8, 7, 14)); //4
        System.out.println(new Leet1802().maxValue(6, 1, 10)); //3
        System.out.println(new Leet1802().maxValue(4, 2, 6)); //2

        
    }


}


/*

0   1   2   3
//1
//3
//5
- k>boundary

in layer i 

for(i = 1; maxSum>0; i++){
int left = i-1;
int right = i+1;
int leftDeduct = (index-left<0) ? left-index : 0;
int rightDeduct = (index+right > nums.length-1) ? nums.length-1-(right+index) : 0;
int totallayerPoint = 2*i -1 - leftDeduct - rightDeduct;
maxSum-= totalLayerDeduct;
}

if(maxsum == 0) return i;
if(maxsum < 0) return i-1; 

0 1 2 3
0 1 3 5
0   0
1   1   2*n -1
3   2   
5   3   
7   4   
9   5

left -> n == 1 then left = 0;
layer == 2 then left = layer-1;

if index-left< 0 , left to deduct is left-index
if index+right > nums.length-1, right to deduct is nums.length-1-(right+index)

right = n+1;




        1
    1   1   1
1   1   1   1   1

*/