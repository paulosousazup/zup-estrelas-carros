package br.zup.estrelas.carros.pojo;

public class Carro {
	
	private String placa;
	private String cor;
	private String nome;
	private String fabricante;
	private Double VelMaxima;
	private Double peso;
	
	public Carro() {
		
	}
	
	public Carro(String placa, String cor, String nome, String fabricante, 
			Double VelMaxima, Double peso) {
		
		this.placa = placa;
		this.cor = cor;
		this.nome = nome;
		this.fabricante = fabricante ;
		this.VelMaxima = VelMaxima;
		this.peso = peso;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getVelMaxima() {
		return VelMaxima;
	}

	public void setVelMaxima(Double velMaxima) {
		VelMaxima = velMaxima;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
}
