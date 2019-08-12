import java.util.Scanner;

public class Employee {
    public Scanner read = new Scanner(System.in);
    private String name;
    private String address;
    private String wayPayment;
//    private String payday;
//    private int hours;
//    private double salary;
//    private UnionContract union = new UnionContract();
//    private int daysWorked = 0;
//    private int weeksWorked;

    public Employee() {
        System.out.println("entrou no constructor da Employee!");
        System.out.println("Insert name:");
        String name = read.nextLine();
        System.out.println("Insert address: ");
        String address = read.nextLine();
        System.out.println("insert way of payment: ");
        String wayPayment = read.nextLine();
        this.name = name;
        this.address = address;
        this.wayPayment = wayPayment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWayPayment() {
        return wayPayment;
    }

    public void setWayPayment(String wayPayment) {
        this.wayPayment = wayPayment;
    }
}
