package sample.classes;

import java.util.ArrayList;


class CreateRunningProcesses {

    private ArrayList<RunningProcess> createRunningProcesses;

    private ArrayList<Boolean> runningProcessesIsFree;

    private Queue queue;

//    Initial running speed
    private int speed = 1;

//    Unserved processes
    private int quantityProcessesLeft = 0;

    private  int averageProcessAwaitingTime = 0;

    private  int averageProcessTime = 0;


//    CreatRunningProcesses constructor

   public CreateRunningProcesses() {
        createRunningProcesses = new ArrayList<>();
        queue = new Queue();
        for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
            createRunningProcesses.add(null);
        }
        runningProcessesIsFree = new ArrayList<>();
        for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
            runningProcessesIsFree.add(Boolean.TRUE);
        }
    }


//    Check if running process is free

    public ArrayList<Boolean> getRunningProcessesIsFree() {
        return runningProcessesIsFree;
    }


   public Queue getQueue() {
        return queue;
    }


   public void addQueue() {
       queue.add(20);
       queue.createReadyQueue();
   }


    public ArrayList<RunningProcess> getCreateRunningProcesses() {
        return createRunningProcesses;
    }

    public FinishedQueue getFinishedQueue() {
        return queue.getFinishedQueue();
    }

    public int getAverageProcessTime() {
        return averageProcessTime;
    }

    public void setAverageProcessTime(final int averageProcessTime) {
        this.averageProcessTime = averageProcessTime;
    }

    public int getAverageProcessAwaitingTime() {
        return averageProcessAwaitingTime;
    }

    public void setAverageProcessAwaitingTime(final int averageProcessAwaitingTime) {
        this.averageProcessAwaitingTime = averageProcessAwaitingTime;
    }

    public int getQuantityProcessesLeft() {
        return quantityProcessesLeft;
    }

    public void setQuantityProcessesLeft(final int quantityProcessesLeft) {
        this.quantityProcessesLeft = quantityProcessesLeft;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }
}
