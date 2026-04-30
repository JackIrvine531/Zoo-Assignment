public class Visitor {
    private double balance;

    //constructor
    public Visitor(double balance) {
        this.balance =balance;
    }

    //get balance
    public double getBalance() {
        return balance;
    }

    // add money to balance
    public void deposit(double amount) {
        balance += amount;
    }

    //if enough money withdraw cost from balance
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }else {
            return false;
        }
    }

}//class


