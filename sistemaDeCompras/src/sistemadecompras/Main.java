package sistemadecompras;

public class Main {
     public static void main(String[] args) {
        // Cria instâncias de itens disponíveis para compra
        Item item1 = new Item("Camisa", 29.99, 10);
        Item item2 = new Item("Calça", 49.99, 5);
        Item item3 = new Item("Boné", 14.99, 20);

        // Cria o carrinho de compras
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        // Cria threads representando pessoas adicionando ou removendo itens do carrinho
        Thread thread1 = new Thread(new Comprador(carrinho, item1));
        Thread thread2 = new Thread(new Comprador(carrinho, item2));
        Thread thread3 = new Thread(new Comprador(carrinho, item3));
        Thread thread4 = new Thread(new Comprador(carrinho, item1)); // Testando adição do mesmo item por outra pessoa
        Thread thread5 = new Thread(new Comprador(carrinho, item2)); // Testando adição do mesmo item por outra pessoa

        // Inicia as threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        // Aguarda as threads terminarem
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe o carrinho de compras e o total
        System.out.println("Itens no carrinho:");
        for (Item item : carrinho.getItens()) {
            System.out.println(item.getNome());
        }
        System.out.println("Total: $" + carrinho.calcularTotal());
    }
}
