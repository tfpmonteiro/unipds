package mx.florinda.modelo;

import java.util.Objects;

public class ItemCardapio {
    String nome;
    String descricao;
    boolean emPromocao;
    double preco;
    double precoComDesconto;
    long id;
    CategoriaCardapio categoria;

    public ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;

        if (preco < 0) {
            throw new FlorindaException("Preço não pode ser negativo: " + preco);
        }
    }

    public double calculaPorcentagemDesconto() {
        double desconto = preco - precoComDesconto;
        return desconto / preco;
    }

    public CategoriaCardapio getNomeCategoria() {
        return categoria;
    }

    public void setPromocao(double precoComDesconto) {
        emPromocao = true;
        this.precoComDesconto = precoComDesconto;
    }


    public double getImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto * 0.1;
            return imposto;
        }

        imposto = preco * 0.1;

        return imposto;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public long getId() {
        return id;
    }

    public CategoriaCardapio getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCardapio categoria) {
        this.categoria = categoria;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrecoComDesconto(double precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEmPromocao(boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ItemCardapio{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", emPromocao=" + emPromocao +
                ", preco=" + preco +
                ", precoComDesconto=" + precoComDesconto +
                ", id=" + id +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemCardapio that = (ItemCardapio) o;
        return emPromocao == that.emPromocao && Double.compare(preco, that.preco) == 0 && Double.compare(precoComDesconto, that.precoComDesconto) == 0 && id == that.id && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && categoria == that.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, emPromocao, preco, precoComDesconto, id, categoria);
    }
}
