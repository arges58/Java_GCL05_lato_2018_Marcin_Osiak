import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Worker implements WorkerListener, Task, Runnable {
    //ExecutorService executor = Executors.newSingleThreadExecutor();

    String workerName;
    Thread thread;
    volatile boolean shutdown = false;
    int threadsWorking;
    public Worker(String name) {
        workerName = name;
        threadsWorking = 0;
    }

    public void enqueueTask(String taskName, Task task )
    {

    }
    public void run()
    {
        while(!shutdown)
        {

        }
    }
    public void start()
    {
        if(threadsWorking == 0)
        {
            onWorekerStarted();
            threadsWorking++;
        }
        if(!isStarted())
        {
            thread.setName("Worker"+workerName+"Thread");
            thread.start();
        }
    }
    public void stop()
    {
        if(isStarted())
        {
            shutdown = true;
            onWorkerStopped();
        }
        threadsWorking--;
    }
    public boolean isStarted()
    {
        if(thread.isAlive())
            return true;
        else
            return false;
    }
    public boolean isWorking()
    {

    }
    @Override
    public void onWorekerStarted()
    {
        thread = new Thread();
    }
    @Override
    public void onWorkerStopped()
    {
        thread = null;
    }
    @Override
    public void onTaskStarted(int taskNumber, String taskName) {

    }
    @Override
    public void onTaskCompleted( int taskNumber, String taskName )
    {

    }
    @Override
    public void run( int taskNumber ) throws InterruptedException
    {

    }
}
