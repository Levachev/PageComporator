package org.example.comparator;

import org.example.util.ComparisonResult;

import java.util.Map;

public interface PageComparator {
    ComparisonResult compare(Map<String, String> yesterdayPages,
                             Map<String, String> todayPages);
}
