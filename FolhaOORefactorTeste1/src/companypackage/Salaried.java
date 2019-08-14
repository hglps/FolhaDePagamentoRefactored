package companypackage;

import calendar.MyCalendar;
import visitor.Visitable;
import visitor.Visitor;

public class Salaried extends Employee implements Visitable{

    private double baseSalary;

    public Salaried() {
        super();
        constructSalaried();
    }

    public Salaried(int change){
        this.baseSalary = change;
    }

    private void constructSalaried(){
        System.out.print("Insert base salary:\nNumber format: 9999,99\nR$ ");
        double baseSalary = exception.returnValidDouble();
        read.nextLine();
        setBaseSalary(baseSalary);
        super.setPayday("m 00");
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }


    @Override
    public String toString() {
        return this.constructToString();
    }

    private String constructToString(){
        String str,union,payday;
        payday = "Monthly paid at ";
        if(getPayday().substring(2,4).equalsIgnoreCase("00"))
            payday += "last business day!\n";
        else
            payday += "day " + getPayday().substring(2,4) + "\n";
        str = "Salaried employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: R$" + getBaseSalary() + "\nDays worked: "+ getDaysWorked() +" days\n";
        str += payday;
//        if(getPartUnion()) {
//            union = "--Union Member--" + "\nUnion Fee: R$" + getUnion().getUnionFee() + " , Service Fee(until now): R$" + getUnion().getServiceFee() + "\nUnion ID: " + getUnion().getUnionId()+ "\n\n";
//        }
//        else
//            union = "--Not union member--\n\n";
//        return str + union;
        return str;
    }

    public boolean isPayday(int day){
        String finalDate;
        if(day >= 1 && day <= 9)
            finalDate = "0" + Integer.toString(day);
        else
            finalDate = Integer.toString(day);

        return getPayday().substring(2,4).equalsIgnoreCase(finalDate);
    }


    @Override
    public void accept(Visitor visitor, MyCalendar date) {
        visitor.visit(this, date);
    }
}
