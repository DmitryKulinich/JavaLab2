package Exp7;

public class Main {

	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        // ��������� ������� �������:
        list.removeFirstOccurrence(3); 
        System.out.println(list);
        // ��������� ������ �������:
        list.removeFirstOccurrence(1);
        System.out.println(list);
        // ��������� ������� �������:
        list.removeFirstOccurrence(4);
        System.out.println(list);

	}

}
