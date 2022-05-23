package br.com.soc.sistema.soap;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.vo.ExameVo;

import javax.jws.WebService;

@WebService(endpointInterface = "br.com.soc.sistema.soap.WebServiceExames")
public class WebServiceExamesImpl implements WebServiceExames {

    private final ExameBusiness business;

    public WebServiceExamesImpl() {
        this.business = new ExameBusiness();
    }

    @Override
    public void inserirExame(ExameVo exameVo) {
        business.salvarExame(exameVo);
    }

    @Override
    public String buscarExame(String codigo) {
        return business.buscarExamePorCodigo(codigo).toString();
    }

    @Override
    public void excluirExame(String codigo) {
        business.excluirExame(codigo);
    }

    @Override
    public void editarExame(ExameVo exameVo) {
        business.editarExame(exameVo);
    }
        
}
