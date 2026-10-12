import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível cadastrar o produto.\n" + erro.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        String sql = "SELECT id, nome, valor, status FROM produtos ORDER BY id";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet resultset = prep.executeQuery()) {

            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                listagem.add(produto);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível listar os produtos.\n" + erro.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return listagem;
    }
    
    public void venderProduto(int id) {
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, "Vendido");
            prep.setInt(2, id);

            int linhasAfetadas = prep.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Produto vendido com sucesso!"
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Nenhum produto encontrado com esse ID.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível vender o produto.\n" + erro.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
