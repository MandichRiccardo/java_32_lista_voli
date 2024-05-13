public class Test{
    public static void main(String[] args){
        ListVoli listaVoli = creazioneListaVoli(new ListVoli());
    }

    public static ListVoli creazioneListaVoli(ListVoli listaVoli){
        System.out.println("stato attuale della lista:\n" + listaVoli);
        System.out.println("""
                cosa vuoi fare?
                    0) terminare questa fase del programma
                    1)aggiungere un nuovo volo alla lista
                    2)rimuovere un volo dalla lista
                    3)ordinare la lista\t(verrà fatto sulla base del numero del volo""");
        switch (Passeggero.getInt()){
            default -> {
                return listaVoli;
            }
            case 1 -> {
                listaVoli.addNode(new NodeVolo());
                return creazioneListaVoli(listaVoli);
            }
            case 2 -> {
                listaVoli.removeNode(new NodeVolo());
                return creazioneListaVoli(listaVoli);
            }
            case 3 -> {
                listaVoli.order();
                return creazioneListaVoli(listaVoli);
            }
        }
    }
}