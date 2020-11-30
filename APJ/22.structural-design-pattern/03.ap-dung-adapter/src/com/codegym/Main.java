package com.codegym;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> testSet = new HashSet<>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
        testSet.add(6);
        testSet.add(-1);
        testSet.add(5);


        CollectionUtilsAdapter adapter = new CollectionUtilsAdapter();
        Client client = new Client(adapter);
        client.printMaxValue(testSet);
    }
}
