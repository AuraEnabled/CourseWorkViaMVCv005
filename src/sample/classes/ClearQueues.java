package sample.classes;

import java.util.Timer;
import java.util.TimerTask;


public class ClearQueues extends TimerTask {

//    Instance of timer
    private Timer timer = new Timer();

    private CreateRunningProcesses createRunningProcesses;

    ClearQueues(final CreateRunningProcesses createRunningProcesses) {
        this.createRunningProcesses = createRunningProcesses;
    }

    @Override
    public void run() {
        timer.schedule(new ClearQueues(createRunningProcesses), 100);
        if (createRunningProcesses.getFinishedQueue().getFinishedQueue().size() > 10) {
            createRunningProcesses.setQuantityProcessesLeft(createRunningProcesses.getQuantityProcessesLeft() + 1);
            createRunningProcesses.getFinishedQueue().getFinishedQueue().remove(0);
        } else if (createRunningProcesses.getFinishedQueue().getFinishedQueue().size() > 50) {
            createRunningProcesses.setQuantityProcessesLeft(createRunningProcesses.getQuantityProcessesLeft() + 20);
            createRunningProcesses.getFinishedQueue().getFinishedQueue().subList(0, 20).clear();
        }
        if (createRunningProcesses.getQueue().getRejectQueue().getRejectQueue().size() > 10) {
            createRunningProcesses.setQuantityProcessesLeft(createRunningProcesses.getQuantityProcessesLeft() + 1);
            createRunningProcesses.getQueue().getRejectQueue().getRejectQueue().remove(0);
        } else if (createRunningProcesses.getQueue().getRejectQueue().getRejectQueue().size() > 50) {
            createRunningProcesses.setQuantityProcessesLeft(createRunningProcesses.getQuantityProcessesLeft() + 20);
            createRunningProcesses.getQueue().getRejectQueue().getRejectQueue().subList(0, 20).clear();
        }
    }
}
