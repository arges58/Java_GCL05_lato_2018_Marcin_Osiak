public interface WorkerListener {

    public void onWorekerStarted();
    public void onWorkerStopped();
    public void onTaskStarted( int taskNumber, String taskName );
    public void onTaskCompleted( int taskNumber, String taskName );
}
