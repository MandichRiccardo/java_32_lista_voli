public class Volo {
    private int numeroVolo;
    private String partenza;
    private String destinazione;
    private ListPasseggeri passeggeri;

    public Volo(){
        System.out.println("inserisci il numero di questo volo");
        numeroVolo = Passeggero.getInt();
        System.out.println("inserisci la partenza");
        partenza = Passeggero.getString();
        System.out.println("inserisci la destinazione");
        destinazione = Passeggero.getString();
        System.out.println("ora creiamo la lista di passeggeri");
        passeggeri = new ListPasseggeri();
    }

    public Volo(String node){
        String[] row = node.split(",");
        numeroVolo = Integer.parseInt(row[0]);
        partenza = row[1];
        destinazione = row[2];
        String[] passeggeri = new String[row.length-3];
        for(int i = 3, j = 0; i < row.length; i++, j++){
            passeggeri[j] = row[i];
        }
        this.passeggeri = new ListPasseggeri(passeggeri);
    }

    public int compareTo(Volo o) {
        return numeroVolo - o.numeroVolo;
    }
}