package sample.classes;

import java.util.Timer;
import java.util.TimerTask;


public class RefreshRunningProcesses extends TimerTask {

//    Instance of timer

    private Timer timer = new Timer();

    private RunningProcesses runningProcesses;


    RefreshRunningProcesses(final RunningProcesses runningProcesses) {
        this.runningProcesses = runningProcesses;
    }

    @Override
    public void run() {
        timer.schedule(new RefreshRunningProcesses(runningProcesses), 1);
        ClockGenerator.incTime();
        runningProcesses.runProcess();
    }
}
