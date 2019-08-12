import java.util.Scanner;

public class AddVisitor implements  Visitor {
    Scanner read = new Scanner(System.in);

    @Override
    public Employee visit(Hourly hourlyEmployee) {
        System.out.println("Insert name:");
        String name = read.nextLine();
        System.out.println("Insert cpf:");
        String cpf = read.nextLine();
        System.out.println("Insert hourly rate:");
        double hourlyRate = read.nextDouble();

        return new Hourly();


    }

    @Override
    public Employee visit(Salaried salariedEmployee) {
        System.out.println("Insert name:");
        String name = read.nextLine();
        System.out.println("Insert cpf:");
        String cpf = read.nextLine();
        System.out.println("Insert base salary:");
        double baseSalary = read.nextDouble();

        return new Salaried();
    }
}
