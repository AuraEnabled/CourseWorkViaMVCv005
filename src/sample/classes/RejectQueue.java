package sample.classes;

import java.util.ArrayList;


class RejectQueue {

    private ArrayList<Process> rejectQueue;

    private int  quantityRejectQueue;

    RejectQueue() {
        rejectQueue = new ArrayList<>();
        quantityRejectQueue = 1;
    }


    public void addRejectQueue(final Process process) {
        rejectQueue.add(process);
        quantityRejectQueue++;
    }

    public int getQuantityRejectQueue() {
        return quantityRejectQueue;
    }


    public ArrayList<Process> getRejectQueue() {
        return rejectQueue;
    }
}
