package mx.florinda.cli;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;

public class TesteObjetos {
    static void main() {
        Object[] lista = new Object[5];

        lista[0] = 1;
        lista[1] = 32.5;
        lista[2] = "String";
        lista[3] = true;
        lista[4] = new ItemCardapio(10L, "Item 10", "descrição item 10", 10.99, CategoriaCardapio.BEBIDAS);

        for (Object item : lista) {
            IO.println(item.toString());
        }

        IO.println("----------------------");

        var item = new ItemCardapio(10L, "Item 10", "descrição item 10", 10.99, CategoriaCardapio.BEBIDAS);
        IO.println(item);
        IO.println("----------------------");

        IO.println(item == lista[4]);
        IO.println(lista[4].equals(item)); // true; porque foi criado o meetodos equals no objeto.
    }
}
