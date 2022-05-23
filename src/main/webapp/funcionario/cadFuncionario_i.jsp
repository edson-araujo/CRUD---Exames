<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title><s:text name="label.titulo.pagina.cadastro" /></title>
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
		<s:form action="/novoFuncionario.action">
			<div class="card mt-5">
				<div class="card-header">
					<div class="row">
						<div class="col-sm-5">
							<s:url action="todosFuncionarios" var="todos" />
							<a href="${todos}" class="btn btn-warning">Funcionários</a>
						</div>

						<div class="col-sm">
							<h5 class="card-title" style="color: #3f8c97">Novo Funcionário</h5>
						</div>
					</div>
				</div>

				<div class="card-body">
					<div class="row align-items-center">
						<label for="id" class="col-sm-1 col-form-label text-center">Código:
						</label>

						<div class="col-sm-2">
							<s:textfield cssClass="form-control" id="id"
								name="funcionarioVo.idFuncionario" readonly="true" />
						</div>
					</div>

					<div class="row align-items-center mt-3">
						<label for="nome" class="col-sm-1 col-form-label text-center">Nome:
						</label>

						<div class="col-sm-5">
							<s:textfield cssClass="form-control" id="nome"
								name="funcionarioVo.nome" />
						</div>
					</div>
				</div>

				<div class="card-footer">
					<div class="form-row">
						<button style="background-color: #3f8c97; border: none" class="btn btn-primary col-sm-4 offset-sm-1">
							Salvar</button>
						<button type="reset"
							class="btn btn-outline-dark  col-sm-4 offset-sm-2">Limpar
							Formulário</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
