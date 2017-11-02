package Exp2;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(myString);
		Set<String> set = new TreeSet<>();
		while(tokenizer.hasMoreTokens()) {
			 set.add(tokenizer.nextToken());
		 }
		System.out.println(set);
	}
}
