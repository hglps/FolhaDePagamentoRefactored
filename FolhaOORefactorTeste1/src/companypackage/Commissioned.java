package companypackage;

import calendar.MyCalendar;
import visitor.Visitable;
import visitor.Visitor;

public class Commissioned extends Salaried implements Visitable{
    private double commission;
    private double commissionRate;

    public Commissioned(){
        super();
        constructCommissioned();
    }

    public Commissioned(int change){
        this.commission = change;
    }

    private void constructCommissioned(){
        System.out.print("Insert commission rate:\nNumber format: 0,01 to 0,99\nRate: ");
        double commissionRate = exception.returnValidRate();
        read.nextLine();
        setCommissionRate(commissionRate);
        super.setPayday("s 02 4");
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void addCommission(double commission){
        this.commission += commission;
    }

    @Override
    public String toString() {
        return this.constructToString();
    }

    private String constructToString(){
        String[] week = new String[]{"Mondays", "Tuesdays", "Wednesdays", "Thursdays", "Fridays", "Saturdays", "Sundays"};
        String str, union,payday;
        str = "Commissioned employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: " + getBaseSalary() + "\nCommission Rate: " + getCommissionRate()*100 + "%" +"\nDays worked: "+ getDaysWorked() +" days\nCommission : R$" + getCommission() +"\n";
        payday = "Bi-weekly paid at ";
        payday += week [ Integer.parseInt( getPayday().substring(5,6))] + "\n";
        str += payday;
//        if(getPartUnion()) {
//            union = "--Union Member--" + "\nUnion Fee: R$" + getUnion().getUnionFee() + " , Service Fee(until now): R$" + getUnion().getServiceFee() + "\nUnion ID: " + getUnion().getUnionId()+ "\n\n";
//        }
//        else
//            union = "--Not union member--\n\n";
//        return str + union;
        return str;
    }

    @Override
    public boolean isPayday(int dayOfWeek){
        return getPayday().substring(5,6).equalsIgnoreCase(Integer.toString(dayOfWeek));
    }

    @Override
    public void accept(Visitor visitor, MyCalendar date) {
        visitor.visit(this,date);
    }


}
