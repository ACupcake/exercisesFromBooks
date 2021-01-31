public class Main {
  public static void main(String[] args) {
    FixedCapacityStack <String> s;
    s = new FixedCapacityStack <String> (100);
    boolean isValid = true;
    String out;

    while (!StdIn.isEmpty())
    {
        String item = StdIn.readString();
        switch(item) {
            case "[":
                s.push(item);
                break;
            case "(":
                s.push(item);
                break;
            case "{":
                s.push(item);
                break;
            case "]":
                if(!s.isEmpty() && !s.pop().equals("["))
                    isValid = false;
                break;
            case ")":
                if(!s.isEmpty() && !s.pop().equals("("))
                    isValid = false;
                break;
            case "}":
                if(!s.isEmpty() && !s.pop().equals("{"))
                    isValid = false;
                break;
        }
    }

    if((s.size() == 0) && isValid)
        StdOut.println("true");
    else
        StdOut.println("false");
  }
}