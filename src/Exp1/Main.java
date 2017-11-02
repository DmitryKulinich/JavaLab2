package Exp1;

/**
 * Created by dmitry on 5/16/17.
 */

public class Main {
    public static void main(String[] args) {

        ReadWriteTXT TXT = new ReadWriteTXT();
        TXT = TXT.readTXT("Read");
        System.out.println(TXT);
        TXT.sortByPasenger();
        TXT.writeTXT("Write");

        System.out.println("\n\n________________________***____________________________\n\n");

        ReadWriteXML XML = new ReadWriteXML();
        XML = XML.readXML("Read.xml");
        XML.sortByPasenger();
        System.out.println(XML);
        XML.WriteXML("Write.xml");

    }
}
