package service;

import java.util.List;

import com.google.gson.Gson;
import dao.MensagemDAO;
import spark.Request;
import spark.Response;
import model.Mensagem;
import model.Resp;

public class MensagemService {

  private MensagemDAO mensagemDAO = new MensagemDAO();

  public MensagemService() {}

  public String enviar(Request request, Response response) {
    Gson gson = new Gson();
    Mensagem mensagem = gson.fromJson(request.body(), Mensagem.class);
    
    if(mensagemDAO.insert(mensagem) == true) {
      return gson.toJson(new Resp(true, "Mensagem registrado com sucesso!"));
    } else {
      return gson.toJson(new Resp(false, "Erro no registro do comentario"));
    }
  }

  public String listarMensagensPorUsuario(Request request, Response response) {
    Gson gson = new Gson();
    response.type("application/json");
    int remetenteId = Integer.parseInt(request.params(":remetenteId"));
    int destinatarioId = Integer.parseInt(request.queryParams("destinatarioId"));
    
    System.out.println(remetenteId);
    System.out.println(destinatarioId);
    
    try {
    	List<Mensagem> mensagemLista = mensagemDAO.getMensagem(remetenteId, destinatarioId);
    	return gson.toJson(mensagemLista);
    } catch (Exception e) {
    	return gson.toJson(e);
    }
  }
}
