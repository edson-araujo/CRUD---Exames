package br.com.soc.sistema.soap;

import br.com.soc.sistema.vo.ConsultaVo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceConsultas {
    @WebMethod
    void inserirConsulta(ConsultaVo consultaVo);

    @WebMethod
    void excluirConsulta(String codigo);

    @WebMethod
    void editarConsulta(ConsultaVo consultaVo);

    @WebMethod
    String buscarConsulta(String codigo);
}
