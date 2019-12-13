package sample.classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Table {

    private final SimpleIntegerProperty processId;
    private final SimpleStringProperty processName;
    private final SimpleIntegerProperty processPriority;
    private final SimpleIntegerProperty processTime;
    private final SimpleIntegerProperty processMemory;
    private final SimpleIntegerProperty processTimeIn;
    private final SimpleIntegerProperty processBurstTime;
    private final SimpleStringProperty processState;

//    Constructor of Table

    Table(final Process process) {
        this.processId = new SimpleIntegerProperty(process.getId());
        this.processName = new SimpleStringProperty(process.getName());
        this.processPriority = new SimpleIntegerProperty(process.getPriority());
        this.processTime = new SimpleIntegerProperty(process.getTime());
        this.processMemory = new SimpleIntegerProperty(process.getMemory());
        this.processTimeIn = new SimpleIntegerProperty(process.getTimeIn());
        this.processBurstTime = new SimpleIntegerProperty(process.getBurstTime());
        this.processState = new SimpleStringProperty(process.getState().toString());
    }


    public int getProcessId() {
        return processId.get();
    }


    public SimpleIntegerProperty processIdProperty() {
        return processId;
    }

    public void setProcessId(final int processId) {
        this.processId.set(processId);
    }

    public String getProcessName() {
        return processName.get();
    }

    public SimpleStringProperty processNameProperty() {
        return processName;
    }

    public void setProcessName(final String processName) {
        this.processName.set(processName);
    }

    public int getProcessPriority() {
        return processPriority.get();
    }

    public SimpleIntegerProperty processPriorityProperty() {
        return processPriority;
    }

    public void setProcessPriority(final int processPriority) {
        this.processPriority.set(processPriority);
    }

    public int getProcessTime() {
        return processTime.get();
    }

    public SimpleIntegerProperty processTimeProperty() {
        return processTime;
    }

    public void setProcessTime(final int processTime) {
        this.processTime.set(processTime);
    }

    public int getProcessMemory() {
        return processMemory.get();
    }

    public SimpleIntegerProperty processMemoryProperty() {
        return processMemory;
    }

    public void setProcessMemory(final int processMemory) {
        this.processMemory.set(processMemory);
    }

    public int getProcessTimeIn() {
        return processTimeIn.get();
    }

    public SimpleIntegerProperty processTimeInProperty() {
        return processTimeIn;
    }

    public void setProcessTimeIn(final int processTimeIn) {
        this.processTimeIn.set(processTimeIn);
    }

    public int getProcessBurstTime() {
        return processBurstTime.get();
    }

    public SimpleIntegerProperty processBurstTimeProperty() {
        return processBurstTime;
    }

    public void setProcessBurstTime(final int processBurstTime) {
        this.processBurstTime.set(processBurstTime);
    }

    public String getProcessState() {
        return processState.get();
    }

    public SimpleStringProperty processStateProperty() {
        return processState;
    }

    public void setProcessState(final String processState) {
        this.processState.set(processState);
    }
}
