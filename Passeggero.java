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
        System.out.println("inserisci il data di nascita del passeggero nel formato \"aaa/mm/gg\"");
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

    /**
     * metodo che prende in input un booleano. <p>nel caso in cui l'utente non vada ad inserire un booleano verrà segnalato l'errore e atteso un nuovo input</p>
     * @return il booleano inserito dall'utente
     */
    public static boolean getBoolean(){
        try{
            System.out.println("(insert \"true\" or \"false\")");
            return new java.util.Scanner(System.in).nextBoolean();
        }catch (java.util.InputMismatchException e){
            return getBoolean();
        }
    }

    @Override
    public String toString(){
        return super.toString() +
                "{\n\t\t\tnome:\t\t\t\t" + nome + '\n' +
                "\t\t\tcognome:\t\t\t" + cognome + '\n' +
                "\t\t\tdataNascita:\t\t" + dataNascita + '\n' +
                "\t\t\ttipoDocumento:\t\t" + tipoDocumento + '\n' +
                "\t\t\tnumeroDocumento:\t" + numeroDocumento +
                "\n}";
    }
}