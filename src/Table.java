import java.util.*;
import java.time.*;

public class Table<T extends Number> {
	//TODO: IMPLEMENT TABLE THAT STORES ENTRIES
	private List<Entry<T>> table;

	public Table() {table = new ArrayList();}
	//constructor for list input.
	public Table(List<Entry<T>> entries) {table = entries;}

	public void add(Entry<T> e) {table.add(e);}
	public void newEntry(T d, Calendar c) {
		Entry<T> e = new Entry<T>(d,c);
		table.add(e);
	}
	public int size() {return table.size();}

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

	//returns a filtered table based on a Calendar field comparator.
	public Table<T> timeFilter(Calendar t, int comp) {
		Table<T> filtered = new Table<T>();
		for (Entry<T> entry: table) {
			if (entry.compareTime(t, comp)) {filtered.add(entry);}
		}
		return filtered;
	}







	public static void main(String[] args) {
		Table<Integer> t = new Table<Integer>();
		for (int i=0; i<1000; i++) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, i);
			t.newEntry(1, c);
		}
		Calendar c = Calendar.getInstance();
		Table<Integer> t_f = t.timeFilter(c, Calendar.MONTH);
		System.out.println(t.size());
		System.out.println(t_f.size());



	}
}