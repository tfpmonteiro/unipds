package mx.florinda.leitor;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.isento.ItemCardapioIsento;

public class LeitorItensCardapioCsv extends LeitorItensCardapioBase {

    private static final String SEPARADOR = ";";

    LeitorItensCardapioCsv(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    protected ItemCardapio processaLinha(String linha) {
        String[] partes = linha.split(SEPARADOR);

        long id = Long.parseLong(partes[0].trim());
        String nome = partes[1].trim();
        String descricao = partes[2].trim();
        Double preco = Double.parseDouble(partes[3].trim());
        CategoriaCardapio categoria = CategoriaCardapio.valueOf(partes[5].trim());

        ItemCardapio item;
        boolean isento = Boolean.parseBoolean(partes[7]);
        if (isento) {
            item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
        } else {
            item = new ItemCardapio(id, nome, descricao, preco, categoria);
        }


        boolean emPromocao = Boolean.parseBoolean(partes[6]);
        if (emPromocao) {
            double precoComDesconto = Double.parseDouble(partes[4]);
            item.setPromocao(precoComDesconto);
        }
        return item;
    }
}
