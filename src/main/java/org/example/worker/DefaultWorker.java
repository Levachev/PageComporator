package org.example.worker;

import org.example.ComparisonResult;
import org.example.comparator.DefaultPageComparator;
import org.example.comparator.PageComparator;
import org.example.parser.DataParser;
import org.example.parser.JsonDataParser;

public class DefaultWorker implements Worker{

    @Override
    public void execute(String yesterdayInput, String todayInput) {
        DataParser dataParser = new JsonDataParser();

        var yesterdayPages = dataParser.parse(yesterdayInput);
        var todayPages = dataParser.parse(todayInput);

        PageComparator pageComparator = new DefaultPageComparator();
        ComparisonResult result = pageComparator.compare(yesterdayPages, todayPages);

        //TODO output
    }
}
