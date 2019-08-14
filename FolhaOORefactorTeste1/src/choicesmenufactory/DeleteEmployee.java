package choicesmenufactory;


import calendar.MyCalendar;
import companypackage.Employee;
import main.HeadMaster;

import java.util.ArrayList;

public class DeleteEmployee extends HeadMaster implements ChoiceOperation {
    @Override
    public void execute(ArrayList<Employee> arrayList, MyCalendar date) {
        deleteEmployee(arrayList);
    }

    private void deleteEmployee(ArrayList<Employee> employees){
        System.out.println("Insert ID: (text entry :: Format - '190021xx@abc' )");
        String id = read.nextLine();
        int index = getIndex(id, employees);
        if(index != -1){
            String name = employees.get(index).getName();
            employees.remove(index);
            System.out.println("Employee " + name + " removed :)");
            //saveState();
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
