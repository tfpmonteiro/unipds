package mx.florinda.leitor;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.isento.ItemCardapioIsento;

public class LeitorItensCardapioJson extends LeitorItensCardapioBase {

    public LeitorItensCardapioJson(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    protected ItemCardapio processaLinha(String linha) {
        linha = linha.replace("[", "").trim();
        linha = linha.replace("]", "").trim();
        linha = linha.replace("{", "").trim();
        linha = linha.replace("}", "").trim();
        linha = linha.replace("\"", "").trim();

        String partes[] = linha.split(",");

        String parteId = partes[0].trim();
        String[] propriedadeValor = parteId.split(":");
        String valorId = propriedadeValor[1].trim();
        long id = Long.parseLong(valorId);

        String parteNome = partes[1].trim();
        String[] propriedadeValorNome = parteNome.split(":");
        String valorNome = propriedadeValorNome[1].trim();
        String nome = valorNome;

        String parteDescricao = partes[2].trim();
        String[] propriedadeValorDescricao = parteDescricao.split(":");
        String valorDescricao = propriedadeValorDescricao[1].trim();
        String descricao = valorDescricao;

        String partePreco = partes[3].trim();
        String[] propriedadeValorPreco = partePreco.split(":");
        String valorPreco = propriedadeValorPreco[1].trim();
        double preco = Double.parseDouble(valorPreco);

        String parteCategoria = partes[6].trim();
        String[] propriedadeValorCategoria = parteCategoria.split(":");
        String valorCategoria = propriedadeValorCategoria[1].trim();
        CategoriaCardapio categoria = CategoriaCardapio.valueOf(valorCategoria);

        ItemCardapio itemCardapio;
        String parteIsento = partes[7].trim();
        String[] propriedadeValorIsento = parteIsento.split(":");
        String valorIsento = propriedadeValorIsento[1].trim();
        boolean isento = Boolean.parseBoolean(valorIsento);
        if (isento) {
            itemCardapio = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
        } else {
            itemCardapio = new ItemCardapio(id, nome, descricao, preco, categoria);
        }

        String partePromocao = partes[5].trim();
        String[] propriedadeValorPromocao = partePromocao.split(":");
        String valorPromocao = propriedadeValorPromocao[1].trim();
        boolean emPromocao = Boolean.parseBoolean(valorPromocao);
        if (emPromocao) {
            String partePrecoPromocao = partes[4].trim();
            String[] propriedadeValorPrecoPromocao = partePrecoPromocao.split(":");
            String valorPrecoPromocao = propriedadeValorPrecoPromocao[1].trim();
            double precoComDesconto = Double.parseDouble(valorPrecoPromocao);
            itemCardapio.setPromocao(precoComDesconto);
        }

        return itemCardapio;
    }



}
