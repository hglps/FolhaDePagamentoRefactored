package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;
import main.HeadMaster;
import typemenufactory.InvalidType;
import typemenufactory.TypeEmployeeFactory;

import java.util.ArrayList;

public class NewEmployee extends HeadMaster implements ChoiceOperation {
    private final int patternId = 19002100;

    @Override
    public void execute(ArrayList<Employee> arrayList, MyCalendar date) {
        System.out.println("entrou na execute da choicesmenu.NewEmployee!");
        addEmployee(arrayList);
    }

    private void addEmployee(ArrayList<Employee> arrayList){
        System.out.println("Enter type:\ns - salaried\n" +
                "h - hourly\n"+
                "c - commissioned");
        String type = read.nextLine();
        TypeEmployeeFactory factoryType = new TypeEmployeeFactory();
        Employee test = factoryType.getEmployee(type).returnNewEmployee();
        if(test != null){
            System.out.println("vai ser adicionado!");
            arrayList.add(test);
            setIdNewEmployee(arrayList, test);
            System.out.println("Employee added successfully!");
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
