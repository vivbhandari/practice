package timerExample;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
	int id;

	public MyTimerTask(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Timer task " + id + " started at:" + new Date());
		completeTask();
		System.out.println("Timer task " + id + " finished at:" + new Date());
	}

	private void completeTask() {
		try {
			// assuming it takes 2 secs to complete the task
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		// TimerTask timerTask = new MyTimerTask();
		// running timer task as daemon thread
		Timer timer = new Timer(true);
		// timer.scheduleAtFixedRate(timerTask, 0, 1 * 1000);
		timer.schedule(new MyTimerTask(1), 100);
		timer.schedule(new MyTimerTask(2), 300);
		timer.schedule(new MyTimerTask(3), 100);
		timer.schedule(new MyTimerTask(4), 200);
		timer.schedule(new MyTimerTask(5), 100);
		System.out.println("TimerTask started");
		// cancel after sometime
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
