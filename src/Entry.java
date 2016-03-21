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

	//equals method for Comparable implementation, wrapper to Instant equals.
	public boolean equals (Entry<T> e) {return this.time.equals(e.time);}
	//compareTo method for Comparable implementation, wrapper to Instant compareTo.
	public int compareTo(Entry<T> e) {return this.time.compareTo(e.time);}

	public T getData() {return data;}
}