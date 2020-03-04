package com.carparkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionIntiator {
    public static void main(String[] args) throws Exception{
        InputParser inputParser = new InputParser();
        switch (args.length) {
            case 0:
                System.out.println("Type 'exit' to quit");
                for (;;) {
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                           throw new NullPointerException("Input is null or Empty");
                        } else {
                            inputParser.parseTextInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("Error occured in reading the input");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                inputParser.parseFileInput(args[0]);
                break;
            default:
                System.out.println("Wrong Input");
        }
    }
}
