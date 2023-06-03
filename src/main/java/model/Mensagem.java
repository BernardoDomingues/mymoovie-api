package model;

public class Mensagem {
  private int id;
  private String descricao;
  private int codigoUsuarioRemetente;
  private int codigoUsuarioDestinatario;
  
  public Mensagem() {
    this.id = -1;
    this.descricao = "";
    this.codigoUsuarioRemetente = -1;
    this.codigoUsuarioDestinatario = -1;
  }

  public Mensagem(int id, String descricao, int codigoUsuarioRemetente, int codigoUsuarioDestinatario) {
    this.id = id;
    this.descricao = descricao;
    this.codigoUsuarioRemetente = codigoUsuarioRemetente;
    this.codigoUsuarioDestinatario = codigoUsuarioDestinatario;
  }
  
  public int getCodigo() {
    return id;
  }
  
  public void setCodigo(int id) {
    this.id = id;
  }
  
  public String getDescricao() {
    return descricao;
  }
  
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  public int getCodigoUsuarioRemetente() {
    return codigoUsuarioRemetente;
  }
  
  public void setCodigoUsuarioRemetente(int codigoUsuarioRemetente) {
    this.codigoUsuarioRemetente = codigoUsuarioRemetente;
  }
  
  public int getCodigoUsuarioDestinatario() {
    return codigoUsuarioDestinatario;
  }
  
  public void setCodigoUsuarioDestinatario(int codigoUsuarioDestinatario) {
    this.codigoUsuarioDestinatario = codigoUsuarioDestinatario;
  }
}