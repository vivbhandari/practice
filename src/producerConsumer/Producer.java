package producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	private int id;
	private final ArrayBlockingQueue<Task> queue;
	private static AtomicInteger sequence = new AtomicInteger();
	private static Random random = new Random();

	public Producer(int id, ArrayBlockingQueue<Task> queue) {
		this.id = id;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int taskId = sequence.getAndIncrement();
				System.out.println("Producer " + id + " producing task "
						+ taskId);
				int processingTime = random.nextInt(4);
				Thread.sleep(1000);
				Task task = new Task(taskId, processingTime);
				queue.put(task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
