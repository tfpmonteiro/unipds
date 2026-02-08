package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;

import java.io.IOException;

public interface LeitorItensCardapio{

    ItemCardapio[] processaArquivo();

    static LeitorItensCardapio criaLeitor(String nomeArquivo) {
        LeitorItensCardapio leitor = null;

        if (nomeArquivo.endsWith(".csv")) {
            leitor = new LeitorItensCardapioCsv(nomeArquivo);
        } else if (nomeArquivo.endsWith(".json")){
            leitor = new LeitorItensCardapioGson(nomeArquivo);
        } else {
            throw new IllegalArgumentException("Nome de arquivo inválido: " + nomeArquivo);
        }

        return leitor;
    }
}
