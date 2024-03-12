package sistemadecompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public synchronized void adicionarItem(Item item) {
        itens.add(item);
    }

    public synchronized void removerItem(Item item) {
        itens.remove(item);
    }

    public synchronized double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public List<Item> getItens() {
        return itens;
    }
}
