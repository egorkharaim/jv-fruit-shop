package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        Map<String, Integer> allFruits = fruitDao.getAllFruits();

        for (Map.Entry<String, Integer> entry : allFruits.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();

    }

}
