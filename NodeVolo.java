public class NodeVolo {
    private Volo value;
    private NodeVolo next;

    public NodeVolo(Volo value){
        this.value = value;
    }

    public NodeVolo(){
        this.value = new Volo();
    }

    public NodeVolo(String node){
        this.value = new Volo(node);
    }

    public NodeVolo getNext(){
        return next;
    }

    public void setNext(NodeVolo next){
        this.next = next;
    }

    public int compareTo(NodeVolo node){
        return value.compareTo(node.value);
    }

    public String toFile(){
        try{
            return value + "\n" + next.toFile();
        }catch (NullPointerException e){
            return value + "\n";
        }
    }

    public String toString(){
        String info ="";
        info += "\t\tvalore:\n" + value + "\n";
        try{
            info += "\tsuccessivo:\n" + next.toString();
        }catch (NullPointerException e){
            info += "\tlista terminata\n";
        }
        return info;
    }

    public boolean equals(NodeVolo node){
        return value.equals(node.value);
    }
}