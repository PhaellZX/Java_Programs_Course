package atividadepratica02;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) {
        if (from < 0 || from >= accounts.length || to < 0 || to >= accounts.length || amount <= 0) {
            // Verifica se as contas são válidas e a quantidade é positiva
            System.out.println("Transferência inválida: contas inválidas ou quantidade não positiva");
            return;
        }

        if (accounts[from] < amount) {
            // Verifica se a conta de origem tem saldo suficiente
            System.out.println("Transferência inválida: saldo insuficiente na conta de origem");
            return;
        }

        accounts[from] -= amount; // Deduz o valor da conta de origem
        accounts[to] += amount;   // Adiciona o valor à conta de destino
        System.out.println("Transferência de $" + amount + " da conta " + from + " para a conta " + to + " realizada com sucesso.");
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (double balance : accounts) {
            totalBalance += balance;
        }
        return totalBalance;
    }

    public int size() {
        return accounts.length;
    }
}