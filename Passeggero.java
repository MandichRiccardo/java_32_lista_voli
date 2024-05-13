public class Passeggero {
    private String nome;
    private String cognome;
    private String dataNascita;
    private String tipoDocumento;
    private int numeroDocumento;

    public Passeggero(){
        System.out.println("inserisci il nome del passeggero");
        nome = getString();
        System.out.println("inserisci il cognome del passeggero");
        cognome = getString();
        System.out.println("inserisci il data di nascita del passeggero");
        dataNascita = getString();
        System.out.println("inserisci il tipo documento del passeggero");
        tipoDocumento = getString();
        System.out.println("inserisci il numero del documento del passeggero");
        numeroDocumento = getInt();
    }

    public Passeggero(String node){
        String[] row = node.split(",");
        nome = row[0];
        cognome = row[1];
        dataNascita = row[2];
        tipoDocumento = row[3];
        numeroDocumento = Integer.parseInt(row[4]);
    }

    public int compareTo(Passeggero o) {
        return numeroDocumento - o.numeroDocumento;
    }

    public static int getInt(){
        try{
            return new java.util.Scanner(System.in).nextInt();
        }catch(java.util.InputMismatchException e){
            System.out.println("devi inserire un numero intero");
            return getInt();
        }
    }

    public static String getString(){
        try {
            return new java.util.Scanner(System.in).nextLine();
        }catch(java.util.InputMismatchException e){
            System.out.println("devi inserire una stringa");
            return getString();
        }
    }
}