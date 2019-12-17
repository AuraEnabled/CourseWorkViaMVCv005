package sample.classes;

import java.util.ArrayList;
import java.util.Comparator;

public class Queue {

    private ArrayList<Process> queue;

    private RejectQueue rejectQueue;

    private ReadyQueue readyQueue;

    private FinishedQueue finishedQueue;

    private int lastID;

    private MemoryScheduler memoryScheduler;

    private boolean checkMemory;

    private int averageServiceWait = 0;

    public Queue() {
        queue = new ArrayList<>();
        rejectQueue = new RejectQueue();
        readyQueue = new ReadyQueue();
        readyQueue.run();
        finishedQueue = new FinishedQueue();
        lastID = 1;
        checkMemory = true;
        memoryScheduler = new MemoryScheduler();
    }


//      Add a process

    private void add() {
        queue.add(new Process(lastID++));
    }

    public int getAverageServiceWait() {
        return averageServiceWait;
    }


    public void createReadyQueue() {
        ArrayList<Process> tempQueue = new ArrayList<>();
        for (int i = 0; i < queue.size() / 2; i++) {
            tempQueue.add(queue.get(i));
        }
        tempQueue.sort(Comparator.comparingInt(Process::getPriority));
        for (int i = 0; i < tempQueue.size(); i++) {
            queue.set(i, tempQueue.get(i));
        }
        for (int i = 0; i < queue.size(); i++) {
            averageServiceWait += ClockGenerator.getTime() - queue.get(0).getTimeIn();
            if (checkMemory) {
                checkMemory = memoryScheduler.add(queue.get(0).getMemory(), queue.get(0));
                queue.get(0).setState(State.Waiting);
                queue.get(0).setTimeInReadyQueue(ClockGenerator.getTime());
                readyQueue.addReadyQueue(queue.get(0));
            } else {
                if (memoryScheduler.findFreeBlock(queue.get(0).getMemory(), queue.get(0))) {
                    queue.get(0).setState(State.Waiting);
                    queue.get(0).setTimeInReadyQueue(ClockGenerator.getTime());
                    readyQueue.addReadyQueue(queue.get(0));
                } else {
                    rejectQueue.addRejectQueue(queue.get(0));
                }
            }
            queue.remove(0);
        }
    }


//      Add n processes

    public void add(final int N) {
        for (int i = 0; i < N; i++) {
            add();
        }
    }

    public int getLastID() {
        return lastID;
    }


//      Get memory scheduler
    public MemoryScheduler getMemoryScheduler() {
        return memoryScheduler;
    }


//     Get ready queue

    public ReadyQueue getReadyQueue() {
        return readyQueue;
    }


//      Get finished queue

    public FinishedQueue getFinishedQueue() {
        return finishedQueue;
    }


//      Get reject queue

    public RejectQueue getRejectQueue() {
        return rejectQueue;
    }


//      Get queue

    public ArrayList<Process> getQueue() {
        return queue;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (final Process process : queue) {
            result.append(process).append("\n");
        }
        return result.toString();
    }
}
