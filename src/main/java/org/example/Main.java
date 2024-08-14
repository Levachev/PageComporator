package org.example;

import org.example.exception.ParseInputPageException;
import org.example.worker.DefaultWorker;
import org.example.worker.Worker;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("arguments have to contain 2 file name with data");
            return;
        }

        String yesterdayInput = args[0];
        String todayInput = args[1];

        //to test in idea
        /*String yesterdayInput = "./src/main/resources/data/yesterday.json";
        String todayInput = "./src/main/resources/data/today.json";*/

        Worker worker = new DefaultWorker();
        try {
            worker.execute(yesterdayInput, todayInput);
        } catch (ParseInputPageException e){
            System.out.println(e.getMessage());
        }
    }
}