public class Transaction {
  private double money;
  private Date transactionDate;

  public Transaction(double initialMoney, Date actualDate) {
    this.money = initialMoney;
    this.transactionDate = actualDate;
  }
  public boolean withdraw(double moneyToWithdraw) {
    if(moneyToWithdraw < 0)
      return false;
    if(this.money < moneyToWithdraw)
      return false;

    this.money -= moneyToWithdraw;
    return true;
  }
  public double actualMoney() {
    return money;
  }
  public Date dateOfTransaction() {
    return transactionDate;
  }
  public String toString() {
    return "Total: " + money + " Date: " + transactionDate;
  }
}