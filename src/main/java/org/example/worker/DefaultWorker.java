package org.example.worker;

import org.example.comparator.DefaultPageComparator;
import org.example.comparator.PageComparator;
import org.example.exception.ParseInputPageException;
import org.example.parser.DataParser;
import org.example.parser.JsonDataParser;
import org.example.util.ComparisonResult;
import org.example.util.DefaultMessageCreator;
import org.example.util.MessageCreator;

public class DefaultWorker implements Worker{

    @Override
    public void execute(String yesterdayInput, String todayInput) throws ParseInputPageException {
        DataParser dataParser = new JsonDataParser();

        var yesterdayPages = dataParser.parse(yesterdayInput);
        if(yesterdayPages == null){
            throw new ParseInputPageException("cannot parse file: "+yesterdayInput);
        }

        var todayPages = dataParser.parse(todayInput);
        if(todayPages == null){
            throw new ParseInputPageException("cannot parse file: "+todayInput);
        }

        PageComparator pageComparator = new DefaultPageComparator();
        ComparisonResult result = pageComparator.compare(yesterdayPages, todayPages);

        MessageCreator messageCreator = new DefaultMessageCreator();
        System.out.println(messageCreator.getMessage(result));
    }
}
