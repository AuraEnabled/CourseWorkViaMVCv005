package sample.classes;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SetHighPriority extends TimerTask {

    private Timer timer = new Timer();
    private ArrayList<Process> processes;

    public SetHighPriority(ArrayList<Process> processes) {
        this.processes = processes;
    }


    @Override
    public void run() {
        timer.schedule(new SetHighPriority(processes), 100);
        if (!processes.isEmpty()) {
            for (Process process : processes) {
                if (ClockGenerator.getTime() - process.getTimeIn() > 100) {
                    process.setPriority(1);
                }
            }
        }

    }
}
