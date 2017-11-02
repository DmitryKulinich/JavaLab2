package Exp7;

public class Main {

	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        // Видаляємо середній елемент:
        list.removeFirstOccurrence(3); 
        System.out.println(list);
        // Видаляємо перший елемент:
        list.removeFirstOccurrence(1);
        System.out.println(list);
        // Видаляємо останній елемент:
        list.removeFirstOccurrence(4);
        System.out.println(list);

	}

}
