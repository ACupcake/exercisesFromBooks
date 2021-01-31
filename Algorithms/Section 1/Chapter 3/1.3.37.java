public class Josephus {
    private Node first;
    
    public class Node {
        int position;
        Node next;
    }

    public void addNode(int item) {
        Node current = first;
        Node node = new Node();
        node.position = item;
        node.next = first;
        
        if(first == null) {
            first = node;
            first.next = first;
            return;
        }

        while(current.next != first)
            current = current.next;
        current.next = node;
    }

    public Node createQueue(int N) {
        for(int i = 0; i < N; i++)
            addNode(i);
        return first;
    }

    /* Remove current node */
    public void eliminate(Node killRun) {
        Node current = killRun;
        if(killRun == null || killRun == killRun.next) {
            killRun = null;
            first = null;
            return;
        }

        while(current.next != killRun)
            current = current.next;
        current.next = killRun.next;
    }

    public int[] getEliminationOrder(int N, int M) {
        int[] orderToKill = new int[N];
        Node killRun = first;

        /* Set first kill */
        for(int i = 0; i < M - 1; i++)
            killRun = killRun.next;

        /* Walk in queue eliminating */
        for(int i = 0; i < N; i++) {
            orderToKill[i] = killRun.position;
            
            eliminate(killRun);
            for(int j = 0; j < M; j++)
                killRun = killRun.next;     
        }
        return orderToKill;
    }

    public static void main(String[] args) {
        Josephus josephusQueue = new Josephus();
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        
        josephusQueue.createQueue(N);

        int[] orderToKill = josephusQueue.getEliminationOrder(N, M);

        for(int i = 0; i < orderToKill.length; i++)
            System.out.print(orderToKill[i] + " ");
    }
}