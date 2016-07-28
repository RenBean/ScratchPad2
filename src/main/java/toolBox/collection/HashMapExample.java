package main.java.toolBox.collection;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Ari on 7/20/16.
 */
public class HashMapExample {

        // Create a new HashMap named names that holds String,String
        HashMap<String, String> names = new HashMap<>();
        // add another key,value to the HashMap

    public void addElement(String key, String value) {
        names.put(key, value);
    }

    // get a value from the HashMap at a specific key
    public String getValue(String key) {
        return names.get(key);
    }

    // print out all the Strings in the HashMap
    public void printAllElements() {
        //Set<String> keys = names.keySet();
        for (String name : names.values()) {
            System.out.println(name);
        }
    }

}

