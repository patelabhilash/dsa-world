package magicbinary.lc;

public class LIS {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 10, 6, 9 };
        LIS lis = new LIS();
        // lis.findlis(arr);

    }

    void findarrsubsequencerunner(int[] arr) {
        int len = arr.length;
        findsubsequence(arr, len);
    }

    int[] findsubsequence(int[] arr, int k) {
        if (k < 0) {
            return arr;
        }

        findsubsequence(arr, k - 1);
        arr[k] = -1;
        findsubsequence(arr, k - 1);

        return arr;
    }

    String findsubsequence(String str, String str2) {
        if (str2.length() == 0)
            return str;
        findsubsequence(str + str2.charAt(0), str2.substring(1));
        findsubsequence(str, str2.substring(1));
        return str + str2;
    }

    void cacheit(int[] arr){
        int[] cachearr = new int[arr.length];

        // if cache[i]
    }
}
