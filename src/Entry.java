import java.util.*;

public class Entry<T extends Number> implements Comparable<Entry<T>> {
	private T data;
	private Calendar time;

	//constructors
	public Entry() {}
	public Entry(T d, Calendar t) {
		data = d;
		time = t;
	}

	public T getData() {return data;}
	public Calendar getCalendar() {return time;}

	//equals method for Comparable implementation, wrapper to Instant equals.
	public boolean equals (Entry<T> e) {return this.time.equals(e.time);}
	//compareTo method for Comparable implementation, wrapper to Instant compareTo.
	public int compareTo(Entry<T> e) {return this.time.compareTo(e.time);}
	//wrapper for the Calendar get command, simplifies things.
	public int get(int t) {return time.get(t);}


	//Calendar filter method.
	public boolean compareTime(Calendar t, int field) {
		return (get(field) == t.get(field));
	}



	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.MONTH, 4);

		Entry<Integer> e1 = new Entry<Integer>(0, c1);
		Entry<Integer> e2 = new Entry<Integer>(1, c2);

		System.out.print("Entry #1 Time: ");
		System.out.print(e1.getCalendar());
		System.out.print("\n Entry #2 Time: ");
		System.out.print(e2.getCalendar());
		System.out.print("\n\n e1.sameDay(e2): ");
		System.out.print(e1.compareTime(c2, Calendar.DAY_OF_MONTH));
	}
}