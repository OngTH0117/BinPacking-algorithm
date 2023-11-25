package Main;

import java.util.*;
public class FirstFit extends Algorithm{
	protected List<RecycleBin> bins = new ArrayList<RecycleBin>();

	public FirstFit(ArrayList<Double> items, double binCapacity) {
		super(items, binCapacity);
	}
	
	@Override
	public int getResult() {
	bins.add(new RecycleBin(binCapacity));
		for (Double currentItem : items) {
			//A boolean to keep track if item is put in RecycleBin successfully or not
			boolean itemAdded = false;
			//Current index of bin being put items in
			int binIndex = 0;
			while (!itemAdded) {
				if(binIndex == bins.size()) {
					//item did not fit in the last RecycleBin, create a new RecycleBin and put it there
					RecycleBin newBin = new RecycleBin(binCapacity);
					newBin.addItem(currentItem);
					bins.add(newBin);
					itemAdded = true;
				}
				else if (bins.get(binIndex).addItem(currentItem)) {
					//item fit in current bin
					itemAdded = true;
				}
				else{
					//try next bin
					binIndex++;
				}
			}
		}
		return bins.size();
	}
	
	@Override
	public void printResult() {
		int i = 1;
		for (RecycleBin bin : bins) {
        	System.out.println("Bin " + i + ": " + bin.toString());
        	i++;
        }
	}
}