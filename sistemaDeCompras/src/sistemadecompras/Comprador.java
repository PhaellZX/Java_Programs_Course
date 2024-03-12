package sistemadecompras;

public class Comprador implements Runnable {
    private CarrinhoDeCompras carrinho;
    private Item item;

    public Comprador(CarrinhoDeCompras carrinho, Item item) {
        this.carrinho = carrinho;
        this.item = item;
    }

    @Override
    public void run() {
        synchronized (carrinho) {
            carrinho.adicionarItem(item);
            System.out.println(Thread.currentThread().getName() + " adicionou " + item.getNome() + " ao carrinho");
            try {
                Thread.sleep(1000); // Simula o tempo de compra
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
