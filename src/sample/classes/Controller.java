package sample.classes;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class
Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Table> processTableReadyQueue;

    @FXML
    private TableColumn<Table, Integer> processIdReadyQueue;


    @FXML
    private TableColumn<Table, String> processNameReadyQueue;

    @FXML
    private TableColumn<Table, Integer> processPriorityReadyQueue;

    @FXML
    private TableColumn<Table, Integer> processTimeReadyQueue;


    @FXML
    private TableColumn<Table, Integer> processMemoryReadyQueue;


    @FXML
    private TableColumn<Table, Integer> processTimeInReadyQueue;


    @FXML
    private TableColumn<Table, Integer> processBurstTimeReadyQueue;


    @FXML
    private TableColumn<Table, String> processStateReadyQueue;

    @FXML
    private TableView<Table> processTableRejectQueue;

    @FXML
    private TableColumn<Table, Integer> processIdRejectQueue;

    @FXML
    private TableColumn<Table, String> processNameRejectQueue;

    @FXML
    private TableColumn<Table, Integer> processPriorityRejectQueue;

    @FXML
    private TableColumn<Table, Integer> processTimeRejectQueue;

    @FXML
    private TableColumn<Table, Integer> processMemoryRejectQueue;

    @FXML
    private TableColumn<Table, Integer> processTimeInRejectQueue;

    @FXML
    private TableColumn<Table, Integer> processBurstTimeRejectQueue;

    @FXML
    private TableColumn<Table, String> processStateRejectQueue;

    @FXML
    private TableView<Table> processTableFinishedQueue;

    @FXML
    private TableColumn<Table, Integer> processIdFinishedQueue;

    @FXML
    private TableColumn<Table, String> processNameFinishedQueue;

    @FXML
    private TableColumn<Table, Integer> processPriorityFinishedQueue;

    @FXML
    private TableColumn<Table, Integer> processTimeFinishedQueue;

    @FXML
    private TableColumn<Table, Integer> processMemoryFinishedQueue;

    @FXML
    private TableColumn<Table, Integer> processTimeInFinishedQueue;

    @FXML
    private TableColumn<Table, Integer> processBurstTimeFinishedQueue;

    @FXML
    private TableColumn<Table, String> processStateFinishedQueue;

    private String name;

    /**
     * Method context menu
     *
     * @param event event
     */
    @FXML
    public void contextMenu(final ActionEvent event) {
        try {
            if (!processTableReadyQueue.getSelectionModel().getSelectedItem().getProcessName().isEmpty()) {
                name = processTableReadyQueue.getSelectionModel().getSelectedItem().getProcessName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set high priority of the process
     *
     * @param event event
     */
    @FXML
    public void highLevel(final ActionEvent event) {
        setPriority(1);
    }

    /**
     * Set above average priority of the process
     *
     * @param event event
     */
    @FXML
    public void aboveAverageLevel(final ActionEvent event) {
        setPriority(6);
    }

    /**
     * Set middle priority of the process
     *
     * @param event event
     */
    @FXML
    public void middleLevel(final ActionEvent event) {
        setPriority(12);
    }

    /**
     * Set below average priority of the process
     *
     * @param event event
     */
    @FXML
    public void belowAverageLevel(final ActionEvent event) {
        setPriority(24);
    }

    /**
     * Set low priority of the process
     *
     * @param event event
     */
    @FXML
    public void lowLevel(final ActionEvent event) {
        setPriority(30);
    }



    /**
     * All processes quantity
     */
    @FXML
    private TextField allProcessesQuantity;
    /**
     * Quantity reject queue
     */

    @FXML
    private TextField quantityRejectQueue;
    /**
     * Quantity finished queue
     */
    @FXML
    private TextField quantityFinishedQueue;
    /**
     * Quantity processes left system
     */
    @FXML
    private TextField quantityProcessesLeftSystem;
    /**
     * Average service wait
     */
    @FXML
    private TextField averageServiceWait;
    /**
     * Processor idle cycles
     */
    @FXML
    private TextField processorIdleCycles;
    /**
     * Average waiting time for a process in a ready queue
     */
    @FXML
    private TextField averageProcessWait;
    /**
     * Average time of the process
     */
    @FXML
    private TextField averageProcessTime;

    /**
     * Object of RunningProcesses
     */
    private static RunningProcesses runningProcesses = new RunningProcesses();
    /**
     * Object of RefreshRunningProcesses
     */
    private RefreshRunningProcesses refreshRunningProcesses = new RefreshRunningProcesses(runningProcesses);
    /**
     * Object of UpdateTable
     */
    private UpdateTable updateTable = new UpdateTable();
    /**
     * Object of ObservableList
     */
    private static ObservableList<Table> dataReadyQueue = FXCollections.observableArrayList();
    /**
     * Object of ObservableList
     */
    private static ObservableList<Table> dataRejectQueue = FXCollections.observableArrayList();
    /**
     * Object of ObservableList
     */
    private static ObservableList<Table> dataFinishedQueue = FXCollections.observableArrayList();


    /**
     * Initialize of Controller
     */
    @FXML
    public void initialize() {
        processIdReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processId"));
        processNameReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processName"));
        processPriorityReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processPriority"));
        processTimeReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTime"));
        processMemoryReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processMemory"));
        processTimeInReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTimeIn"));
        processBurstTimeReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processBurstTime"));
        processStateReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processState"));
        processIdRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processId"));
        processNameRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processName"));
        processPriorityRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processPriority"));
        processTimeRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTime"));
        processMemoryRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processMemory"));
        processTimeInRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTimeIn"));
        processBurstTimeRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processBurstTime"));
        processStateRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processState"));
        processIdFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processId"));
        processNameFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processName"));
        processPriorityFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processPriority"));
        processTimeFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTime"));
        processMemoryFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processMemory"));
        processTimeInFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTimeIn"));
        processBurstTimeFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processBurstTime"));
        processStateFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processState"));
        processTableReadyQueue.setItems(dataReadyQueue);
        processTableRejectQueue.setItems(dataRejectQueue);
        processTableFinishedQueue.setItems(dataFinishedQueue);
        refreshRunningProcesses.run();
        updateTable.run();
        Statistics();
    }

    /**
     * Update table of ready queue
     */
    public static void updateTableReadyQueue() {
        dataReadyQueue.clear();
        if (!runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue().isEmpty()) {
            try {
                for (final Process process : runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue()) {
                    dataReadyQueue.add(new Table(process));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Update table of reject queue
     */
    public static void updateTableRejectQueue() {
        dataRejectQueue.clear();
        if (!runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getRejectQueue().isEmpty()) {
            try {
                for (final Process process : runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getRejectQueue()) {
                    dataRejectQueue.add(new Table(process));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Update table of finished queue
     */
    public static void updateTableFinishedQueue() {
        dataFinishedQueue.clear();
        if (!runningProcesses.getCreateRunningProcesses().getQueue().getFinishedQueue().getFinishedQueue().isEmpty()) {
            try {
                for (final Process process : runningProcesses.getCreateRunningProcesses().getFinishedQueue().getFinishedQueue()) {

                    dataFinishedQueue.add(new Table(process));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set priority of the process
     *
     * @param priority priority
     */
    private void setPriority(final int priority) {
        final ArrayList<Process> processes = runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue();
        int i = 0;
        for (final Process process : processes) {
            i++;
            if (process.getName().equals(name)) {
                break;
            }
        }
        try {
            runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue().get(i).setPriority(priority);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Statistics() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (!runningProcesses.getCreateRunningProcesses().getQueue().getQueue().isEmpty()) {
                    allProcessesQuantity.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getQueue().getLastID()));
                }
                if (!runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getRejectQueue().isEmpty()) {
                    quantityRejectQueue.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getQuantityRejectQueue()));
                }
                if (!runningProcesses.getCreateRunningProcesses().getQueue().getFinishedQueue().getFinishedQueue().isEmpty()) {
                    quantityFinishedQueue.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getFinishedQueue().getQuantityFinishedQueue()));
                }
                quantityProcessesLeftSystem.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getQuantityProcessesLeft()));
                if (runningProcesses.getCreateRunningProcesses().getQueue().getAverageServiceWait() != 0) {
                    averageServiceWait.setText(runningProcesses.getCreateRunningProcesses().getQueue().getAverageServiceWait() / runningProcesses.getCreateRunningProcesses().getQueue().getLastID() + " tact(s)");
                }
                processorIdleCycles.setText(runningProcesses.getProcessorIdleCycles() + " tact(s)");
                if (runningProcesses.getCreateRunningProcesses().getAverageProcessAwaitingTime() != 0) {
                    averageProcessWait.setText(runningProcesses.getCreateRunningProcesses().getAverageProcessAwaitingTime() / runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getQuantityReadyQueue() + " tact(s)");
                }
                if (runningProcesses.getCreateRunningProcesses().getAverageProcessTime() != 0) {
                    averageProcessTime.setText(runningProcesses.getCreateRunningProcesses().getAverageProcessTime() / runningProcesses.getCreateRunningProcesses().getFinishedQueue().getQuantityFinishedQueue() + " tact(s)");
                }
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(timerTask, delay, period);
    }
}
