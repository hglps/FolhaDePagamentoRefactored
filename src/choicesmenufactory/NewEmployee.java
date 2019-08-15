package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;
import main.HeadMaster;
import states.States;
import typemenufactory.InvalidType;
import typemenufactory.TypeEmployeeFactory;

import java.util.ArrayList;

public class NewEmployee extends HeadMaster implements ChoiceOperation {
    private final int patternId = 19002100;

    @Override
    public void execute(ArrayList<Employee> arrayList, MyCalendar date, States states) {
        addEmployee(arrayList, states);
    }

    private void addEmployee(ArrayList<Employee> employees, States states){
        System.out.println("Enter type:\ns - salaried\n" +
                "h - hourly\n"+
                "c - commissioned");
        String type = read.nextLine();
        TypeEmployeeFactory factoryType = new TypeEmployeeFactory();
        Employee test = factoryType.getEmployee(type.toLowerCase()).returnNewEmployee(employees, employees.size());
        if(test != null){
            employees.add(test);
            setIdNewEmployee(employees, test);
            System.out.println("Employee added successfully!");
            states.saveState(employees);
        }

    }

    private void setIdNewEmployee(ArrayList<Employee> arrayList, Employee test) {
        int index = arrayList.indexOf(test);
        String id;
        if(arrayList.get(index).getName().length() < 3)
            id= (patternId + index) + "@" + arrayList.get(index).getName();
        else
            id = (patternId + index) + "@" + arrayList.get(index).getName().substring(0,3);
        arrayList.get(index).setId(id);
    }
}
