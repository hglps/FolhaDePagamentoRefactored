package strategy;

public class NotUnionMember implements UnionContract{
    private double unionFee;
    private double serviceFee;
    private String unionId;
    private boolean paidUnionFee;

    @Override
    public boolean checkUnion() {
        return false;
    }

    public double getUnionFee() {
        return 0;
    }

    public double getServiceFee() {
        return 0;
    }

    public String getUnionId() {
        return "";
    }

    public boolean isPaidUnionFee() {
        return true;
    }

    public void setUnionFee(double unionFee) {
        this.unionFee = 0;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = 0;
    }

    public void setUnionId(String unionId) {
        this.unionId = "";
    }

    public void setPaidUnionFee(boolean paidUnionFee) {
        this.paidUnionFee = true;
    }
}
