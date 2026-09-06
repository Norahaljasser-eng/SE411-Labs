package edu.psu.se411;

public class NumberBox<T extends Number> {
	
	private T item;
	
	public void setItem(T item) {
	    this.item = item;
	}
	public T getItem() {
	    return item;
	}
	public double sum(T other) {
	    return item.doubleValue() + other.doubleValue();
	}
}
