package InheritanceHomework;

public class SpecialCheckingAccount extends CheckingAccount {

    private double minBal;
    private double interestRate;
    public SpecialCheckingAccount(int id, double startNum, double checkCharge, double minBal, double interestRate){
        super(id, startNum, checkCharge);
        this.minBal = minBal;
        this.interestRate = interestRate;
    }
    public void clearCheck(double amt){
        if(currentBalance()<=minBal){super.clearCheck(amt);}
        else{
            decreaseBalance(amt);
        }
    }

    public double monthlyInterest() {
        if(currentBalance()>minBal){
            return currentBalance()*interestRate/12;
        }
        else{
            return super.monthlyInterest();
        }
    }
}
