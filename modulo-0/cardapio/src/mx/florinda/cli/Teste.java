import mx.florinda.modelo.Cardapio;
import mx.florinda.modelo.ItemCardapio;

void main() {

    //String formatoCardapio = IO.readln("Digite 1 para CSV e 2 para Json: ");
    //String nomeCardapio = formatoCardapio.equals("1") ? "itens-cardapio-com-cabecalho.csv" : "itens-cardapio-gson.json";

    String nomeCardapio = IO.readln("Digite o nome do cardápio: ");

   Cardapio cardapio = new Cardapio(nomeCardapio);

   String linha = IO.readln("Digite um id de um item de cardápio:");
   long idSelecionado = Long.parseLong(linha);

    ItemCardapio itemSelecionado = cardapio.obtemItemPorId(idSelecionado);

    IO.println("== Item do Carpápio ==");
    IO.println("Id: " + itemSelecionado.getId());
    IO.println("Nome: " + itemSelecionado.getNome());
    IO.println("Descricao: " + itemSelecionado.getDescricao());

    if (itemSelecionado.isEmPromocao()) {
        IO.println("Item em promoção");
        double porcentagemDesconto = itemSelecionado.calculaPorcentagemDesconto();
        IO.println("Preço de: R$" + itemSelecionado.getPreco() + " por R$" + itemSelecionado.getPrecoComDesconto());
        IO.println("Porcentagem de desconto " + itemSelecionado.getPrecoComDesconto() + "%");
    } else {
        IO.println("Preço: R$" + itemSelecionado.getPreco());
    }
    IO.println("Categoria: " + itemSelecionado.getNomeCategoria());
    IO.println("Imposto: R$" + itemSelecionado.getImposto());
    IO.println("------------------");

    IO.println("Soma dos preços R$" + cardapio.getSomaDosPrecos());
    IO.println("Total de itens em promoção " + cardapio.getTotalItensEmPromocao());

    linha = IO.readln("Digite um preço limite:");
    double precoLimite =  Double.parseDouble(linha);

    IO.println("O primeiro preço do cardápio maior que " + precoLimite + " é: " + cardapio.getPrimeiroPrecoMaiorQueLimite(precoLimite));

    IO.println("------------------");

    ItemCardapio itemCardapio = cardapio.obtemItemPorId(1L);

    if (itemCardapio.isEmPromocao()) {
        double porcentagemDesconto = itemCardapio.calculaPorcentagemDesconto();
        IO.println("Porcentagem do desconto: " + (porcentagemDesconto * 100) + "%");
        IO.println("Preço: de R$" + itemCardapio.getPreco() + " por R$" + itemCardapio.getPrecoComDesconto());
    } else {
        IO.println("Preço: R$" + itemCardapio.getPreco());
    }

    switch (itemCardapio.getCategoria()) {
        case ENTRADA:
            IO.println("Categoria: Entradas");
            break;
        case PRATOS_PRINCIPAIS:
            IO.println("Categoria: Pratos principais");
            break;
        case SOBREMESAS:
            IO.println("Categoria: Sobremesas");
            break;
        case BEBIDAS:
            IO.println("Categoria: Bebidas");
            break;
    
        default:
            IO.println("Categoria não encontrada");
            break;
    }
}


