public class Hourly extends Employee implements Visitable {

    private double hourlyRate;

    public Hourly(String name, String cpf, double hourlyRate) {
        super(name, cpf);
        this.hourlyRate = hourlyRate;
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
}
