package magicbinary.lc;

public class MaximumTreeDepth {
    
    public static void main(String[] args) {
        
    }

    int getMaximumDepth(int i, int[] binarytree){
        if(i==-1 || i> binarytree.length) return -1;
        return 1 + Math.max(getMaximumDepth(2*i+1,binarytree), getMaximumDepth(2*i+2, binarytree));
    }

}
