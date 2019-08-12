import java.util.ArrayList;

public class AddEmployee extends HeadMaster implements ChoiceOperation {

    @Override
    public void execute(ArrayList<Employee> arrayList) {
        System.out.println("entrou na execute da AddEmployee!");
        addEmployee(arrayList);
    }

    private void addEmployee(ArrayList arrayList){
        System.out.println("Enter type:\ns - salaried\nh - hourly");
        String type = read.nextLine();
        TypeEmployeeFactory factoryType = new TypeEmployeeFactory();
        //Employee test = factoryType.getEmployee(type).returnNewEmployee();
        //if(!(test instanceof InvalidChoice)){
            System.out.println("vai ser adicionado!");
            //getEmployees().add(test);
            //getEmployees().add(factoryType.getEmployee(type).returnNewEmployee()); // ************
            arrayList.add(factoryType.getEmployee(type).returnNewEmployee());
        //}
        System.out.println("Employee added successfully!");


    }
}
