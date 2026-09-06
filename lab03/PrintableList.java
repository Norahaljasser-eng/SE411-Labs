package edu.psu.se411;
import java.util.List;
import java.util.Arrays;

public class PrintableList<T> {
	private List<T> list;
	public PrintableList(T[] items) {
	    list = Arrays.asList(items);
	}
	public List<T> getList() {
	    return list;
	}
	public void printList() {
	    for (T item : list) {
	        System.out.println(item);
	    }
	}
}
