public class ListPasseggeri{
    private int size;
    private int max;
    private NodePasseggero start;

    public ListPasseggeri(){
        size = 0;
        start = null;
    }
    public ListPasseggeri(String[] list){
        for(String node:list){
            addNode(new NodePasseggero(node));
        }
    }

    public void addFirstNode(NodePasseggero n){
        if(max != size){
            n.setNext(this.start);
            this.start = n;
            size++;
        }else System.out.println("l'aereo è pieno");
    }

    public void addNode(NodePasseggero n){
        if(max != size){
            if (start != null) addNextNode(start, n);
            else start = n;
            size++;
        }else System.out.println("l'aereo è pieno");
    }

    protected void addNextNode(NodePasseggero current, NodePasseggero n){
        if(current.getNext() != null) addNextNode(current.getNext(), n);
        else current.setNext(n);
    }


    public void removeNode(NodePasseggero n){
        try {
            if (start.equals(n)) start = start.getNext();
            else removeNextNode(start, n);
            size--;
        }catch (NullPointerException e){
            System.out.println("non ho potuto rimuovere questo nodo perché non lo ho trovato");
        }
    }

    protected void removeNextNode(NodePasseggero current, NodePasseggero n){
        if(current.getNext().equals(n)) current.setNext(current.getNext().getNext());
        else removeNextNode(current.getNext(), n);
    }

    public String toString(){
        String info = "";
        info += "\t\t\tsize:\t" + size + "\n";
        info += "\t\t\t\tlista iniziata\n";
        if(start != null) info += "\t\t\t\tstart:\n" + start + "\n";
        else info += "\t\t\t\tlista terminata\n";
        return info;
    }

    public void printList(){
        System.out.println(this);
    }

    public String toFile(){
        return start.toFile();
    }

    public void order(){
        int i=0;
        while (!ordered(start)) {
            if(this.start.compareTo(this.start.getNext()) > 0){
                NodePasseggero start = this.start;
                this.start = start.getNext();
                start.setNext(this.start.getNext());
                this.start.setNext(start);
            }
            i++;
            orderNext(start);
        }
    }

    public void orderNext(NodePasseggero n){
        if(n.getNext() != null && n.getNext().getNext() != null) {
            if (n.getNext().compareTo(n.getNext().getNext()) > 0) {
                NodePasseggero start = n.getNext();
                n.setNext(start.getNext());
                start.setNext(n.getNext().getNext());
                n.getNext().setNext(start);
                orderNext(n);
            }else orderNext(n.getNext());
        }
    }

    public boolean ordered(NodePasseggero n){
        if(n.getNext() != null){
            if(!(n.compareTo(n.getNext()) > 0)) return ordered(n.getNext());
            else return false;
        }else return true;
    }
}
