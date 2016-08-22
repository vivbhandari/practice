package algorithms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class RoomBookingSystem {
	static int roomId = 0;
	static int bookingId = 0;
	HashMap<Room, List<Booking>> bookingsMap = new HashMap<RoomBookingSystem.Room, List<RoomBookingSystem.Booking>>();

	class Room {
		int id;
		int capacity;

		Room(int id, int capacity) {
			this.id = id;
			this.capacity = capacity;
		}

		public int hashcode() {
			return id;
		}

		@Override
		public String toString() {
			return "Room [id=" + id + ", capacity=" + capacity + "]";
		}
	}

	class Booking {
		int id;
		int numOfPpl;
		Date start;
		Date end;

		public Booking(int id, int numOfPpl, Date start, Date end) {
			this.id = id;
			this.numOfPpl = numOfPpl;
			this.start = start;
			this.end = end;
		}
	}

	public void addRoom(int capacity) {
		Room room = new Room(++roomId, capacity);
		bookingsMap.put(room, new ArrayList<RoomBookingSystem.Booking>());
	}

	public void addBooking(Room room, int numOfPpl, Date start, Date end) {
		bookingsMap.get(room).add(
				new Booking(++bookingId, numOfPpl, start, end));
	}

	public List<Room> getAvaiableRooms(int numOfPpl, Date start, Date end) {
		List<Room> availableRooms = new ArrayList<RoomBookingSystem.Room>();
		for (Entry<Room, List<Booking>> entry : bookingsMap.entrySet()) {
			boolean available = true;
			int capacity = entry.getKey().capacity;
			if (capacity >= numOfPpl) {
				for (Booking booking : entry.getValue()) {
					if ((booking.start.compareTo(start) >= 0 && booking.start
							.compareTo(end) <= 0)
							|| (booking.end.compareTo(start) >= 0 && booking.end
									.compareTo(end) <= 0)) {
						available = false;
						break;
					}
				}
				if (available) {
					availableRooms.add(entry.getKey());
				}
			}
		}
		return availableRooms;
	}

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		RoomBookingSystem roomBookingSystem = new RoomBookingSystem();
		for (int i = 0; i < 9; i++) {
			int capacity = 1 + i / 3;
			roomBookingSystem.addRoom(capacity);
		}

		Date start = new Date(2016, 9, 1);
		Date end = new Date(2016, 9, 5);
		List<Room> availableRooms = roomBookingSystem.getAvaiableRooms(2,
				start, end);
		System.out.println(availableRooms);

		roomBookingSystem.addBooking(availableRooms.get(0), 2, start, end);
		availableRooms = roomBookingSystem.getAvaiableRooms(2, start, end);
		System.out.println(availableRooms);

		start = new Date(2016, 9, 4);
		end = new Date(2016, 9, 7);
		availableRooms = roomBookingSystem.getAvaiableRooms(1, start, end);
		System.out.println(availableRooms);

		start = new Date(2016, 9, 4);
		end = new Date(2016, 9, 7);
		availableRooms = roomBookingSystem.getAvaiableRooms(3, start, end);
		System.out.println(availableRooms);

		roomBookingSystem.addBooking(availableRooms.get(0), 3, start, end);
		availableRooms = roomBookingSystem.getAvaiableRooms(3, start, end);
		System.out.println(availableRooms);

		start = new Date(2016, 9, 6);
		end = new Date(2016, 9, 8);
		availableRooms = roomBookingSystem.getAvaiableRooms(2, start, end);
		System.out.println(availableRooms);

		roomBookingSystem.addBooking(availableRooms.get(0), 2, start, end);
		availableRooms = roomBookingSystem.getAvaiableRooms(2, start, end);
		System.out.println(availableRooms);

	}
}
