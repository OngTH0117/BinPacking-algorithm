package Main;

import java.util.*;

public class RecycleBin {
	//Total capacity of the bin
	protected double capacity;
	//Current occupied capacity of the bin
	protected double currentCapacity;
	//An array list of items stored in the bin
	protected ArrayList<Double> items;
	
	public RecycleBin(double capacity) {
		//Constructor
		this.capacity = capacity;
		this.currentCapacity = 0;
		this.items = new ArrayList<Double>();
	}
 
	public boolean addItem(double item) {
		//To store an item into the bin
		if (currentCapacity + item <= capacity) {
			currentCapacity = currentCapacity + item;
			items.add(item);
			return true;
		}
		else {return false;}
	}
	
	@Override
	public String toString() {
		//To print the items stored in the bin
	String result = " ";
	
	for (int i = 0; i < items.size(); i++) {
			result += items.get(i) + " ";
		}
	return result;
	}
}



