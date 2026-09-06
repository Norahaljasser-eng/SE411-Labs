package edu.psu.se411;

import java.util.List;
public class App {
    public static void main(String[] args) {
    	String[] names = {"Norah", "Lama", "Yara"};

    	PrintableList<String> stringList = new PrintableList<>(names);

    	stringList.printList();
    	
    	Integer[] numbers = {1, 2, 3, 4, 5};

    	PrintableList<Integer> integerList = new PrintableList<>(numbers);

    	integerList.printList();
    	
    	NumberBox<Integer> intBox = new NumberBox<>();

    	intBox.setItem(10);

    	System.out.println(intBox.getItem());
    	System.out.println(intBox.sum(5));
    	
    	NumberBox<Double> doubleBox = new NumberBox<>();

    	doubleBox.setItem(7.5);

    	System.out.println(doubleBox.getItem());
    	System.out.println(doubleBox.sum(2.5));
    	
    	System.out.println("Wildcard print:");

    	printList(stringList.getList());
    	printList(integerList.getList());
    	
    	System.out.println("Sum of numbers:");

    	System.out.println(sumNumbers(integerList.getList()));
    }
    
    
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }

}
