package sample.classes;

import java.util.Comparator;


public class MemoryBlock {

    public int start;

    public int end;

//    Sort by end
    public static Comparator <MemoryBlock> byEnd = Comparator.comparingInt(o -> o.end);

    MemoryBlock(final int start, final int end){
        if(start > Configuration.KernelMemoryVolume) {
            this.start = start;
            this.end = end;
        }
    }

    @Override
    public String toString() {
        return "{" + start + ", " + end + '}';
    }
}
