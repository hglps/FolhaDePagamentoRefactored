package typemenufactory;

import companypackage.Salaried;

public class AddSalaried implements TypeOperation {
    @Override
    public Salaried returnNewEmployee() {
        return new Salaried();
    }
}
