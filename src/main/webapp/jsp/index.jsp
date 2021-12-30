<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Custom fonts for this template -->
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<!-- Custom styles for this page -->
<link href="/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<title>Arriendos de Temporada</title>
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->


		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Divider -->
		<hr class="sidebar-divider">


		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Page Wrapper -->
			<div id="content">
				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<!-- Topbar Navbar -->

					<div class="topbar-divider d-none d-sm-block">
						<ul class="navbar-nav ml-auto">
							<sec:authorize access="!isAuthenticated()">
								<div>
									<button class="btn btn-primary"
										style="margin: auto; display: block"
										onclick="location.href='/login';">Login</button>
								</div>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<!-- Nav Item - User Information -->
								<li class="nav-item dropdown no-arrow"><a
									class="nav-link dropdown-toggle" href="#" id="userDropdown"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
										<div>
											<sec:authentication property="principal.nombre" />
											<sec:authentication property="principal.apellidoP" />
											<sec:authentication property="principal.apellidoM" />
											<form action="/logout" method="post">
												<input type="hidden" name="${ _csrf.parameterName }"
													value="${ _csrf.token }">
											</form>
										</div> <img class="img-profile rounded-circle"
										src="img/undraw_profile.svg">
								</a> <!-- Dropdown - User Information -->
									<div
										class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="#"> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
											Perfil
										</a> <a class="dropdown-item"
											href='/resumen?idCliente=<sec:authentication property="principal.id" />'>
											<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
											Reservas
										</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#" data-toggle="modal"
											data-target="#logoutModal"> <i
											class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
											Logout
										</a>
									</div></li>
							</sec:authorize>
						</ul>
					</div>
				</nav>

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div class="card shadow">
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<form action="/index/buscar" method="post" class="user">
											<div class="form-group row">
												<div class="col">
													<label for="sel1">Región</label> <select name="region"
														class="form-select form-control" id="sel1"
														onchange="cargarDos(this.value)">
														<option value="0">Cualquiera</option>
														<c:forEach items="${ region }" var="re">
															<c:choose>
																<c:when test="${ region_old != null }">
																	<c:choose>
																		<c:when
																			test="${ re.idRe == Long.parseLong(region_old) }">
																			<option value="${ re.idRe }" selected>
																				<c:out value="${ re.strDescripcion }" />
																			</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${ re.idRe }">
																				<c:out value="${ re.strDescripcion }" />
																			</option>
																		</c:otherwise>
																	</c:choose>
																</c:when>
																<c:otherwise>
																	<option value="${ re.idRe }">
																		<c:out value="${ re.strDescripcion }" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
												<div class="col">
													<label for="sel2">Provincia</label> <select
														name="provincia" class="form-select form-control"
														id="sel2" onchange="cargarTres(this.value)">
														<option value="0" data-option="0">Cualquiera</option>
														<option value="0" data-option="1">Cualquiera</option>
														<option value="0" data-option="2">Cualquiera</option>
														<option value="0" data-option="3">Cualquiera</option>
														<option value="0" data-option="4">Cualquiera</option>
														<option value="0" data-option="5">Cualquiera</option>
														<option value="0" data-option="6">Cualquiera</option>
														<option value="0" data-option="7">Cualquiera</option>
														<option value="0" data-option="8">Cualquiera</option>
														<option value="0" data-option="9">Cualquiera</option>
														<option value="0" data-option="10">Cualquiera</option>
														<option value="0" data-option="11">Cualquiera</option>
														<option value="0" data-option="12">Cualquiera</option>
														<option value="0" data-option="13">Cualquiera</option>
														<option value="0" data-option="14">Cualquiera</option>
														<option value="0" data-option="15">Cualquiera</option>
														<c:forEach items="${ provincia  }" var="pr">
															<c:choose>
																<c:when test="${ provincia_old != null }">
																	<c:choose>
																		<c:when
																			test="${ Long.parseLong(provincia_old) == pr.idPr }">
																			<option value="${ pr.idPr  }"
																				data-option="${ pr.idRe.idRe}" selected>
																				<c:out value="${ pr.strDescripcion }" />
																			</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${ pr.idPr  }"
																				data-option="${ pr.idRe.idRe}">
																				<c:out value="${ pr.strDescripcion }" />
																			</option>
																		</c:otherwise>
																	</c:choose>
																</c:when>
																<c:otherwise>
																	<option value="${ pr.idPr  }"
																		data-option="${ pr.idRe.idRe}">
																		<c:out value="${ pr.strDescripcion }" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
												<div class="col">
													<label for="sel3">Comuna</label> <select name="comuna"
														class="form-select form-control" id="sel3">
														<option value="0" data-option="0">Cualquiera</option>
														<option value='0' data-option='1'>Cualquiera</option>
														<option value='0' data-option='2'>Cualquiera</option>
														<option value='0' data-option='3'>Cualquiera</option>
														<option value='0' data-option='4'>Cualquiera</option>
														<option value='0' data-option='5'>Cualquiera</option>
														<option value='0' data-option='6'>Cualquiera</option>
														<option value='0' data-option='7'>Cualquiera</option>
														<option value='0' data-option='8'>Cualquiera</option>
														<option value='0' data-option='9'>Cualquiera</option>
														<option value='0' data-option='10'>Cualquiera</option>
														<option value='0' data-option='11'>Cualquiera</option>
														<option value='0' data-option='12'>Cualquiera</option>
														<option value='0' data-option='13'>Cualquiera</option>
														<option value='0' data-option='14'>Cualquiera</option>
														<option value='0' data-option='15'>Cualquiera</option>
														<option value='0' data-option='16'>Cualquiera</option>
														<option value='0' data-option='17'>Cualquiera</option>
														<option value='0' data-option='18'>Cualquiera</option>
														<option value='0' data-option='19'>Cualquiera</option>
														<option value='0' data-option='20'>Cualquiera</option>
														<option value='0' data-option='21'>Cualquiera</option>
														<option value='0' data-option='22'>Cualquiera</option>
														<option value='0' data-option='23'>Cualquiera</option>
														<option value='0' data-option='24'>Cualquiera</option>
														<option value='0' data-option='25'>Cualquiera</option>
														<option value='0' data-option='26'>Cualquiera</option>
														<option value='0' data-option='27'>Cualquiera</option>
														<option value='0' data-option='28'>Cualquiera</option>
														<option value='0' data-option='29'>Cualquiera</option>
														<option value='0' data-option='30'>Cualquiera</option>
														<option value='0' data-option='31'>Cualquiera</option>
														<option value='0' data-option='32'>Cualquiera</option>
														<option value='0' data-option='33'>Cualquiera</option>
														<option value='0' data-option='34'>Cualquiera</option>
														<option value='0' data-option='35'>Cualquiera</option>
														<option value='0' data-option='36'>Cualquiera</option>
														<option value='0' data-option='37'>Cualquiera</option>
														<option value='0' data-option='38'>Cualquiera</option>
														<option value='0' data-option='39'>Cualquiera</option>
														<option value='0' data-option='40'>Cualquiera</option>
														<option value='0' data-option='41'>Cualquiera</option>
														<option value='0' data-option='42'>Cualquiera</option>
														<option value='0' data-option='43'>Cualquiera</option>
														<option value='0' data-option='44'>Cualquiera</option>
														<option value='0' data-option='45'>Cualquiera</option>
														<option value='0' data-option='46'>Cualquiera</option>
														<option value='0' data-option='47'>Cualquiera</option>
														<option value='0' data-option='48'>Cualquiera</option>
														<option value='0' data-option='49'>Cualquiera</option>
														<option value='0' data-option='50'>Cualquiera</option>
														<option value='0' data-option='51'>Cualquiera</option>
														<option value='0' data-option='52'>Cualquiera</option>
														<option value='0' data-option='53'>Cualquiera</option>
														<option value='0' data-option='54'>Cualquiera</option>
														<c:forEach items="${ comuna  }" var="co">
															<c:choose>
																<c:when test="${ comuna_old != null }">
																	<c:choose>
																		<c:when
																			test="${ Long.parseLong(comuna_old) ==  co.idCo }">
																			<option value="${ co.idCo  }"
																				data-option="${ co.idPr.idPr}" selected>
																				<c:out value="${ co.strDescripcion }" />
																			</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${ co.idCo  }"
																				data-option="${ co.idPr.idPr}">
																				<c:out value="${ co.strDescripcion }" />
																			</option>
																		</c:otherwise>
																	</c:choose>
																</c:when>
																<c:otherwise>
																	<option value="${ co.idCo  }"
																		data-option="${ co.idPr.idPr}">
																		<c:out value="${ co.strDescripcion }" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
												<div class="col">
													<label for="exampleFormControlTextarea1">Desde</label>
													<c:choose>
														<c:when test="${ desde_old != null }">
															<input type="date" placeholder="Fecha" name="desde"
																required class="form-control form-control-user"
																id="fecha_desde" value="${ desde_old }">
														</c:when>
														<c:otherwise>
															<input type="date" placeholder="Fecha" name="desde"
																id="fecha_desde" required
																class="form-control form-control-user">
														</c:otherwise>
													</c:choose>

												</div>
												<div class="col">
													<label for="exampleFormControlTextarea1">Hasta</label>
													<c:choose>
														<c:when test="${ hasta_old != null }">
															<input type="date" placeholder="Fecha" name="hasta"
																required class="form-control form-control-user"
																id="fecha_hasta" value="${ hasta_old }">
														</c:when>
														<c:otherwise>
															<input type="date" placeholder="Fecha" name="hasta"
																id="fecha_hasta" required
																class="form-control form-control-user">
														</c:otherwise>
													</c:choose>
												</div>
												<div class="col">
													<input type="submit" value="Buscar"
														class="btn btn-primary btn-user btn-block">
												</div>

											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br> <br>
					<div class="row">
						<div class="col-12 align-self-center">
							<div
								class="row mx-auto justify-content-center align-items-center flex-column">
								<c:if test="${ lista != null }">
									<c:forEach items="${ lista }" var="de">
										<div class="col-lg-8">
											<!-- Basic Card Example -->
											<div class="card shadow mb-4">
												<div class="card-header py-3">
													<h6 class="m-0 font-weight-bold text-primary">
														<c:out
															value="${ de.idEdificio.nombre  } dpto # ${ de.numero }" />
													</h6>
												</div>
												<div class="card-body">
													<div class="row">
														<td><c:if test="${ de.foto!= null }">
																<img id="profileImage" alt="preview"
																	src="data:image/jpg;base64, ${ de.getImg() }"
																	width="170" height="170">
															</c:if></td>
														<div class="col-lg-8">
															<p>
																<c:out value="${ de.descripcion }" />
															</p>
														</div>
														<div class="col-lg-2">
															<div>Precio día</div>
															<div>
																$
																<c:out value="${de.tarifa }" />
															</div>
															<br>
															<div>
																<form action="/reserva" method="post">
																	<input type="hidden" name="idDepto"
																		value="${ de.idDepartamento }"> <input
																		type="hidden" name="desde" value="${ desde_old }">
																	<input type="hidden" name="hasta"
																		value="${ hasta_old }"> <input type="submit"
																		value="Reservar">
																</form>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</c:if>
								<c:if test="${ lista.size() == 0 }">
									<div class="col-lg-8">
										<!-- Basic Card Example -->
										<div class="card shadow mb-4">
											<div class="card-header py-3"></div>
											<div class="card-body">
												<div class="row">
													<p>Sin Departamentos disponible en el área</p>
												</div>

											</div>
											<div id="demo" class="carousel slide" data-ride="carousel">

												<!-- Indicators -->
												<ul class="carousel-indicators">
													<li data-target="#demo" data-slide-to="0" class="active"></li>
													<li data-target="#demo" data-slide-to="1"></li>
													<li data-target="#demo" data-slide-to="2"></li>
												</ul>

												<!-- The slideshow -->
												<div class="carousel-inner">
													<div class="carousel-item active">
														<img src="carousel/depa/25depa1.jpg" alt="Los Angeles">
													</div>
													<div class="carousel-item">
														<img src="carousel/depa/depa2.jpg" alt="Chicago">
													</div>
													<div class="carousel-item">
														<img src="carousel/depa/depa3.jpg" alt="New York">
													</div>
												</div>

												<!-- Left and right controls -->
												<a class="carousel-control-prev" href="#demo"
													data-slide="prev"> <span
													class="carousel-control-prev-icon"></span>
												</a> <a class="carousel-control-next" href="#demo"
													data-slide="next"> <span
													class="carousel-control-next-icon"></span>
												</a>

											</div>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="footer fixed-bottom container">
				<div class="fixed-bottom">
					<div class="copyright text-center my-auto">
						<hr>
						<p>Arriendos de Temporada 2021</p>
					</div>
				</div>
			</footer>
			<!-- end Footer-->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	</div>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<sec:authorize access="isAuthenticated()">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">¿Listo para
							salir?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">¿Está seguro que quiere cerrar
						sesión?</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancelar</button>
						<sec:authorize access="isAuthenticated()">
							<form action="/logout" method="post">
								<input type="hidden" name="${ _csrf.parameterName }"
									value="${ _csrf.token }">
								<button class="btn btn-primary">Cerrar Sesión</button>
							</form>
						</sec:authorize>
					</div>
				</div>
			</div>
		</sec:authorize>
	</div>


	<!-- Bootstrap core JavaScript-->
	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/js/demo/datatables-demo.js"></script>
	<!-- combo -->
	<script src="/js/combo_main.js"></script>

	<script type="text/javascript">
		$(document).ready(
				function() {

					const fec = Date.now();
					const today = new Date(fec);

					$("#fecha_desde").attr(
							{
								"min" : today.getFullYear()
										+ "-"
										+ (today.getMonth() + 1)
										+ "-"
										+ (today.getDate() < 10 ? "0"
												+ today.getDate() : today
												.getDate())
							});
					$("#fecha_hasta").attr(
							{
								"min" : today.getFullYear()
										+ "-"
										+ (today.getMonth() + 1)
										+ "-"
										+ (today.getDate() < 10 ? "0"
												+ today.getDate() : today
												.getDate())
							});

					$("#fecha_desde").change(function() {
						var res = $(this).val();
						//console.log(res);			
						$("#fecha_hasta").attr({
							"min" : res
						});
					});
				});
	</script>
</body>

</html>