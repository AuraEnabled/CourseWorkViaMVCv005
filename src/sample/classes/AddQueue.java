package sample.classes;

import java.util.Timer;
import java.util.TimerTask;


public class AddQueue extends TimerTask {

    @Override
    public void run() {
        timer.schedule(new AddQueue(createRunningProcesses), 1500);
        createRunningProcesses.addQueue();
    }
//    Instance of timer
    private Timer timer = new Timer();

    private CreateRunningProcesses createRunningProcesses;

    AddQueue(final CreateRunningProcesses createRunningProcesses) {
        this.createRunningProcesses = createRunningProcesses;
    }

}
