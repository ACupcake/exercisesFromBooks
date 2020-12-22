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
  public boolean equals(Transaction transaction) {
    if (this == transaction) return true;
    if (transaction == null) return false;
    if (this.getClass() != transaction.getClass()) return false;
    Transaction that = (Transaction) transaction;
    if (this.money != that.money) return false;
    if (this.transactionDate != that.transactionDate) return false;
    return true;
  }
}