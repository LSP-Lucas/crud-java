package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;

public class TelefoneDAO {

	private Connection connection;

	public TelefoneDAO() {
		connection = SingleConnection.getConnection();
	}

	public void SalvarTelefone(Telefone telefone) {
		try {

			String sql = "INSERT INTO telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());

			statement.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<BeanUserFone> listaUserFone(Long idUser) {

		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();

		String sql = " select * from telefoneuser as fone ";
		sql += " inner join userposjava as userp ";
		sql += " on fone.usuariopessoa = userp.id ";
		sql += " where userp.id = " + idUser;

		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				BeanUserFone userFone = new BeanUserFone();
				userFone.setEmail(resultSet.getString("email"));
				userFone.setNome(resultSet.getString("nome"));
				userFone.setNumero(resultSet.getString("numero"));

				beanUserFones.add(userFone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return beanUserFones;
	}

	public void deleteFones(Long idUser) {

		String sqlFone = "delete from telefoneuser where usuariopessoa = " + idUser;

		try {

			PreparedStatement statement = connection.prepareStatement(sqlFone);
			statement.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
