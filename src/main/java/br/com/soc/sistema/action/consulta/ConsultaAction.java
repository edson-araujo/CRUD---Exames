package br.com.soc.sistema.action.consulta;

import br.com.soc.sistema.business.ConsultaBusiness;



import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ConsultaVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ConsultaAction extends Action {

	private final ConsultaBusiness business = new ConsultaBusiness();
	private final FuncionarioBusiness funcionarioBusiness = new FuncionarioBusiness();
	private final ExameBusiness exameBusiness = new ExameBusiness();
	private List<ConsultaVo> consultas = new ArrayList<>();
	private List<FuncionarioVo> funcionarios = new ArrayList<>();
	private List<ExameVo> exames = new ArrayList<>();
	private ConsultaVo consultaVo = new ConsultaVo();
	private ArrayList<String> opcaoFuncionario = new ArrayList<>();
	private ArrayList<String> opcaoExame = new ArrayList<>();

	public String todas() {
		consultas.addAll(business.trazerTodasAsConsultas());

		return SUCCESS;
	}

	public String nova() {
		if (opcaoFuncionario.isEmpty()) {
			funcionarios = funcionarioBusiness.trazerTodosOsFuncionarios();
			exames = exameBusiness.trazerTodosOsExames();
			return INPUT;
		} else {
			consultaVo.setIdFuncionario(opcaoFuncionario.get(0));
			consultaVo.setIdExame(opcaoExame.get(0));
			business.buscarConsultaDuplicada(consultaVo);
			business.salvarConsulta(consultaVo);
			return REDIRECT;
		}
	}

	public String editar() {
		if (opcaoFuncionario.isEmpty()) {
			consultaVo = business.buscarConsultaPorCodigo(consultaVo.getIdConsulta());
			funcionarios = funcionarioBusiness.trazerTodosOsFuncionarios();
			exames = exameBusiness.trazerTodosOsExames();
			return EDIT;
		} else {
			consultaVo.setIdFuncionario(opcaoFuncionario.get(0));
			consultaVo.setIdExame(opcaoExame.get(0));
			business.editarConsulta(consultaVo);
			return REDIRECT;
		}
	}

	public String excluir() {
		business.excluirConsulta(consultaVo.getIdConsulta());

		return REDIRECT;
	}

	public String relatorio() {
		if (consultaVo.getDataInicial() == null)
			return RELATORIO;

		consultas.addAll(business.buscarConsultasPorData(consultaVo));

		return RELATORIO;
	}

	public List<ConsultaVo> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaVo> consultas) {
		this.consultas = consultas;
	}

	public List<FuncionarioVo> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVo> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<ExameVo> getExames() {
		return exames;
	}

	public void setExames(List<ExameVo> exames) {
		this.exames = exames;
	}

	public ConsultaVo getConsultaVo() {
		return consultaVo;
	}

	public void setConsultaVo(ConsultaVo consultaVo) {
		this.consultaVo = consultaVo;
	}

	public ArrayList<String> getOpcaoFuncionario() {
		return opcaoFuncionario;
	}

	public void setOpcaoFuncionario(ArrayList<String> opcaoFuncionario) {
		this.opcaoFuncionario = opcaoFuncionario;
	}

	public ArrayList<String> getOpcaoExame() {
		return opcaoExame;
	}

	public void setOpcaoExame(ArrayList<String> opcaoExame) {
		this.opcaoExame = opcaoExame;
	}

	public String melhores() {
		if (consultaVo.getDataInicial() == null)
			return MELHORES;

		consultas.addAll(business.buscarMelhoresConsultas(consultaVo));

		return MELHORES;
	}
}
