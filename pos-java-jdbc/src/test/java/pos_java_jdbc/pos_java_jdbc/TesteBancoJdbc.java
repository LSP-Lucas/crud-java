package pos_java_jdbc.pos_java_jdbc;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {

	@Ignore
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Ary Teste ");
		userposjava.setEmail("teste@gmail.com.br");

		userPosDao.salvar(userposjava);
	}

	@Ignore
	public void initListar() {
		UserPosDao posDao = new UserPosDao();
		try {
			List<Userposjava> list = posDao.lista();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("--------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();

		try {
			Userposjava userposjava = dao.buscar(1L);
			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	public void initAtualizar() {
		try {

			UserPosDao dao = new UserPosDao();

			Userposjava objetoBanco = dao.buscar(1L);

			objetoBanco.setNome("Nome mudado com o metodo atualizar");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initDeletar() {
		try {

			UserPosDao dao = new UserPosDao();
			dao.deletar(8L);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
