package br.com.soc.sistema.vo;

public class ConsultaVo { //CLASSE DE GET/SET E ATRIBUTOS

    private String idConsulta;
    private String idExame;
    private String nmExame;
    private String qtdExame;
    private String idFuncionario;
    private String nmFuncionario;
    private String data;
    private String dataInicial;
    private String dataFinal;

    public ConsultaVo() {
    }

    public ConsultaVo(String idConsulta, String idExame, String nmExame, String idFuncionario, String nmFuncionario,
	    String data) {
	this.idConsulta = idConsulta;
	this.idExame = idExame;
	this.nmExame = nmExame;
	this.idFuncionario = idFuncionario;
	this.nmFuncionario = nmFuncionario;
	this.data = data;
    }

    public String getIdConsulta() {
	return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
	this.idConsulta = idConsulta;
    }

    public String getNmExame() {
	return nmExame;
    }

    public void setNmExame(String nmExame) {
	this.nmExame = nmExame;
    }

    public String getNmFuncionario() {
	return nmFuncionario;
    }

    public void setNmFuncionario(String nmFuncionario) {
	this.nmFuncionario = nmFuncionario;
    }

    public String getData() {
	return data;
    }

    public void setData(String data) {
	this.data = data;
    }

    public String getIdExame() {
	return idExame;
    }

    public void setIdExame(String idExame) {
	this.idExame = idExame;
    }

    public String getIdFuncionario() {
	return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
	this.idFuncionario = idFuncionario;
    }

    public String getDataInicial() {
	return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
	this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
	return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
	this.dataFinal = dataFinal;
    }

    @Override //SOBRESCREVE
    public String toString() {
	return ("ConsultaVo [idConsulta=" + idConsulta + ", nmExame=" + nmExame + ", nmFuncionario=" + nmFuncionario
		+ ", data=" + data + "]");
    }

    public String getQtdExame() {
	return qtdExame;
    }

    public void setQtdExame(String qtdExame) {
	this.qtdExame = qtdExame;
    }
}
