package algorithms;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AppointmentsConflicts {

	PriorityQueue<Appointment> sortedAppointments;

	public AppointmentsConflicts() {
		sortedAppointments = new PriorityQueue<Appointment>(
				new Comparator<Appointment>() {
					@Override
					public int compare(Appointment o1, Appointment o2) {
						return o1.start.compareTo(o2.start);
					}
				});
	}

	public void insert(Appointment appointment) {
		sortedAppointments.add(appointment);
	}

	public List<String> findConflicts() {
		List<String> conflicts = new ArrayList<String>();
		Appointment prevAppointment = null;
		while (!sortedAppointments.isEmpty()) {
			Appointment appointment = sortedAppointments.poll();
			if (prevAppointment == null) {
				prevAppointment = appointment;
			} else {
				if (prevAppointment.end.compareTo(appointment.start) > 0) {
					conflicts.add(prevAppointment.title + " and "
							+ appointment.title);
				}
				if (prevAppointment.end.compareTo(appointment.end) < 0) {
					prevAppointment = appointment;
				}
			}
		}
		return conflicts;
	}

	public static void main(String args[]) {
		AppointmentsConflicts appointmentsConflicts = new AppointmentsConflicts();

		appointmentsConflicts.insert(new Appointment("meeting 1", 9, 0, 10, 0));
		appointmentsConflicts
				.insert(new Appointment("meeting 2", 10, 0, 11, 0));
		appointmentsConflicts
				.insert(new Appointment("meeting 3", 11, 0, 11, 30));
		appointmentsConflicts
				.insert(new Appointment("meeting 4", 11, 15, 12, 15));
		appointmentsConflicts
				.insert(new Appointment("meeting 5", 12, 0, 14, 0));
		appointmentsConflicts
				.insert(new Appointment("meeting 6", 13, 0, 13, 30));
		appointmentsConflicts
				.insert(new Appointment("meeting 7", 13, 45, 14, 15));

		System.out.println(appointmentsConflicts.findConflicts());
	}
}

class Appointment {
	String title;
	Calendar start;
	Calendar end;

	public Appointment(String title, int startHour, int startMin, int endHour,
			int endMin) {
		this.title = title;
		this.start = Calendar.getInstance();
		start.set(2018, 2, 22, startHour, startMin);
		this.end = Calendar.getInstance();
		end.set(2018, 2, 22, endHour, endMin);
	}
}