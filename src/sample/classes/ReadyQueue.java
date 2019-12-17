package sample.classes;


import java.util.ArrayList;


public class ReadyQueue extends Thread{

    private ArrayList<Process> readyQueue;


    private int quantityReadyQueue;

    public int getQuantityReadyQueue() {
        return quantityReadyQueue;
    }
    public SetHighPriority setHighPriority;

//     Ready queue Constructor

    ReadyQueue() {
        readyQueue = new ArrayList<>();
        setHighPriority = new SetHighPriority(readyQueue);
        setHighPriority.run();
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
    public void run() {
//        while (true){
//            try {
//                sleep(70);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int i = 0; i < readyQueue.size(); i++ ) {
                if (readyQueue.get(i).getTimeIn() > 10) {
                    readyQueue.get(i).setPriority(1);
                }
            }
        }
//    }

    @Override
    public String toString() {
        return "ReadyQueue{" +
                "readyQueue=" + readyQueue +
                '}';
    }
}
