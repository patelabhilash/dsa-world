package magicbinary.lc;

public class Leet9 {
    public boolean isPalindrome2(int x) {
        if(x<0) return false;
        String xstr = String.valueOf(x);
        for(int i=0;i< xstr.length()/2; i++){
            if(xstr.charAt(i)!= xstr.charAt(xstr.length()-1-i))
            return false;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int input  =  x;
        int output = 0;
        while(x>0){
            output  = output*10 + (x%10);
            x/=10;
        }
        if(input == output) return true;
        return false;
    }
}
