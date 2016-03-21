import java.util.*;
import java.time.*;

public class Table<T extends Number> {
	//TODO: IMPLEMENT TABLE THAT STORES ENTRIES
	private List<Entry<T>> table;

	public Table() {}
	//constructor for list input.
	public Table(List<Entry<T>> entries) {table = entries;}

	public void add(Entry<T> e) {table.add(e);}

	//method to sort the table based on times of the entries.
	public void timeSort() {Collections.sort(table);}

	public T mean() {
		//TODO: T HAS TO BE SUPER OR WHATEVER OF NUMBERS. FUCK
		//OKAY YOU DID THAT BUT GONNA LEAVE TODO HERE FOR CLARITY
		Double sum = 0.0;
		for (Entry<T> entry: table) {
			sum += entry.getData().doubleValue();
		}
		sum = sum/((double)table.size());

		//I'm almost positive this "unchecked cast" is safe since T will always be extending Number.
		//Not to mention we'll probably end up using the same number type for all entries. LOOK AT THIS AGAIN LATER.
		return (T)(sum);
	}

	//TODO: THIS ONE NEEDS TO HAVE THE LIST SORTED BY DATA NOT TIME, GET TO THAT.
	public T median() {
		int mid = (table.size()/2)+1;
		return (T)(table.get(mid).getData());
	}

	public T sse() {
		double x_bar = mean().doubleValue();
		Double sum = 0.0;

		for (Entry<T> entry: table) {sum = sum + Math.pow(((entry.getData().doubleValue())-(x_bar)) , 2);}
		return (T) sum;
	}
	//the standard deviation of the data.
	public T stdDev() {
		Double ss = sse().doubleValue();
		Double dev = Math.sqrt(ss/table.size());
		return (T) dev;
	}












	public static void main(String[] args) {

		//makes some time inputs.
		Instant t1 = Instant.now();
		for (int i=0; i<1000; i++) {}
		Instant t2 = Instant.now();
		for (int i=0; i<1000; i++) {}
		Instant t3 = Instant.now();

		//makes some entries.
		Entry<Integer> e1 = new Entry<Integer>(12, t1);
		Entry<Integer> e2 = new Entry<Integer>(4, t2);
		Entry<Integer> e3 = new Entry<Integer>(2, t3);


		//unsorted list
		List<Entry<Integer>> t_list = new ArrayList<Entry<Integer>>();
		t_list.add(e2);
		t_list.add(e3);
		t_list.add(e1);

		Table<Integer> t = new Table<Integer>(t_list);

		//list gets sorted by time here.
		t.timeSort();

		System.out.println("The List: ");
		System.out.println(t.table.get(0).getData());
		System.out.println(t.table.get(1).getData());
		System.out.println(t.table.get(2).getData());
		System.out.println("");
		//wow neato
		System.out.println("Mean: ");
		System.out.println(t.mean());
		//holy shit it does means

		System.out.println("Median: ");
		System.out.println(t.median());

		System.out.println("Sum of Squares: ");
		System.out.println(t.sse());

		System.out.println("Standard deviation: ");
		System.out.println(t.stdDev());



	}
}