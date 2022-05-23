package br.com.soc.sistema.business;

import br.com.soc.sistema.dao.consultas.ConsultaDao;


import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ConsultaVo;

import java.util.List;

public class ConsultaBusiness {

	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private final ConsultaDao dao;

	public ConsultaBusiness() {
		this.dao = new ConsultaDao();
	}

	public List<ConsultaVo> trazerTodasAsConsultas() {
		return dao.findAllConsultas();
	}

	public void salvarConsulta(ConsultaVo consultaVo) {
		try {
			if (consultaVo.getIdExame() == null || consultaVo.getIdFuncionario() == null
					|| consultaVo.getData().isEmpty()) {
				throw new IllegalArgumentException("Campos não podem ficar em branco");
			}
			dao.insertConsulta(consultaVo);
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel salvar a consulta");
		}
	}

	public void editarConsulta(ConsultaVo consultaVo) {
		try {
			if (consultaVo.getIdExame() == null || consultaVo.getIdFuncionario() == null
					|| consultaVo.getData().isEmpty())
				throw new IllegalArgumentException("Campos não podem ficar em branco");

			dao.updateConsulta(consultaVo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Não foi possivel editar a consulta");
		}
	}

	public void excluirConsulta(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			dao.deleteConsulta(cod);
		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public ConsultaVo buscarConsultaPorCodigo(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public List<ConsultaVo> buscarConsultasPorData(ConsultaVo consultaVo) {
		return dao.findConsultasByDate(consultaVo);
	}

	public List<ConsultaVo> buscarMelhoresConsultas(ConsultaVo consultaVo) {
		return dao.findMelhoresConsultas(consultaVo);
	}

	public void buscarConsultaDuplicada(ConsultaVo consultaVo) {
		if (dao.findDuplicada(consultaVo) != null) {
			throw new BusinessException("Não foi possivel inserir a consulta, consulta está duplicada!");
		}
	}
}
