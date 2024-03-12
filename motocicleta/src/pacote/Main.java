package pacote;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Main {

    @Test
    public void testMotoAcelera() {
        // Criando uma instância de Moto
        Moto moto = new Moto("Modelo Teste");
        
        // Acelerando a moto
        moto.acelera(50);
        
        // Verificando se a velocidade foi atualizada corretamente
        assertEquals(50, moto.getVelocidade(), 0.01); // Espera-se que a velocidade seja 50
    }

    @Test
    public void testMotoFreia() {
        // Criando uma instância de Moto
        Moto moto = new Moto("Modelo Teste");
        
        // Acelerando a moto
        moto.acelera(100);
        
        // Freando a moto
        moto.freia(50);
        
        // Verificando se a velocidade foi atualizada corretamente
        assertEquals(50, moto.getVelocidade(), 0.01); // Espera-se que a velocidade seja 50
    }

    @Test
    public void testMotoAbastecer() {
        // Criando uma instância de Moto
        Moto moto = new Moto("Modelo Teste");
        
        // Abastecendo a moto
        moto.abastecer(10);
        
    }
}
