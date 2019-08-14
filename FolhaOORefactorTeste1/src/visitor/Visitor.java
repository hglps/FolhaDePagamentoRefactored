package visitor;

import calendar.MyCalendar;
import companypackage.Commissioned;
import companypackage.Hourly;
import companypackage.Salaried;

public interface Visitor {

    void visit(Hourly hourlyEmployee, MyCalendar date);

    void visit(Commissioned commissionedEmployee, MyCalendar date);

    void visit(Salaried salariedEmployee, MyCalendar date);
}
