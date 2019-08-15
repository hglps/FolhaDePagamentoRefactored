package companypackage;

import calendar.MyCalendar;
import strategy.UnionContract;
import strategy.UnionMember;
import visitor.Visitable;
import visitor.Visitor;

public class Salaried extends Employee implements Visitable{

    private double baseSalary;

    public Salaried(String typePayment) {
        super(typePayment);
        constructSalaried();
    }

    public Salaried(String name, String address, String typePayment, String wayPayment, UnionContract union){
        super(name,address,typePayment,wayPayment,union);
        constructSalaried();
    }

    public Salaried(String name, String address, String typePayment, String wayPayment, UnionContract union, double baseSalary){
        super(name,address,typePayment,wayPayment,union);
        setBaseSalary(baseSalary);
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
        if(getUnion().checkUnion()) {
            union = "--Union Member--" + "\nUnion Fee: R$" + ((UnionMember)getUnion()).getUnionFee() + " , Service Fee(until now): R$" + ((UnionMember)getUnion()).getServiceFee() + "\nUnion ID: " + ((UnionMember)getUnion()).getUnionId()+ "\n\n";
        }
        else
            union = "--Not union member--\n\n";
        return str + union;
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
