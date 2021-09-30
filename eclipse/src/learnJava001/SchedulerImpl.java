package learnJava001;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

//import com.sun.tools.javac.util.List;

interface Job {
    void work();
    int priority();
}

interface Scheduler {
    List<Job> completed();
    void waitAll();
    void schedule(Job j);
    void scheduleMany(Job... jobs);
    void dispose();
}

public class SchedulerImpl implements Scheduler{
    static int TOTAL_WOERKERS_COUNT = 10; //TODO: Nothing works if value more then 1 :-(
    Queue<Job> jobs_queue = new LinkedList<>();
    private ReentrantLock mutex = new ReentrantLock();
    List<Job> jobs = new ArrayList<Job>();
    List<Thread> threads = new ArrayList<Thread>();
    public boolean stopped;
    @Override
    public List<Job> completed(){
    	return jobs;
    };
    @Override
   public void dispose() {
        stopped = true;
        waitAll();
    }
    @Override
   public void waitAll() {
        threadSleep(1000);
    }
    
    public SchedulerImpl() {
        mutex.lock();
        try {
            for (int i = 0; i < TOTAL_WOERKERS_COUNT; i++) {
                Thread thread = new Thread() {
                    public void run() {
                       // threads.add(thread);
                        while (!stopped) {
                            Job j = jobs_queue.poll();
                            if (j != null) {
                                j.work();
                                jobs.add(j);
                            } else {
                                threadSleep(100);
                            }
                        }
                    }

                };

                thread.start();
                threads.add(thread);
            }
        } finally {
            mutex.unlock();
        }

    }

    private void threadSleep(int milliseconds) {
        try {
            //50 should be enough
            Thread.sleep(100);
        } catch (Exception e) {
        }
    }
    @Override
   public void schedule(Job j) {
        jobs.add(j);
        jobs_queue.add(j);
    }

    public List<Job> Completed() {
        return jobs;
    }

	@Override
	public void scheduleMany(Job... jobs) {
		// TODO Auto-generated method stub
		
	}
}

class ScheduleExt extends SchedulerImpl {
	
    void ScheduleMany(Job... jobs) {
        fastSort(jobs);
        for (Job job : jobs) {
            schedule(job);
        }
    }

    static void fastSort(Job[] arr) {
        int n = arr.length;
        Job temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].priority() < arr[j].priority()) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}