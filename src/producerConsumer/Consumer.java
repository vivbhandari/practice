package producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {
	private int id;
	private final ArrayBlockingQueue<Task> queue;

	public Consumer(int id, ArrayBlockingQueue<Task> queue) {
		this.id = id;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Task task = queue.take();
				System.out.println("Consumer " + id + " consuming task "
						+ task.id);
				Thread.sleep(1000 * task.processingTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
