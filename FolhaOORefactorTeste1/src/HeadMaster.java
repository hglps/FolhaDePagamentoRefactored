import java.util.ArrayList;
import java.util.Scanner;

public class HeadMaster {

    public Scanner read = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public void startCode(){
        //AddVisitor addMethod = new AddVisitor();
        ChoiceFactory choiceFactory = new ChoiceFactory();
        //TODO criar uma classe factory com key do tipo de funcionario e retornar um new Tipo(), colocar esse getTipo do map no employees.add( factory.getTipo(operator)) aaaaaaaaaaaaaaaaa
        int n = 4;

        while(n > 0) {
            System.out.println("enter method:\n'add' to ADD  employee\n'show info' to show INFO of employees");
            String choice = read.nextLine();
            choiceFactory.getOperation(choice).execute(employees);
            System.out.println("terminou de sair do execute() da main do choice!!!\n");
            n--;
        }
        System.out.println("size of arrayList = "+getEmployees().size());

        for(Employee user : employees){
            System.out.println(user);
        }

    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
