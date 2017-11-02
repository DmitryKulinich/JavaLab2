package Exp5;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		MyList<Integer> a = new MyList<>(5, 7);
        a.add(5, 1);
        a.add(6, 2);
        a.add(7, 1);
        System.out.println(a.get(5) + " " + a.get(6)  + " " + a.get(6)); 
        System.out.println(a.indexOf(2));              
        a.set(5, 3);
        for (Integer k : a) {
            System.out.print(k + " ");                   
        }
        System.out.println();
        a.remove(6);
        System.out.println(a);                         
        a.addAll(Arrays.asList(new Integer[]{ 4, 5 }));
        System.out.println(a.get(7)); 

	}

}
