package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> reportData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < reportData.size(); i++) {
            String line = reportData.get(i);
            String[] valuesArray = line.split(CSV_SEPARATOR);
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getByCode(valuesArray[OPERATION_INDEX]);
            String fruit = valuesArray[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(valuesArray[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
