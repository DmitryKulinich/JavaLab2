package Exp4;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> accounts = new HashMap<>();
		accounts.put("Adsjaf", "yewqhdsagfsdhashg");
		accounts.put("Qerfh", "ewtyr");
		accounts.put("Qwert", "1234");
		for(Map.Entry<String, String> account : accounts.entrySet()) {
			if(account.getValue().length() >= 6) {
				System.out.println(account.getKey() + " " + account.getValue());
			}
		}

	}

}
