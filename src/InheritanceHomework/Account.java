package InheritanceHomework;

public abstract class Account
{
    private int idNumber;   // identity number for this account
    private double balance; // current balance for this account

    /** precondition: startBal >= 0.0
     *  postcondition: An Account with identity number idNum and current
     *  balance of startBal has been created*/
    public Account(int idNum, double startBal)
    { this.idNumber=idNum; this.balance= startBal; }

    /** @return the identity number for this account */
    public int idNumber()
    { return this.idNumber;}

    /** @return the current balance for this account */
    public double currentBalance()
    { return this.balance;}

    /** precondition: amount >= 0.0
     *  postcondition: the current balance of this account has been
     *  increased by amount */
    public void deposit(double amount)
    { this.balance+= amount; }

    /** precondition: 0.0 <= amount <= balance
     *  postcondition: the current balance of this account has been
     *  decreased by amount and return true; return false if amount >
     *  balance */
    public boolean decreaseBalance(double amt) {
        if(amt>balance) return false;
        this.balance -= amt;
        return true;
    }

    /** @return the monthly interest due for this account */
    public abstract double monthlyInterest();
} //end of class Account

