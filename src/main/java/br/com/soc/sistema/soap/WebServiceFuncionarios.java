package br.com.soc.sistema.soap;

import br.com.soc.sistema.vo.FuncionarioVo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceFuncionarios {
    @WebMethod
    void inserirFuncionario(FuncionarioVo funcionarioVo);

    @WebMethod
    void excluirFuncionario(String codigo);

    @WebMethod
    void editarFuncionario(FuncionarioVo funcionarioVo);

    @WebMethod
    String buscarFuncionario(String codigo);
}
