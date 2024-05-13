public class NodePasseggero {
    private Passeggero value;
    private NodePasseggero next;

    public NodePasseggero(Passeggero value) {
        this.value = value;
    }

    public NodePasseggero(){
        value = new Passeggero();
    }

    public NodePasseggero(String node){
        value = new Passeggero(node);
    }

    public NodePasseggero getNext(){
        return next;
    }

    public void setNext(NodePasseggero next){
        this.next = next;
    }

    public int compareTo(NodePasseggero node){
        return value.compareTo(node.value);
    }

    public String toFile(){
        try{
            return value + "\n" + next.toFile();
        }catch (NullPointerException e){
            return value + "\n";
        }
    }
}