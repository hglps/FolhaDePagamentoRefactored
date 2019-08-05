import java.util.ArrayList;
import java.util.Scanner;

public class HeadMaster {

    public Scanner read = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();

    public void startCode(){
        AddVisitor addMethod = new AddVisitor();
//        employees.add()
        //TODO criar uma classe factory com key do tipo de funcionario e retornar um new Tipo(), colocar esse getTipo do map no employees.add( factory.getTipo(operator)) aaaaaaaaaaaaaaaaa


    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
