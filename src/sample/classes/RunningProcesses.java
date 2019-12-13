package sample.classes;

import java.util.ArrayList;
import java.util.Comparator;


class RunningProcesses {

    private CreateRunningProcesses createRunningProcesses;

    private int processorIdleCycles = 0;

    RunningProcesses() {
        createRunningProcesses = new CreateRunningProcesses();
        final AddQueue addQueue = new AddQueue(createRunningProcesses);
        addQueue.run();
        ClearQueues clearQueues = new ClearQueues(createRunningProcesses);
        clearQueues.run();
    }


    public CreateRunningProcesses getCreateRunningProcesses() {
        return createRunningProcesses;
    }

    public int getProcessorIdleCycles() {
        return processorIdleCycles;
    }


    public void runProcess() {
        Process runningProcess;

        final ArrayList<Process> tempProcesses = new ArrayList<>();
        for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
            if (createRunningProcesses.getRunningProcessesIsFree().get(i) == Boolean.TRUE) {
                if (!createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().isEmpty()) {
                    createRunningProcesses.getRunningProcessesIsFree().set(i, Boolean.FALSE);
                    runningProcess = createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().get(0);
                    createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().remove(0);
                    tempProcesses.clear();
                    tempProcesses.addAll(createRunningProcesses.getQueue().getReadyQueue().getReadyQueue());
                    tempProcesses.sort(Comparator.comparingInt(Process::getPriority));
                    createRunningProcesses.getCreateRunningProcesses().set(i, new RunningProcess(runningProcess, i, createRunningProcesses));
                    createRunningProcesses.getCreateRunningProcesses().get(i).start();
                }
            }
        }
        if (createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().isEmpty()) {
            int checkFreeRunProcess = 0;
            for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
                if (createRunningProcesses.getRunningProcessesIsFree().get(i) == Boolean.TRUE) {
                    checkFreeRunProcess++;
                }
            }
            if (checkFreeRunProcess == Configuration.quantityRunningProcesses) {
                processorIdleCycles++;
            }
        }
    }
}
