package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Mensagem;

public class MensagemDAO extends DAO {

  public MensagemDAO() {
    super();
    conectar();
  }

  public void finalize() {
    close();
  }

  public boolean insert(Mensagem mensagem) {
    boolean status = false;
    try {
      Statement st = conexao.createStatement();
      String sql =
        "INSERT INTO mensagem (descricao, codigo_usuario_remetente, codigo_usuario_destinatario) " +
        "VALUES ('" +
        mensagem.getDescricao() +
        "', '" +
        mensagem.getCodigoUsuarioRemetente() +
        "', '" +
        mensagem.getCodigoUsuarioDestinatario() +
        "');";
      // System.out.println(sql);
      st.executeUpdate(sql);
      st.close();
      status = true;
    } catch (SQLException u) {
      throw new RuntimeException(u);
    }
    
    return status;
  }

  public List<Mensagem> getMensagem(int remetenteId, int destinatarioId) throws Exception {
    List<Mensagem> mensagens = new ArrayList<Mensagem>();

    try {
      Statement st = conexao.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY
      );
      String sql = "SELECT * FROM mensagem WHERE (codigo_usuario_remetente = '" + remetenteId + "\' AND codigo_usuario_destinatario = '" + destinatarioId + "\');";
      // System.out.println(sql);
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
      	Mensagem m = new Mensagem(
          rs.getInt("id"),
          rs.getString("descricao"),
          rs.getInt("codigo_usuario_remetente"),
          rs.getInt("codigo_usuario_destinatario")
        );
        mensagens.add(m);
      }
      st.close();
    } catch (Exception e) {
    	throw new Exception(e);
    }
    return mensagens;
  }
}
