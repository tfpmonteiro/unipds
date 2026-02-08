package mx.florinda.leitor;

import com.google.gson.Gson;
import mx.florinda.modelo.ItemCardapio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorItensCardapioGson implements LeitorItensCardapio{

    private final String nomeArquivo;

    public LeitorItensCardapioGson(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public ItemCardapio[] processaArquivo() {
        try {
            String conteudoArquivo = Files.readString(Path.of(nomeArquivo));
            return new Gson().fromJson(conteudoArquivo, ItemCardapio[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
