package magicbinary.ibm;

public class StackTest {

    private int size;
    private int[] elements;
    public int currentPosition;

    StackTest(int size) {
        this.size = size;
        this.elements = new int[size];
    }

    public void push(int ele){
        if(this.currentPosition== this.getSize()){
            System.err.println("stack overflowed: element can not be added");
        }else{
            ++this.currentPosition;
            elements[this.currentPosition] = ele;
        }
    }

    public int pop() {
        if(this.currentPosition== 0){
            System.err.println("stack is empty");
            return -1;
        }else{
            --this.currentPosition;
            return elements[this.currentPosition+1];
        }
    }

    public int getSize() {
        return size;
    }

}





