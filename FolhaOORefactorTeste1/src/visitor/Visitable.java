package visitor;

import calendar.MyCalendar;

public interface Visitable {
    void accept(Visitor visitor, MyCalendar date);
}
