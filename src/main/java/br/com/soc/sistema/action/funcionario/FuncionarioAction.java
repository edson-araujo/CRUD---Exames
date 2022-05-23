package br.com.soc.sistema.action.funcionario;

import br.com.soc.sistema.business.FuncionarioBusiness;

import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarFuncionarios;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class FuncionarioAction extends Action {

	private final FuncionarioBusiness business = new FuncionarioBusiness();
	private FuncionarioVo funcionarioVo = new FuncionarioVo();
	private List<FuncionarioVo> funcionarios = new ArrayList<>();
	private FuncionarioFilter filtrar = new FuncionarioFilter();

	public String todos() {
		funcionarios.addAll(business.trazerTodosOsFuncionarios());

		return SUCCESS;
	}

	public String novo() {
		if (funcionarioVo.getNome() == null)
			return INPUT;

		business.salvarFuncionario(funcionarioVo);

		return REDIRECT;
	}

	public String editar() {
		if (funcionarioVo.getNome() == null) {
			funcionarioVo = business.buscarFuncionarioPorCodigo(funcionarioVo.getIdFuncionario());
			return EDIT;
		} else {
			business.editarFuncionario(funcionarioVo);
			return REDIRECT;
		}
	}

	public String excluir() {
		business.excluirFuncionario(funcionarioVo.getIdFuncionario());

		return REDIRECT;
	}

	public String filtrar() {
		if (filtrar.isNullOpcoesCombo())
			return REDIRECT;

		funcionarios = business.filtrarFuncionarios(filtrar);

		return SUCCESS;
	}

	public List<FuncionarioVo> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVo> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public FuncionarioVo getFuncionarioVo() {
		return funcionarioVo;
	}

	public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
		this.funcionarioVo = funcionarioVo;
	}

	public List<OpcoesComboBuscarFuncionarios> getListaOpcoesCombo() {
		return Arrays.asList(OpcoesComboBuscarFuncionarios.values());
	}

	public FuncionarioFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(FuncionarioFilter filtrar) {
		this.filtrar = filtrar;
	}
}
