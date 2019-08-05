package choicesmenu;
import companypackage.Commissioned;
import companypackage.Company;
import companypackage.Hourly;
import companypackage.Salaried;
import exceptions.ExceptionHandling;


public class AddEmployee extends Company implements Operation{
    ExceptionHandling exceptions = new ExceptionHandling();
    @Override
    public void execute() {
        System.out.println("ADDING A NEW EMPLOYEE\n");
        System.out.print("Insert the type of payment:\n" +
                "Entry format:\nh - hourly / s - salaried / c - commissioned\nType of payment: ");
        String typePayment = exceptions.returnValidTypePayment();


        //addEmployee();
    }

    private void addEmployee2(){


    }
    public void addEmployee() {
        //read.nextLine();
        String name, address, typePayment , wayPayment;
        boolean unionMember;
        double baseSalary= -1, hourlyRate= -1, unionFee = -1, commissionRate= -1;

        System.out.println("/////////////////////////////////////////////////////////////////");
        System.out.print("Insert your name (text entry): ");
        name = read.nextLine();
        System.out.print("Insert your address (text entry): "); address = read.nextLine();
        System.out.print("Insert the type of payment:\n" +
                "Entry format:\nh - hourly / s - salaried / c - commissioned\nType of payment: ");
        typePayment = returnValidTypePayment();

        if(typePayment.equals("s") || typePayment.equals("c")){
            System.out.print("Insert base salary:\nNumber format: 9999,99\nR$ ");
            baseSalary = returnValidDouble();

            if(typePayment.equals("c")) {
                System.out.print("Insert commission rate:\nNumber format: 0,01 to 0,99\nRate: ");
                commissionRate = returnValidRate();
            }
            read.nextLine();
        }
        else if(typePayment.equals("h")){
            System.out.print("Insert the hourly rate for this employee:\nNumber format: 9999,99\nR$");
            hourlyRate = returnValidDouble();
            read.nextLine();
        }

        System.out.println("Insert how you want to get paid:\n" +
                "Entry format:\n'check via mail' - check via mail  /  'check in hands' - check via hands  /  'deposit' - pay via deposit");
        wayPayment = returnValidWayPayment();

        System.out.println("Are you part of any union?\n" +
                "Entry format:\n 'yes' or 'no'\nAnswer:");
        unionMember = returnValidPartOfUnion();

        if(unionMember){
            System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
            unionFee = returnValidDouble();
        }

        Employee newEmployee = null;
        int index;
        String id;

        if(typePayment.equalsIgnoreCase("h"))
            newEmployee = new Hourly(name,address,typePayment.toLowerCase(), wayPayment.toLowerCase(), hourlyRate );

        else if(typePayment.equalsIgnoreCase("s"))
            newEmployee = new Salaried(name, address, typePayment.toLowerCase(), wayPayment.toLowerCase(), baseSalary);

        else if(typePayment.equalsIgnoreCase("c"))
            newEmployee = new Commissioned(name,address, typePayment.toLowerCase(), wayPayment.toLowerCase(), baseSalary, commissionRate);

        employees.add(newEmployee);
        index = employees.indexOf(newEmployee);
        id = getId(index);
        employees.get(index).setId(id);
        employees.get(index).startPayday();
        setUnionCondition(unionFee,unionMember, index);

        screenWelcomeNewEmployee(index);

        saveState();

    }

    public void addEmployee(Hourly employee){

    }

    public void addEmployee(Salaried employee){

    }

    public void addEmployee(Commissioned employee){

    }


}
