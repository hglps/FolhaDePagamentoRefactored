package visitor;

import calendar.MyCalendar;
import companypackage.Commissioned;
import companypackage.Hourly;
import companypackage.Salaried;
import strategy.UnionMember;

public class CalculateSalaryVisitor implements Visitor {

    @Override
    public void visit(Hourly hourlyEmployee, MyCalendar date) {
        if(hourlyEmployee.isPayday(date.getDayWeek())){
            if(hourlyEmployee.getDaysWorked() >= 5){
                hourlyEmployee.setWeeksWorked(0);
                calculateSalary(hourlyEmployee, date);
            }
        }
    }

    private void calculateSalary(Hourly hourlyEmployee, MyCalendar date) {
        double salary = 0;
        salary = hourlyEmployee.getHours()*hourlyEmployee.getHourlyRate() + 1.5*hourlyEmployee.getExtraHours()*hourlyEmployee.getHourlyRate();/////////////////////////

        if(hourlyEmployee.getUnion().checkUnion()){
            UnionMember unionStatus = (UnionMember)hourlyEmployee.getUnion();
            salary -= unionStatus.getServiceFee();
            if(!unionStatus.isPaidUnionFee()){
                salary -= unionStatus.getUnionFee();
                unionStatus.setPaidUnionFee(true);
            }
            unionStatus.setServiceFee(0);
        }
        hourlyEmployee.setSalary(salary);
        hourlyEmployee.setHours(0);
        hourlyEmployee.setExtraHours(0);
        System.out.println("Hourly employee " + hourlyEmployee.getName() + " - Salary: R$" + hourlyEmployee.getSalary());
        hourlyEmployee.setSalary(0);
        hourlyEmployee.setDaysWorked(0);
        hourlyEmployee.setHoursWorked(0);
    }

    @Override
    public void visit(Commissioned commEmployee, MyCalendar date) {
        if(commEmployee.isPayday(date.getDayWeek())){
            if(commEmployee.getDaysWorked() >= 10)
                calculateSalary(commEmployee, date);
        }
    }

    private void calculateSalary(Commissioned commEmployee, MyCalendar date){
        commEmployee.setWeeksWorked(0);
        double salary = 0;
        salary = commEmployee.getCommission() + commEmployee.getBaseSalary();

        if(commEmployee.getUnion().checkUnion()){
            UnionMember unionStatus = (UnionMember) commEmployee.getUnion();
            salary -= unionStatus.getServiceFee();
            unionStatus.setServiceFee(0);
            if(!unionStatus.isPaidUnionFee()){
                salary -= unionStatus.getUnionFee();
                unionStatus.setPaidUnionFee(true);
            }
        }
        commEmployee.setSalary(salary);
        System.out.println("Commissioned employee "+ commEmployee.getName()+ " - Salary: R$ " + commEmployee.getSalary());

        commEmployee.setSalary(0);
        commEmployee.setCommission(0);
        commEmployee.setDaysWorked(0);
        commEmployee.setHoursWorked(0);

    }

    @Override
    public void visit(Salaried salEmployee, MyCalendar date) {
        if(salEmployee.getDaysWorked() >= 20){
            if((salEmployee.getPayday().substring(2,4).equalsIgnoreCase("00") && (date.getLastWorkDay() == date.getCounterDate() )) || (!salEmployee.getPayday().substring(2,4).equalsIgnoreCase("00") && date.getCounterDate() == Integer.parseInt(salEmployee.getPayday().substring(2,4)) )){
                calculateSalary(salEmployee, date, 1);
            }

        }
    }

    private void calculateSalary(Salaried salEmployee, MyCalendar date, int flag ){
        salEmployee.setWeeksWorked(0);

        double salary = 0;
        salary = salEmployee.getBaseSalary();
        if(salEmployee.getUnion().checkUnion()){
            UnionMember unionStatus = (UnionMember) salEmployee.getUnion();
            salary -= unionStatus.getServiceFee();
            unionStatus.setServiceFee(0);
            if(!unionStatus.isPaidUnionFee()){
                unionStatus.setPaidUnionFee(true);
                salary -= unionStatus.getUnionFee();
            }
        }
        salEmployee.setSalary(salary);
        System.out.println("Salaried employee "+ salEmployee.getName()+ " - Salary: R$ " + salEmployee.getSalary());
        salEmployee.setSalary(0);
        salEmployee.setDaysWorked(0);
        salEmployee.setHoursWorked(0);

    }
}
