package strategy;

public class UnionMember implements UnionContract {
    private final int patternId = 19002100;
    private double unionFee;
    private double serviceFee;
    private String unionId;
    private boolean paidUnionFee;


    public UnionMember(double unionFee, boolean paidUnionFee, String name) {
        this.unionFee = unionFee;
        this.paidUnionFee = paidUnionFee;
        this.unionId = constructUnionId(name);
    }

    private String constructUnionId(String name) {
        if(name.length() < 3)
            return (patternId + "#" + name.toLowerCase());
        else
            return (patternId + "#" + name.substring(0,3).toLowerCase());
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
