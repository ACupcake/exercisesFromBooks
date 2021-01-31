public class Main{
	public static void main(String[] args) {
		if(Double.parseDouble(args[0]) == Double.parseDouble(args[1]) &&
		   Double.parseDouble(args[1]) == Double.parseDouble(args[2]))
			System.out.print("equal");
		else
			System.out.print("not");
	} 

}