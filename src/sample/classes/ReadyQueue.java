package sample.classes;


import java.util.ArrayList;


public class ReadyQueue {

    private ArrayList<Process> readyQueue;


    private int quantityReadyQueue;

    public int getQuantityReadyQueue() {
        return quantityReadyQueue;
    }


//     Ready queue Constructor

    ReadyQueue() {
        readyQueue = new ArrayList<>();
        quantityReadyQueue = 0;
    }


    public ArrayList<Process> getReadyQueue() {
        return readyQueue;
    }


//     Add to ready queue

    public void addReadyQueue(final Process process) {
        readyQueue.add(process);
        quantityReadyQueue++;
    }

    @Override
    public String toString() {
        return "ReadyQueue{" +
                "readyQueue=" + readyQueue +
                '}';
    }
}
