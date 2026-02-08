package mx.florinda.modelo;

import mx.florinda.leitor.LeitorItensCardapio;

import java.io.IOException;

public class Cardapio {

    private ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) {
        LeitorItensCardapio leitor = LeitorItensCardapio.criaLeitor(nomeArquivo);
        itens = leitor.processaArquivo();
    }

    public ItemCardapio obtemItemPorId(long id) {
        return this.itens[((int) id - 1)];
    }

    public double getSomaDosPrecos() {
        double totalDePrecos = 0.0;

        for (ItemCardapio item : itens) {
            totalDePrecos += item.getPreco();
        }

        return totalDePrecos;
    }

    public int getTotalItensEmPromocao() {
        int totalItensEmPromocao = 0;

        for (ItemCardapio item : itens) {
            if (item.isEmPromocao())
                totalItensEmPromocao++;
        }

        return totalItensEmPromocao;
    }

    public double getPrimeiroPrecoMaiorQueLimite(double precoLimite) {
        double precoMaiorQueLimite = -1.0;

        for (ItemCardapio item : itens) {
            if (item.getPreco() > precoLimite) {
                precoMaiorQueLimite = item.getPreco();
                break;
            }
        }

        return precoMaiorQueLimite;
    }

    public ItemCardapio[] getItens() {
        return itens;
    }
}
