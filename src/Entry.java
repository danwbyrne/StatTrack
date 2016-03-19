import java.util.*;
import java.time.*;

public class Entry<T extends Number> implements Comparable<Entry<T>> {
	private T data;
	private Instant time;

	//constructors
	public Entry() {}
	public Entry(T d, Instant t) {
		data = d;
		time = t;
	}

	//equals method for Comparable implementation, wrapper to Instant equals.
	public boolean equals (Entry<T> e) {return this.time.equals(e.time);}
	//compareTo method for Comparable implementation, wrapper to Instant compareTo.
	public int compareTo(Entry<T> e) {return this.time.compareTo(e.time);}

	public T getData() {return data;}

	public static void main(String[] args) {
		Instant t1 = Instant.now();
		for (int i=0; i<1000; i++) {
			System.out.println(' ');
		}
		Instant t2 = Instant.now();
		Entry<Double> e1 = new Entry<Double>(12.1, t1);
		Entry<Double> e2 = new Entry<Double>(4.3, t2);
		System.out.println(e1.compareTo(e2));
	}
}