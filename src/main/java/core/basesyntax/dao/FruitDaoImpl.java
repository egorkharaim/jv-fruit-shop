package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(String fruit, int quantity) {
        int currentQuantity = Storage.fruits.getOrDefault(fruit, 0);
        Storage.fruits.put(fruit, currentQuantity + quantity);

    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return Storage.fruits;
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.fruits.get(fruit);
    }

}
