package controller;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;

public class InputValidator {
   public static boolean isValidFutureDate(String date){
       String[] dateList = date.split("/");
       if (date.equals("__/__/____")) return false;
       int day = Integer.parseInt(dateList[0]);
       int month = Integer.parseInt(dateList[1]);
       int year = Integer.parseInt(dateList[2]);
       LocalDate deadline;
       try {
           deadline = LocalDate.of(year, month, day);
       }
       catch (DateTimeException dte){
           return false;
       }


       if (deadline.isBefore(LocalDate.now())){
           return false;
       }

       return true;
   }

   public static String returnJustDigits(String value)
   {
       String justDigits = "";
       String startVal = value;
       for(int id = 0; id < startVal.length(); id++)
       {
           if (Character.isDigit(startVal.charAt(id)))
               justDigits += startVal.charAt(id);

       }
       return justDigits;
   }
}
