<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title><s:text name="label.titulo.pagina.consulta" /></title>
<link rel="icon" type="image/png"
	href="https://www.soc.com.br/wp-content/uploads/2020/12/logo-soc.svg" />
<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
</head>
<body class="bg-light">
<nav>
		<div class="btn-group  " role="group"
			aria-label="Button group with nested dropdown">
			<button type="button" class="btn btn-primary"
				style="background-color: #3f8c97; border-color: #3f8c97">
				<s:url action="todosFuncionarios" var="todos" />
				<a class="text-white" style="text-decoration: none" href="${todos}">Funcionários</a>
			</button>
			<button type="button" class="btn btn-primary"
				style="background-color: #3f8c97; border-color: #3f8c97">
				<s:url action="todosExames" var="todos" />
				<a class="text-white" style="text-decoration: none" href="${todos}">Exames</a>
			</button>

			<div class="btn-group" role="group">
				<button id="btnGroupDrop1" type="button"
					class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
					aria-expanded="false"
					style="background-color: #3f8c97; border-color: #3f8c97">Consulta</button>
				<ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
					<li><s:url action="todasConsultas" var="consultas" /> <a
						class="dropdown-item" href="${consultas}">Consultas</a></li>
					<li><s:url action="relatorioConsultas" var="relatorio" /> <a
						class="dropdown-item  " href="${relatorio}">Relatório de
							consultas</a></li>
					<li><s:url action="melhoresConsultas" var="melhores" /> <a
						class="dropdown-item" href="${melhores}">Ranking de consultas</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container ">
	
		<div class="row mt-5">
						<div style="margin-bottom: 10px">

					<div style="margin-bottom: -40px"><h4 style="color: #3f8c97">Consulta</h4></div>
					
						<div class="d-flex justify-content-end"><s:url
								action="novaConsulta" var="novo" /> 
								<a href="${novo}"
							class="btn btn text-white " style="background-color: #3f8c97">
								<svg style = "padding: 2px; margin-right: 8px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path fill-rule="evenodd" fill="rgb(255,255,255)" d="M5 2.5a.5.5 0 00-.5.5v18a.5.5 0 00.5.5h14a.5.5 0 00.5-.5V8.5h-4a2 2 0 01-2-2v-4H5zm10 0v4a.5.5 0 00.5.5h4a.5.5 0 00-.146-.336l-4.018-4.018A.5.5 0 0015 2.5zM3 3a2 2 0 012-2h9.982a2 2 0 011.414.586l4.018 4.018A2 2 0 0121 7.018V21a2 2 0 01-2 2H5a2 2 0 01-2-2V3z"></path></svg>
								<s:text name="label.novo" />
						</a></div>
						
					
				</div>
			<table class="table table-striped align-middle border-top">
				<thead>
					<tr>
						<th class="text-center" style="background-color: #fffff"><s:text
								name="label.id" /></th>
						<th style="background-color: #fffff"><s:text
								name="label.nome.funcionario" /></th>
						<th style="background-color: #fffff"><s:text
								name="label.nome.exame" /></th>
						<th style="background-color: #fffff"><s:text
								name="label.data" /></th>
						<th class="text-end mt-5 " style="background-color: #fffff"><s:text
								name="label.acao" /></th>
					</tr>
				</thead>

				<tbody class="border-top">
					<s:iterator value="consultas">
						<tr>
							<td class="text-center">${idConsulta}</td>
							<td>${nmFuncionario}</td>
							<td>${nmExame}</td>
							<td>${data}</td>
							<td class="text-end"><s:url action="editarConsulta"
									var="editar">
									<s:param name="consultaVo.idConsulta" value="idConsulta"></s:param>
								</s:url> <a href="${editar}" class="btn btn-warning text-white"> <s:text
										name="label.editar" />
							</a> <s:url action="excluirConsulta" var="excluir">
									<s:param name="consultaVo.idConsulta" value="idConsulta"></s:param>
								</s:url> <a href="${excluir}" class="btn btn-outline-danger"> <s:text
										name="label.excluir" />
							</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>

		<div class="row"></div>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
