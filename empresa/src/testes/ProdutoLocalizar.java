package testes;
import model.Produto;
import model.ProdutoDAO;
import javax.swing.JOptionPane;
public class ProdutoLocalizar {
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		int codigo = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite o código do produto: "));
		Produto p = dao.localizar(codigo);
		if (p!=null) {
			System.out.println(p);
		}
		else {
			System.out.println("Produto não encontrado!");
		}
	}
}

