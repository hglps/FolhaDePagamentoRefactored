public class Salaried extends Employee implements Visitable {

    private double baseSalary;

    public Salaried(String name, String cpf, double baseSalary) {
        super(name, cpf);
        this.baseSalary = baseSalary;
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
}
