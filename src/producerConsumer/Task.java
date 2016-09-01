package producerConsumer;

public class Task {

	int id;
	int processingTime;

	public Task(int id, int processingTime) {
		super();
		this.id = id;
		this.processingTime = processingTime;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", processingTime=" + processingTime + "]";
	}

}
