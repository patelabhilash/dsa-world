package magicbinary.owncheck;

public class Magic {
    
public static void main(String[] args) {
    Magic magic = new Magic();
    ;
    System.out.println(magic.isMagic("11100100"));
}

public boolean isMagic(String s){
    long oneCount =0;
    long zeroCount =0;
    for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i) == '0') zeroCount++;
        if(s.charAt(i) == '1') oneCount++;
        if(zeroCount>oneCount){
            return false;
        }
    }
    if(zeroCount!=oneCount){
        return false;
    }
    return true;
}

}
