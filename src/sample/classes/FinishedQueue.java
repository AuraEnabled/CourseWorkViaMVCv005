package sample.classes;

import java.util.ArrayList;

class FinishedQueue {

//    Processes ArrayList
    private ArrayList<Process> finishedQueue;

    private int quantityFinishedQueue;

    FinishedQueue() {
        finishedQueue = new ArrayList<>();
        quantityFinishedQueue = 1;
    }

    public ArrayList<Process> getFinishedQueue() {
        return finishedQueue;
    }

    public int getQuantityFinishedQueue() {
        return quantityFinishedQueue;
    }


//   Add to array list process

    public void addFinishedQueue(final Process process) {
        finishedQueue.add(process);
        quantityFinishedQueue++;
    }
}
