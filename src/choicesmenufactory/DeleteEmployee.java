package choicesmenufactory;


import calendar.MyCalendar;
import companypackage.Employee;
import main.HeadMaster;
import states.States;

import java.util.ArrayList;

public class DeleteEmployee extends HeadMaster implements ChoiceOperation {
    @Override
    public void execute(ArrayList<Employee> arrayList, MyCalendar date, States states) {
        deleteEmployee(arrayList, states);
    }

    private void deleteEmployee(ArrayList<Employee> employees, States states){
        System.out.println("Insert ID: (text entry :: Format - '190021xx@abc' )");
        String id = read.nextLine();
        int index = getIndex(id, employees);
        if(index != -1){
            String name = employees.get(index).getName();
            employees.remove(index);
            System.out.println("Employee " + name + " removed :)");
            states.saveState(employees);
        }
        else
            System.out.println("Employee with ID : "+ id +" not found!");

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
