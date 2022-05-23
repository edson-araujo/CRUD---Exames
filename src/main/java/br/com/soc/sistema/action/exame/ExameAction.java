package br.com.soc.sistema.action.exame;

import br.com.soc.sistema.business.ExameBusiness;


import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarExames;
import br.com.soc.sistema.vo.ExameVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class ExameAction extends Action {

	private List<ExameVo> exames = new ArrayList<>();
	private final ExameBusiness business = new ExameBusiness();
	private ExameFilter filtrar = new ExameFilter();
	private ExameVo exameVo = new ExameVo();

	public String todos() {
		exames.addAll(business.trazerTodosOsExames());

		return SUCCESS;
	}

	public String novo() {
		if (exameVo.getNome() == null)
			return INPUT;

		business.salvarExame(exameVo);

		return REDIRECT;
	}

	public String editar() {
		if (exameVo.getNome() == null) {
			exameVo = business.buscarExamePorCodigo(exameVo.getIdExame());
			return EDIT;
		} else {
			business.editarExame(exameVo);
			return REDIRECT;
		}
	}

	public String excluir() {
		business.excluirExame(exameVo.getIdExame());

		return REDIRECT;
	}

	public String filtrar() {
		if (filtrar.isNullOpcoesCombo())
			return REDIRECT;

		exames = business.filtrarExames(filtrar);

		return SUCCESS;
	}

	public List<ExameVo> getExames() {
		return exames;
	}

	public void setExames(List<ExameVo> exames) {
		this.exames = exames;
	}

	public ExameVo getExameVo() {
		return exameVo;
	}

	public void setExameVo(ExameVo exameVo) {
		this.exameVo = exameVo;
	}

	public List<OpcoesComboBuscarExames> getListaOpcoesCombo() {
		return Arrays.asList(OpcoesComboBuscarExames.values());
	}

	public ExameFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(ExameFilter filtrar) {
		this.filtrar = filtrar;
	}
}
