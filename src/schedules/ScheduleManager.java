package schedules;

import companypackage.Employee;
import exceptions.ExceptionHandling;

import java.util.ArrayList;

public class ScheduleManager {
    private ArrayList<Schedules> schedules = new ArrayList<Schedules>();
    private ExceptionHandling exceptionHandling = new ExceptionHandling();

    public boolean setPayday(ArrayList<Employee> employees){
        System.out.println("Insert ID:");
        String id = exceptionHandling.read.nextLine();
        int index = getIndex(id, employees);
        if(index == -1) {
            System.out.println("Employee not found!");
            return false;
        }
        else{
            ArrayList<Integer> quantity = new ArrayList<>();
            String type = employees.get(index).getTypePayment().toLowerCase();

            for(int i=0; i< schedules.size(); i++){
                if(type.equalsIgnoreCase("h") && schedules.get(i).getSchedule().substring(0,4).equalsIgnoreCase("s 01")){
                    System.out.println(i + " - " + schedules.get(i).getSchedule());
                    quantity.add(i);
                }
                else if(type.equalsIgnoreCase("c") && schedules.get(i).getSchedule().substring(0,4).equals("s 02")){
                    System.out.println(i + " - " + schedules.get(i).getSchedule());
                    quantity.add(i);
                }
                else if(type.equalsIgnoreCase("s") && schedules.get(i).getSchedule().substring(0,1).equals("m")){
                    System.out.println(i + " - " + schedules.get(i).getSchedule());
                    quantity.add(i);
                }
            }

            System.out.println("If you want to change your payment schedule, select one valid shown number\nElse, insert 'over' to go back to main screen");
            String opt = exceptionHandling.read.nextLine();
            if(opt.equalsIgnoreCase("over")){
                System.out.println("Back to main screen.\n-----------------------------------------------------------------------");
                return false;
            }
            else{
                int option = exceptionHandling.returnValidOption(opt, quantity);
                Employee currEmployee = employees.get(index);

                if(option != -1){
                    currEmployee.setPayday(schedules.get(option).getSchedule());
                    System.out.println("New schedule -"+ currEmployee.getPayday()+"- registered to employee " + currEmployee.getName());
                    return true;
                }
                else{
                    System.out.println("Changes not made! Payday of " + currEmployee.getName() + " did not change!");
                    return false;
                }
            }
        }

    }

    public void createSchedules(ArrayList<Employee> employees){
        String schedule = "";
        String entry = "";
        while (true) {
            schedule = "";
            entry="";

            System.out.println("Insert 'quit' to go back to main screen");
            System.out.println("....Adding new payment schedules....\n");
            System.out.print("Insert type:\nm - monthly  /  s - weekly\n->");
            entry = exceptionHandling.returnValidType().toLowerCase();
            if(entry.equalsIgnoreCase("quit"))
                break;

            schedule += entry;
            entry="";

            if (schedule.equals("m")) {
                System.out.print("Insert a number for the day of payment:\nNumber format: '01' - '25' or '00' to last business day\nEntry: ");
                entry = exceptionHandling.returnValidDateSalaried().toLowerCase();

                if (entry.equalsIgnoreCase("quit")) break;
                schedule += " " + entry;
                entry="";
            }

            else if (schedule.equals("s")) {
                System.out.println("Insert number of worked weeks required: 01 or 02");
                entry = exceptionHandling.returnValidWeeks().toLowerCase();

                if (entry.equalsIgnoreCase("quit")) break;
                schedule += " " + entry;
                entry="";

                System.out.println("Insert the day of week:\n" +
                        "0 - Monday\n" +
                        "1 - Tuesday\n" +
                        "2 - Wednesday\n" +
                        "3 - Thursday\n" +
                        "4 - Friday\n" +
                        "5 - Saturday\n" +
                        "6 - Sunday");
                entry = exceptionHandling.returnValidDayWeek().toLowerCase();
                if (entry.equalsIgnoreCase("quit")) break;
                schedule += " " + entry;
                entry="";
            }
            Schedules scheduleFinal = new Schedules(schedule);

            this.schedules.add(scheduleFinal);
            System.out.println("Schedule: -" + schedule + "- set!");
        }

    }

    private int getIndex(String id, ArrayList<Employee> employees){
        for(int i=0; i < employees.size() ; i++){
            if (employees.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
