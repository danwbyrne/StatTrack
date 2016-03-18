import java.util.*;
import java.time.*;

public class Table<T> {
	//TODO: IMPLEMENT TABLE THAT STORES ENTRIES
	private List<Entry<T>> table;

	public Table() {}
	//constructor for list input.
	public Table(List<Entry<T>> entries) {table = entries;}

	public void add(Entry<T> e) {table.add(e);}

	//method to sort the table based on times of the entries.
	public void timeSort() {Collections.sort(table);}

	//stat methods.
	public T mean() {
		//TODO: T HAS TO BE SUPER OR WHATEVER OF NUMBERS. FUCK
		// PICK UP HERE
	}


















	public static void main(String[] args) {
		Instant t1 = Instant.now();
		for (int i=0; i<1000; i++) {
			System.out.println(' ');
		}
		Instant t2 = Instant.now();
		for (int i=0; i<1000; i++) {
			System.out.println(' ');
		}
		Instant t3 = Instant.now();

		Entry<Double> e1 = new Entry<Double>(12.1, t1);
		Entry<Double> e2 = new Entry<Double>(4.3, t2);
		Entry<Double> e3 = new Entry<Double>(2.8, t3);


		//unsorted list
		List<Entry<Double>> t_list = new ArrayList<Entry<Double>>();
		t_list.add(e2);
		t_list.add(e3);
		t_list.add(e1);

		Table<Double> t = new Table<Double>(t_list);

		//list gets sorted by time here.
		t.timeSort();

		System.out.println(t.table.get(0).getData());
		System.out.println(t.table.get(1).getData());
		System.out.println(t.table.get(2).getData());
		//wow neato


	}
}