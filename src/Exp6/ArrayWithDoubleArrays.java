package Exp6;

import java.util.*;

public class ArrayWithDoubleArrays extends  AbstractArrayOfPoints {
	private ArrayList<Double> points = new ArrayList<>();
	
	@Override
	public void setPoint(int i, double x, double y) {
		if(i < count()) {
			points.set(i * 2, x);
			points.set((i * 2)+ 1, y);
		}
	}
	
	@Override
	public double getX(int i) {
		return points.get(i * 2);
	}
	
	@Override
	public double getY(int i) {
		return points.get((i * 2) + 1);
	}
	
	@Override
	public int count() {
		return (points.size() / 2);
	}
	
	@Override
	public void addPoint(double x, double y) {
		points.add(x);
		points.add(y);
	}
	
	@Override
	public  void removeLast() {
		if(count() == 0)
			return;
		points.remove(points.size() - 1);
		points.remove(points.size() - 2);
	}
	

}
