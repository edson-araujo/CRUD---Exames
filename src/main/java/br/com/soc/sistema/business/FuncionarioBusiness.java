package br.com.soc.sistema.business;

import br.com.soc.sistema.dao.funcionarios.FuncionarioDao;

import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBusiness {

	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private final FuncionarioDao dao;

	public FuncionarioBusiness() {
		this.dao = new FuncionarioDao();
	}

	public List<FuncionarioVo> trazerTodosOsFuncionarios() {
		return dao.findAllFuncionarios();
	}

	public void salvarFuncionario(FuncionarioVo funcionarioVo) {
		try {
			if (funcionarioVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");

			dao.insertFuncionario(funcionarioVo);
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel inserir o funcionario");
		}
	}

	public void excluirFuncionario(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			dao.deleteFuncionario(cod);
		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public void editarFuncionario(FuncionarioVo funcionarioVo) {
		try {
			if (funcionarioVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");

			dao.updateFuncionario(funcionarioVo);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel editar o funcionario");
		}
	}

	public List<FuncionarioVo> filtrarFuncionarios(FuncionarioFilter filter) {
		List<FuncionarioVo> funcionarios = new ArrayList<>();

		switch (filter.getOpcoesCombo()) {
		case ID:
			try {
				Integer codigo = Integer.parseInt(filter.getValorBusca());
				funcionarios.add(dao.findByCodigo(codigo));
			} catch (NumberFormatException e) {
				throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
			}
			break;
		case NOME:
			funcionarios.addAll(dao.findAllByNome(filter.getValorBusca()));
			break;
		}

		return funcionarios;
	}

	public FuncionarioVo buscarFuncionarioPorCodigo(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}
}
