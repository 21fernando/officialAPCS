package InheritanceHomework;

public class SavingsAccount extends Account {
    private double rate;
    public SavingsAccount(int id, double startBal, double rate){
        super(id, startBal);
        this.rate = rate;
    }

    public boolean decreaseBalance(double amt){
        return super.decreaseBalance(amt);
    }

    public double monthlyInterest() {
        return currentBalance() * (1 + rate)/12;
    }

    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(101, 100.00, 1.01);
    }
}


