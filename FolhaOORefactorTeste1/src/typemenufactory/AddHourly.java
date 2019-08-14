package typemenufactory;

import companypackage.Hourly;

public class AddHourly implements TypeOperation {
    @Override
    public Hourly returnNewEmployee() {
        return new Hourly();
    }
}
