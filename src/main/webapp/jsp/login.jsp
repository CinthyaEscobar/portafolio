<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Custom fonts for this template-->
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-6 col-lg-6 col-md-6">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<c:if test="${ msg != null }">
								<c:out value="${ msg }" />
								<c:remove var="msg" />
							</c:if>
							<div class="col-lg-12">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Bienvenido</h1>
									</div>
									<form action="/login" method="post" class="user">
										<div class="form-group">
											<input name="username" type="email"
												class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												placeholder="Correo" required="required">
										</div>
										<div class="form-group">
											<input name="password" type="password"
												class="form-control form-control-user"
												id="exampleInputPassword" placeholder="Contraseña"
												required="required">
										</div>
										<div class="form-group">
											<div class="small">
												<input type="hidden" name="${ _csrf.parameterName}"
													value="${ _csrf.token }">
												<!--<input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>-->
												<c:if test="${ param.error != null }">
													<p>Datos Incorrectos</p>
												</c:if>
											</div>
										</div>
										<input type="submit" value="Ingresar"
											class="btn btn-primary btn-user btn-block">

										<hr>
									</form>
									<hr>

									<div class="text-center">
										<a class="small" href="/registro">Regístrese aquí</a> <br>
										<a class="small" href="/">Volver a inicio</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/js/sb-admin-2.min.js"></script>

</body>
</html>