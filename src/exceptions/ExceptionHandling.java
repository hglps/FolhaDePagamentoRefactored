package exceptions;

import java.util.ArrayList;
import java.util.Scanner;

public class ExceptionHandling {
    public Scanner read = new Scanner(System.in);

    public double returnValidDouble(){
        double value = -1;
        boolean error = true;
        while(error) {
            try {
                value = read.nextDouble();
                error = false;
            } catch (Exception e) {
                System.out.print("INVALID INPUT! Expected a float value!\nNumber format: 9999,99. Try again!\nR$");
                read.nextLine();
                error = true;
            }
            if (value <= 0) {
                System.out.println("Expecting value greater than zero! Try again!");
                error = true;
            }
        }
        return value;
    }
    public double returnValidRate(){
        boolean error = true;
        double commissionRate = -1;
        while(error && (commissionRate < 0.01 || commissionRate > 0.99)){
            try{
                commissionRate = read.nextDouble();
                error = false;
            }
            catch(Exception e){
                System.out.print("Invalid INPUT! Expected float value!\nNumber format: 0,01 to 0,99. Try again!\nRate: ");
                read.nextLine();
                error = true;
            }
            if (commissionRate < 0.01 || commissionRate > 0.99) {
                System.out.println("Invalid input! Insert again! (Input: from 0,01 to 0,99)");
                error = true;
            }
            else break;
        }
        return commissionRate;
    }
    public int returnValidHour(){
        int hour = -1;
        boolean error = true;
        while ((hour < 0 || hour > 23) && error ) {
            try {
                hour = read.nextInt();
                error = false;
            }
            catch(Exception e){
                System.out.println("Invalid input ! Expecting integer value! Try again!");
                read.nextLine();
                error = true;
            }
            if (hour < 0 || hour > 23) {
                System.out.println("\nExpecting hour between 0 and 23! Insert again!\n");
                error = true;
            }
            else break;
        }
        return hour;
    }
    public int returnValidMinute(){
        int minute = -1;
        boolean error = true;
        while ((minute < 0 || minute > 59) && error) {
            System.out.println("Insert minute of entrance: (Number format: 0 to 59");
            try {
                minute = read.nextInt();
                error = false;
            }
            catch(Exception e){
                System.out.println("Expecting integer value! Try again!");
                read.nextLine();
                error = true;
            }
            if (minute < 0 || minute > 59) {
                System.out.println("\nInvalid input! Insert again!\n");
                error = true;
            }
            else break;
        }
        return minute;
    }

    public String returnValidTypePayment(){
        String typePayment;
        while(true){
            typePayment = read.nextLine();
            if(!typePayment.equals("h" ) && !typePayment.equals("s") && !typePayment.equals("c"))
                System.out.println("Invalid input! Only accepting 'h', 's' or 'c'");
            else break;
        }
        return typePayment;
    }
    public String returnValidWayPayment(){
        String wayPayment;
        while(true){
            wayPayment = read.nextLine();
            if(!wayPayment.equals("check via mail") && !wayPayment.equals("check in hands") && !wayPayment.equalsIgnoreCase("deposit"))
                System.out.println("Invalid input!");
            else break;
        }
        return wayPayment;
    }
    public boolean returnValidPartOfUnion(){
        String partOfUnion;
        while(true){
            partOfUnion = read.nextLine();
            if(!partOfUnion.equalsIgnoreCase("yes") && !partOfUnion.equalsIgnoreCase("no"))
                System.out.println("Invalid input! Expecting only 'yes' or 'no' input! Try again!");
            else break;
        }
        return partOfUnion.equalsIgnoreCase("yes");
    }
    public int returnValidChangeRegisterChoice(){
        boolean error = true;
        int choice = -1;
        while(error){
            try{
                choice = read.nextInt();
                error = false;
            }
            catch(Exception e){
                System.out.print("INVALID INPUT! Expecting an integer value! Try again!\nChoice: ");
                read.nextLine();
                error = true;
            }
            if(choice < 0 || choice > 6){
                System.out.print("Invalid entry! Expecting values from 0 to 6! Try again! Choice:");
                error = true;
            }
            else break;
        }
        return choice;
    }
    public int returnValidShowInfo(){
        boolean error = true;
        int choice = -1;
        while(error){
            try{
                choice = read.nextInt();
                error = false;
            }
            catch(Exception e){
                System.out.print("INVALID INPUT! Expecting an integer value! Try again!\nChoice: ");
                read.nextLine();
                error = true;
            }
            if(choice < 1 || choice > 2){
                System.out.print("Invalid entry! Expecting values as '1' or '2' ! Try again! Choice:");
                error = true;
            }
            else break;
        }
        return choice;
    }

    public String returnValidType(){
        String entry;
        while(true){
            entry = read.nextLine();
            if (entry.equalsIgnoreCase("quit")) break;
            else if(!entry.equalsIgnoreCase("m") && !entry.equalsIgnoreCase("s"))
                System.out.println("\nInvalid input! Expecting only 'm' or 's' input! Try again!");
            else break;
        }
        return entry;
    }
    public String returnValidDateSalaried(){
        String entry;
        boolean exist = false;
        String[] days = new String[]{"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
        while(true){
            entry = read.nextLine();
            for(int i=0;i<days.length;i++){
                if(entry.equals(days[i])) {
                    exist = true;
                    break;
                }
                else if(entry.equalsIgnoreCase("quit"))
                    exist = true;
            }
            if(exist)
                break;
            else
                System.out.print("\nInvalid input! Expecting day as '00' - '25' or '00' for last business day! Try again! Entry: ");
        }
        return entry;
    }
    public String returnValidWeeks(){
        String entry;
        while(true){
            entry = read.nextLine();
            if (entry.equalsIgnoreCase("quit")) break;
            else if(!entry.equalsIgnoreCase("01") && !entry.equalsIgnoreCase("02"))
                System.out.print("\nInvalid input! Expecting only '01' or '02' weeks! Try again!\nEntry: ");
            else break;
        }
        return entry;
    }
    public String returnValidDayWeek(){
        String entry;
        boolean exist = false;
        String[] days = new String[]{"0","1","2","3","4","5","6"};
        while(true){
            entry = read.nextLine();
            for(int i=0;i<days.length;i++){
                if(entry.equals(days[i])){
                    exist = true;
                    break;
                }
                else if(entry.equalsIgnoreCase("quit"))
                    exist = true;
            }
            if(exist)
                break;
            else
                System.out.print("\nInvalid input! Expecting '0' to Monday, '1' to Tuesday,... '6' ! Try again!\n Entry: ");
        }
        return entry;
    }

    public int returnValidOption(String opt, ArrayList<Integer> quantity){
        boolean error = true;
        int option = -1;
        boolean exist = false;
        while (error) {
            try {
                option = Integer.parseInt(opt);
                error = false;
            }
            catch (Exception e) {
                System.out.println("INVALID INPUT! Expected integer number! Try again!");
                error = true;
            }
            for(int i=0;i< quantity.size();i++){
                if(option == quantity.get(i)){
                    error = false;
                    exist = true;
                    break;
                }
                else if(i == quantity.size()-1) {
                    option = -1;
                    error = false;
                    exist = true;
                }
            }
            if(exist)
                break;

        }
        return option;
    }

}
