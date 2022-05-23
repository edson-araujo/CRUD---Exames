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
<body style="background-color: #fbfbfb">
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
	<div class="container">
		<s:form cssClass="row mt-5 mb-2 col-sm p-0 align-items-center"
			action="/relatorioConsultas.action">
			<label for="data" class="col text-center"> Data inicial: </label>

			<div class="col-sm-4">
				<s:textfield cssClass="form-control" format="dd-MM-yyyy" type="date"
					id="data" name="consultaVo.dataInicial" />
			</div>

			<label for="data" class="col text-center"> Data final: </label>

			<div class="col-4">
				<s:textfield cssClass="form-control" format="dd-MM-yyyy" type="date"
					id="data" name="consultaVo.dataFinal" />
			</div>

			<div class="col">
				<button style="background-color: #3f8c97; border: none" class="btn btn-primary" type="submit">
					<s:text name="label.pesquisar" />
				</button>
			</div>
		</s:form>

		<div class="row">
			<table class="table table-light table-striped align-middle border-top">
				<thead>
					<tr>
						<th class="text-center"  style="background-color: #fffff"><s:text
								name="label.id" /></th>
						<th class="text-center" style="background-color: #fffff"><s:text
								name="label.codigo.exame" /></th>
						<th class="text-center" style="background-color: #fffff"><s:text
								name="label.nome.exame" /></th>
						<th class="text-center" style="background-color: #fffff"><s:text
								name="label.codigo.funcionario" /></th>
						<th class="text-center" style="background-color: #fffff"><s:text
								name="label.nome.funcionario" /></th>
						<th class="text-center" style="background-color: #fffff"><s:text
								name="label.data" /></th>
					</tr>
				</thead>

				<tbody class="border-top">
					<s:iterator value="consultas">
						<tr>
							<td class="text-center">${idConsulta}</td>
							<td class="text-center">${idExame}</td>
							<td class="text-center">${nmExame}</td>
							<td class="text-center">${idFuncionario}</td>
							<td class="text-center">${nmFuncionario}</td>
							<td class="text-center">${data}</td>
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
