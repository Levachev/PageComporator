package org.example.worker;

import org.example.exception.ParseInputPageException;

public interface Worker {
    void execute(String yesterdayInput, String todayInput) throws ParseInputPageException;
}
