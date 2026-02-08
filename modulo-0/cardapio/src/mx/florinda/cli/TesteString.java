package mx.florinda.cli;

public class TesteString {

    void main(){
        String nomeItem1 = "Refresco do Chaves";
        System.out.println(nomeItem1.toUpperCase());
        System.out.println(nomeItem1.toLowerCase());
        System.out.println(nomeItem1.length());
        System.out.println(nomeItem1.charAt(1));
        System.out.println(nomeItem1.toLowerCase().replace(" ", "-"));
        System.out.println("contains: " + nomeItem1.contains("Chaves"));
        System.out.println("startsWith Chaves: " + nomeItem1.startsWith("Chaves"));
        System.out.println("endsWith Chaves: " + nomeItem1.endsWith("Chaves"));
        System.out.println("concat: " + nomeItem1.concat(" gostosin"));
        System.out.println("substring: " + nomeItem1.substring(0,8));

        String[] pedacos = nomeItem1.split(" ");
        IO.println("tamanho do arrey do nomeItem1: " + pedacos.length);
        IO.println("----------");

        for(String pedaco : pedacos){
            IO.println(pedaco);
        }

        IO.println("----------");

        String frase = "Refresco do Chaves";
        IO.println(nomeItem1 ==  frase); // true
        String item = IO.readln("Digite: ");
        IO.println(nomeItem1 ==  item); // false
        IO.println(nomeItem1.equals(item)); // true

        long inicio = System.currentTimeMillis();
        String teste= "";
        for(int i = 0; i<1_000; i++){
            teste += i + ", ";
        }
        long fim = System.currentTimeMillis();
        IO.println("Tempo de execução do for: " + (fim - inicio));
        IO.println(teste);

        long inicioSB = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<1_000; i++){
            builder.append(i + ", ");
        }
        long fimSB = System.currentTimeMillis();
        IO.println("Tempo de execução do for SB: " + (fimSB - inicioSB));
        IO.println(builder);
    }
}
