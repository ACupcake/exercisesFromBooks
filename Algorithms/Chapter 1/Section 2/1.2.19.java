public class Main {
	public Date(String date) {
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day   = Integer.parseInt(fields[1]);
		year  = Integer.parseInt(fields[2]);
	}

	public Transaction(String transaction) {
    	String[] fields = date.split(" ");
    	this.money = Double.parseDouble(fields[0]);
    	this.transactionDate = Date(fields[1]);
	}
	
}