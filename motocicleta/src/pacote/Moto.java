package pacote;


public class Moto {
	private final String modelo;
	private double velocidade;
	private static final int VEL_FINAL = 150;
	private static final int tanque = 50;
	private double combustivel;
	
	public Moto(String modelo) {
		this.modelo = modelo;
		this.velocidade = 0;
		this.combustivel = 50;
	}
	public String getModelo() {
		return modelo;
	}
		
	public double getVelocidade() {
			return velocidade;
	}
	void acelera(int vel) {
			if(this.velocidade+vel>VEL_FINAL) this.velocidade=VEL_FINAL;
			else this.velocidade+=vel; this.combustivel -= (0.01 * 1);
		
	}
	void freia(int vel) {
			if(this.velocidade+vel<0) this.velocidade=0;
			else this.velocidade-=vel;
	}
	void abastecer(int litros) {
		if(this.combustivel+litros>tanque) System.out.println("Tanque cheio!!");
		else this.combustivel += litros;
	}
	@Override
	public String toString() {
		return "Moto [modelo=" + modelo + ", velocidade=" + velocidade + ", combustivel=" + combustivel + "]";
	}
}
