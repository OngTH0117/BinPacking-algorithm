package Main;

import java.util.*;

public abstract class Algorithm {
    protected ArrayList<Double> items;
    protected double binCapacity;
    
    public Algorithm(ArrayList<Double> items, double binCapacity) {
        this.items = items;
        this.binCapacity = binCapacity;
    }
    
    //Run the algorithm and return the number of bins required
    public abstract int getResult();
    
    //Print the result
    public abstract void printResult();
}