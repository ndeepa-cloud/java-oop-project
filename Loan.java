
public class Loan {
    private final double principal;
    private final double annualRate;
    private final int years;

    public Loan(double principal, double annualRate, int years) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.years = years;
    }

    public double monthlyPayment() {
        double r = annualRate / 100.0 / 12.0;
        int n = years * 12;
        return (principal * r) / (1 - Math.pow(1 + r, -n));
    }

    public static void main(String[] args) {
        Loan loan = new Loan(10000, 6.0, 3);
        System.out.printf("Monthly payment: $%.2f%n", loan.monthlyPayment());
    }
}
