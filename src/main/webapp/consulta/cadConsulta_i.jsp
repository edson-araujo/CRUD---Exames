<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title><s:text name="label.titulo.pagina.nova" /></title>
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
	<div class="container">
		<s:form action="/novaConsulta.action">
			<div class="card mt-5">
				<div class="card-header">
					<div class="row">
						<div class="col-sm-5">
							<s:url action="todasConsultas" var="todas" />
							<a href="${todas}" class="btn btn-warning text-white">Consultas</a>
						</div>

						<div class="col-sm">
							<h5 class="card-title"  style="color: #3f8c97">Nova consulta</h5>
						</div>
					</div>
				</div>

				<div class="card-body">
					<div class="row align-items-center">
						<label for="id" class="col-sm-2 col-form-label text-center">
							Código: </label>

						<div class="col-sm-2">
							<s:textfield cssClass="form-control" id="id"
								name="consultaVo.idConsulta" readonly="true" />
						</div>
					</div>

					<div class="row align-items-center mt-3">
						<label for="nomeFuncionario"
							class="col-sm-2 col-form-label text-center">Funcionário:</label>

						<div class="col-sm-5">
							<s:select cssClass="form-select form-control"
								id="opcaoFuncionario" name="opcaoFuncionario"
								list="funcionarios" headerKey="" headerValue="Funcionario..."
								listKey="%{idFuncionario}" listValueKey="%{nome}"
								value="%{consultaVo.idFuncionario}" />
						</div>
					</div>

					<div class="row align-items-center mt-3">
						<label for="nomeExame" class="col-sm-2 col-form-label text-center">Exame:</label>

						<div class="col-sm-5">
							<s:select cssClass="form-select form-control" id="opcaoExame"
								name="opcaoExame" list="exames" headerKey=""
								headerValue="Exame..." listKey="%{idExame}"
								listValueKey="%{nome}" value="%{consultaVo.idExame}" />
						</div>
					</div>

					<div class="row align-items-center mt-3">
						<label for="data" class="col-sm-2 col-form-label text-center">Data:</label>

						<div class="col-sm-5">
							<s:textfield cssClass="form-control" format="dd-MM-yyyy"
								type="date" id="data" name="consultaVo.data" />
						</div>
					</div>
				</div>

				<div class="card-footer">
					<div class="form-row">
						<button style="background-color: #3f8c97; border: none" class="btn text-white col-sm-4 offset-sm-1">Salvar</button>
						<button type="reset"
							class="btn btn-outline-dark col-sm-4 offset-sm-2">Limpar
							Formulário</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
