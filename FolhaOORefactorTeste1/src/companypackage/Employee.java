package companypackage;

import exceptions.ExceptionHandling;
import payment.Card;
import strategy.NotUnionMember;
import strategy.UnionContract;
import strategy.UnionMember;

import java.util.Scanner;

public class Employee extends Card {
    public Scanner read = new Scanner(System.in);
    public ExceptionHandling exception = new ExceptionHandling();
    private String name;
    private String address;
    private String wayPayment;
    private String id;
    private String payday;
    private int hours;
    private double salary;
    private UnionContract union;
    private int daysWorked = 0;
    private int weeksWorked=0;

    public Employee() {
        System.out.println("entrou no constructor da companypackage.Employee!");
        constructEmployee();
    }

    private void constructEmployee(){
        System.out.print("Insert your name (text entry): ");
        String name = read.nextLine();
        System.out.print("Insert your address (text entry): ");
        String address = read.nextLine();
        System.out.println("Insert how you want to get paid:\n" +
                "Entry format:\n'check via mail' - check via mail  /  'check in hands' - check via hands  /  'deposit' - pay via deposit");
        String wayPayment = exception.returnValidWayPayment();
        setName(name);
        setAddress(address);
        setWayPayment(wayPayment);

        System.out.println("Are you part of any union?\n" +
                "Entry format:\n 'yes' or 'no'\nAnswer:");
        boolean unionMember = exception.returnValidPartOfUnion();

        if(unionMember){
            System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
            double unionFee = exception.returnValidDouble();

            setUnion(new UnionMember(unionFee, false));
        }
        else{
            setUnion(new NotUnionMember());
        }





    }

    public void addHours(int hours){
        this.hours += hours;
    }

    public UnionContract getUnion() {
        return union;
    }

    public void setUnion(UnionContract union) {
        this.union = union;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWayPayment() {
        return wayPayment;
    }

    public void setWayPayment(String wayPayment) {
        this.wayPayment = wayPayment;
    }

    public String getPayday() {
        return payday;
    }

    public void setPayday(String payday) {
        this.payday = payday;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public int getWeeksWorked() {
        return weeksWorked;
    }

    public void setWeeksWorked(int weeksWorked) {
        this.weeksWorked = weeksWorked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void calculateHours() {
        int hours = getHoursWorked();
        this.hours = hours;
    }

    @Override
    public void addDayWorked() {
        this.daysWorked +=1;
        if(this.daysWorked >= 7)
            this.weeksWorked +=1;
    }
}
