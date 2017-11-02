package Exp3;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PriorityQueue<Double> queue = new PriorityQueue<>(100, new Comparator<Double>() {
			@Override
			public int compare(Double d1, Double d2) {
				return Double.compare(Math.abs(d1), Math.abs(d2));
			}
		});
		Double k;
		do {
			k = scanner.nextDouble();
			if(k != 0)
				queue.add(k);
		} while(k != 0);
		
		int p = 1;
		while((k = queue.poll()) != null) {
			 p *= k;
			 System.out.print(k + " ");
		}
		System.out.println();
		System.out.println(p);
	}

}
