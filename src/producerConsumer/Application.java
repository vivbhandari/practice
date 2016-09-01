package producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {
	private final ArrayBlockingQueue<Task> queue;
	private List<Producer> producers = new ArrayList<Producer>();
	private List<Consumer> consumers = new ArrayList<Consumer>();

	public Application(int queueCapacity, int numOfProducers, int numOfConsumers) {
		queue = new ArrayBlockingQueue<Task>(queueCapacity);

		for (int i = 0; i < numOfProducers; i++) {
			Producer producer = new Producer(i, queue);
			producers.add(producer);
		}

		for (int j = 0; j < numOfConsumers; j++) {
			Consumer consumer = new Consumer(j, queue);
			consumers.add(consumer);
		}
	}

	public void start() {
		for (Producer producer : producers) {
			new Thread(producer).start();
		}

		for (Consumer consumer : consumers) {
			new Thread(consumer).start();
		}
	}

	public static void main(String args[]) {
		Application application = new Application(4, 2, 3);
		application.start();
	}
}
