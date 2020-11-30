package com.codegym;

import java.util.ArrayList;
import java.util.Set;

public class CollectionUtilsAdapter implements CollectionOperations {

    @Override
    public int findMax(Set<Integer> numbers) {
        CollectionUtils utils = new CollectionUtils();
        return utils.findMax(new ArrayList<>(numbers));
    }
}
