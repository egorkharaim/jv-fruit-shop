package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(String fruit, int quantity) {
        int currentQuantity = Storage.getFruits().getOrDefault(fruit, 0);
        Storage.getFruits().put(fruit, currentQuantity + quantity);

    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(Storage.getFruits());
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.getFruits().get(fruit);
    }

}
