interface Visitor {

    Employee visit(Hourly hourlyEmployee);
    Employee visit(Salaried salariedEmployee);
}
