package br.com.zup.estrelas.carros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.zup.estrelas.carros.factory.ConnectionFactory;
import br.zup.estrelas.carros.pojo.Carro;

public class CarroDAO {

	private Connection conn;

	public CarroDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public Carro retornaCarro(String placa) {

		Carro carro = new Carro();

		String sql = "select * from carros where placa = ?";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, placa);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				carro.setPlaca(rs.getString("placa"));
				carro.setCor(rs.getString("cor"));
				carro.setNome(rs.getString("nome"));
				carro.setFabricante(rs.getString("fabricante"));
				carro.setVelMaxima(rs.getDouble("vel_maxima"));
				carro.setPeso(rs.getDouble("peso"));

			}

			stmt.close();

		} catch (SQLException e) {

			System.err.println("IMPOSSÍVEL ENCONTRAR O CARRO!");
			System.err.println(e.getMessage());

		}

		return carro;
	}

	public boolean insereCarro(Carro carroDB) {
		
		String sql = "inset into carros"
				+ "(placa, cor, nome, fabricante,"
				+ "vel_maxima, peso)"
				+ "values (?, ?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, carroDB.getPlaca());
			stmt.setString(2, carroDB.getCor());
			stmt.setString(3, carroDB.getNome());
			stmt.setString(4, carroDB.getFabricante());
			stmt.setDouble(5, carroDB.getVelMaxima());
			stmt.setDouble(6, carroDB.getPeso());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL CADASTRAR UM CARRO!");
			System.err.println(e.getMessage());
			
			return false;
		
		}
		
		return true;
	}

}
