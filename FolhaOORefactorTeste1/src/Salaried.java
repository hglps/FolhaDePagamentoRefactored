public class Salaried extends Employee implements Visitable {

    private double baseSalary;

    public Salaried() {
        super();
        System.out.println("Insert base salary:");
        double baseSalary = read.nextDouble();
        this.baseSalary = baseSalary;
        read.nextLine();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        String toString = "Name: " + getName() + "\nAddress: " + getAddress()+ "\nWay of payment: " + getWayPayment() + "\nBase salary: " + getBaseSalary() + "\n";
        return toString;
    }
}
