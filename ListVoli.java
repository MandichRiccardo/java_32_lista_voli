public class ListVoli{
    private int size;
    private NodeVolo start;

    public ListVoli(){
        size = 0;
        start = null;
    }
    public ListVoli(String[] list){
        for(String node:list){
            addNode(new NodeVolo(node));
        }
    }

    public void addFirstNode(NodeVolo n){
        n.setNext(this.start);
        this.start = n;
    }

    public void addNode(NodeVolo n){
        if (start != null) addNextNode(start, n);
        else start = n;
        size++;
    }

    private void addNextNode(NodeVolo current, NodeVolo n){
        if(current.getNext() != null) addNextNode(current.getNext(), n);
        else current.setNext(n);
    }


    public void removeNode(NodeVolo n){
        try {
            if (start.equals(n)) start = start.getNext();
            else removeNextNode(start, n);
            size--;
        }catch (NullPointerException e){
            System.out.println("non ho potuto rimuovere questo nodo perché non lo ho trovato");
        }
    }

    private void removeNextNode(NodeVolo current, NodeVolo n){
        if(current.getNext().equals(n)) current.setNext(current.getNext().getNext());
        else removeNextNode(current.getNext(), n);
    }

    public String toString(){
        String info = "";
        info += "size:\t" + size + "\n";
        info += "\tlista iniziata\n";
        if(start != null) info += "\tstart:\n" + start + "\n";
        else info += "\tlista terminata\n";
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
                NodeVolo start = this.start;
                this.start = start.getNext();
                start.setNext(this.start.getNext());
                this.start.setNext(start);
            }
            i++;
            orderNext(start);
        }
    }

    private void orderNext(NodeVolo n){
        if(n.getNext() != null && n.getNext().getNext() != null) {
            if (n.getNext().compareTo(n.getNext().getNext()) > 0) {
                NodeVolo start = n.getNext();
                n.setNext(start.getNext());
                start.setNext(n.getNext().getNext());
                n.getNext().setNext(start);
                orderNext(n);
            }else orderNext(n.getNext());
        }
    }

    private boolean ordered(NodeVolo n){
        if(n.getNext() != null){
            if(!(n.compareTo(n.getNext()) > 0)) return ordered(n.getNext());
            else return false;
        }else return true;
    }
}