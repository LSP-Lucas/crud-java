package pos_java_jdbc.pos_java_jdbc;

import java.util.List;
import org.junit.Ignore;
import dao.TelefoneDAO;
import model.BeanUserFone;
import model.Telefone;

public class TesteBancoTelefone {
	// Usuários com ID 7 e 9 no banco

	@Ignore
	public void testeInsertTelefone() {

		Telefone telefone = new Telefone();
		telefone.setNumero("(99) 9 999-999");
		telefone.setTipo("Smartphone");
		telefone.setUsuario(7L);

		TelefoneDAO dao = new TelefoneDAO();
		dao.SalvarTelefone(telefone);

	}

	@Ignore
	public void testeCarregaFonesUser() {

		TelefoneDAO dao = new TelefoneDAO();

		List<BeanUserFone> beanUserFones = dao.listaUserFone(7L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-------");
		}
	}

	@Ignore
	public void testeDeleteUserFone() {

		TelefoneDAO dao = new TelefoneDAO();
		dao.deleteFones(7L);
	}
}

