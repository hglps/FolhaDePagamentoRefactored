package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Commissioned;
import companypackage.Employee;
import companypackage.Hourly;
import companypackage.Salaried;
import exceptions.ExceptionHandling;
import states.States;
import strategy.UnionMember;
import visitor.CalculateSalaryVisitor;

import java.util.ArrayList;

public class Payroll implements ChoiceOperation {
    private ExceptionHandling exceptionHandling = new ExceptionHandling();

    @Override
    public void execute(ArrayList<Employee> employees, MyCalendar date, States states) {
        screenWarningPayroll();
        String enter = exceptionHandling.read.nextLine();
        if (enter.equalsIgnoreCase("yes")){
            payroll(employees,date);
            if(date.setNewDate())
                resetPaidUnion(employees);
        }
        else
            System.out.println("Back to main screen");
    }

    private void payroll(ArrayList<Employee> employees, MyCalendar date) {
        CalculateSalaryVisitor salaryVisitor = new CalculateSalaryVisitor();
        for(Employee user : employees){
            if(user instanceof Hourly)
                ((Hourly)user).accept(salaryVisitor, date);
            else if(user instanceof Commissioned)
                ((Commissioned)user).accept(salaryVisitor,date);
            else if(user instanceof Salaried)
                ((Salaried)user).accept(salaryVisitor,date);
        }
    }

    private void resetPaidUnion(ArrayList<Employee> employees) {
        for(Employee user: employees){
            if(user.getUnion().checkUnion()){
                ((UnionMember)user.getUnion()).setPaidUnionFee(false);
            }
        }
    }



    private void screenWarningPayroll(){
        System.out.println("Warning!! Be aware that a day is passed after the payroll execution!");
        System.out.println("If you want to proceed, enter 'yes' or anything else to go back to main screen");
    }
}
