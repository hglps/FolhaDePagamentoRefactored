package strategy;

public class UnionMember implements UnionContract {
    private double unionFee;
    private double serviceFee;
    private String unionId;
    private boolean paidUnionFee;


    public UnionMember(double unionFee, boolean paidUnionFee) {
        this.unionFee = unionFee;
        this.paidUnionFee = paidUnionFee;
    }

    public double getUnionFee() {
        return unionFee;
    }

    public void setUnionFee(double unionFee) {
        this.unionFee = unionFee;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public void addServiceFee( double serviceFee){
        this.serviceFee += serviceFee;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public boolean isPaidUnionFee() {
        return paidUnionFee;
    }

    public void setPaidUnionFee(boolean paidUnionFee) {
        this.paidUnionFee = paidUnionFee;
    }


    @Override
    public boolean checkUnion() {
        return true;
    }
}
