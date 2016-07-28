package main.java.toolBox.collection;

import java.util.ArrayList;

/**
 * Created by Ari on 7/20/16.
 */
public class ArrayListExample {
    // Create a new ArrayList named name that holds Strings
    ArrayList<String> names = new ArrayList();

    public static void main(String[] args) {
        ArrayListExample arrayListExample = new ArrayListExample();
        arrayListExample.addElement("Bob");
        arrayListExample.addElement("Sally");
        arrayListExample.addElement("Rex");
        arrayListExample.addElement("Tim");
        arrayListExample.addElement("Ed");
        arrayListExample.addElement("Toe");
        arrayListExample.addElement("Twinkle");
        System.out.println("Element at 4: " +arrayListExample.getElement(4));
        System.out.println("____________");
        arrayListExample.printAllElements();
    }

    // add another String to the ArrayList
    public void addElement(String name) {
        names.add(name);
    }

    // get a String from the ArrayList at a specific index
    public String getElement(int index) {
        return names.get(index);
        //String tmpName = names.get(index);
        //return tmp name ... this is redundant... use the one that is simple

    }

    // print out all the Strings in the ArrayList
    public void printAllElements() {
        System.out.println("___To String___");
        System.out.println(names.toString());

    }

}
