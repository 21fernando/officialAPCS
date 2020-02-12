package InheritanceHomework;

import java.util.ArrayList;

public class Bank
{
    private ArrayList<Account> accounts;

    /** all accounts in this bank accounts has no null entries
     *  postcondition: for each account in this bank, the monthly interest
     *  due has been deposited into that account */
    public void postMonthlyInterest()
    {
// to be implemented in this part
        for(Account a: accounts){
            a.deposit(a.monthlyInterest());
        }
    }
// ... constructors and other methods not shown
}

