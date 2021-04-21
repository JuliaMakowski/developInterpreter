package VM;

import java.util.Arrays;

public class VM {
    private int [] memory =new int[1000];
    private int dataPointer;
    private int programPointer;

    public VM(){
        Arrays.fill(memory, 0);
        dataPointer=0;
        programPointer=0;
    }
}
