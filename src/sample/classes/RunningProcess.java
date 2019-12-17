package sample.classes;


public class RunningProcess extends Thread {

    private Process process;

    private int index;

    public CreateRunningProcesses createRunningProcesses;       //  private


    RunningProcess(final Process process, final int index, final CreateRunningProcesses createRunningProcesses) {
        this.process = process;
        this.index = index;
        this.createRunningProcesses = createRunningProcesses;
    }


    @Override
    public void run() {
        createRunningProcesses.setAverageProcessAwaitingTime(ClockGenerator.getTime() - process.getTimeInReadyQueue());
        process.setState(sample.classes.State.Running);
        try {
            sleep(process.getTime() / createRunningProcesses.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        process.setBurstTime(ClockGenerator.getTime());
        process.setState(sample.classes.State.Finished);
        createRunningProcesses.setAverageProcessTime(process.getBurstTime() - process.getTimeIn());
        createRunningProcesses.getQueue().getMemoryScheduler().releaseMemoryBlock(process.getMemoryBlock());
        createRunningProcesses.getFinishedQueue().addFinishedQueue(process);
        createRunningProcesses.getRunningProcessesIsFree().set(index, Boolean.TRUE);
    }
}
