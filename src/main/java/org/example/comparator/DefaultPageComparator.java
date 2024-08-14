package org.example.comparator;

import org.example.util.ComparisonResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultPageComparator implements PageComparator{

    @Override
    public ComparisonResult compare(Map<String, String> yesterdayPages,
                                    Map<String, String> todayPages) {
        List<String> disappearedPages = new ArrayList<>(yesterdayPages.keySet().stream().toList());
        List<String> newPages = new ArrayList<>();
        List<String> updatedPages = new ArrayList<>();

        for (var entry : todayPages.entrySet()) {

            String yesterdayPageAnalog = yesterdayPages.get(entry.getKey());
            if(yesterdayPageAnalog == null){
                newPages.add(entry.getKey());
            } else if(!yesterdayPageAnalog.equals(entry.getValue())){
                updatedPages.add(entry.getKey());
            }

            disappearedPages.remove(entry.getKey());
        }

        return new ComparisonResult(disappearedPages, newPages, updatedPages);
    }
}
