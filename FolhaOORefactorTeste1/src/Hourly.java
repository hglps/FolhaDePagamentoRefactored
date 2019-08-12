public class Hourly extends Employee implements Visitable {

    private double hourlyRate;

    public Hourly() {
        super();
        System.out.println("Insert hourly rate:");
        double hourlyRate = read.nextDouble();
        this.hourlyRate = hourlyRate;
        read.nextLine();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        String toString = "Name: " + getName() + "\nAddress: " + getAddress()+ "\nWay of payment: " + getWayPayment() + "\nBase salary: " + getHourlyRate() + "\n";
        return toString;
    }
}
