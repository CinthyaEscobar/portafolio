<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
<link rel="stylesheet"
	href="/https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<title>Arriendos de Temporada</title>
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->

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
									<button onclick="location.href='/login';">Login</button>
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
										src="/img/undraw_profile.svg">
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

					<div class="col-lg-8 mx-auto text-center">
						<h1 class="display-9">SELECCIÓN DE SERVICIOS Y DETALLE PAGO</h1>
					</div>

					<!-- Page Heading -->
					<div class="row d-flex justify-content-center">

						<div class="w-50 mx-auto">

							<div class="row">

								<div class="col-lg-12">
									<div class="p-5">
										<div class="card">
											<div class="row">
												<div class="col">
													<c:if test="${ depto.foto!= null }">
														<img id="profileImage" alt="preview"
															src="data:image/jpg;base64, ${ depto.getImg() }"
															width="330" height="330">
													</c:if>
												</div>
												<div class="col">
													<br> <br> <br>
													<h6>
														<c:out
															value="${ depto.idEdificio.nombre  } dpto # ${ depto.numero }" />
													</h6>
													<p>
														<c:out value="${ de.descripcion }" />
													</p>
													Caracteristicas
													<ul>
														<c:forEach items="${ items }" var="item">
															<li><c:out value="${ item.nombre }" /></li>
														</c:forEach>
													</ul>
												</div>
											</div>

											<hr />
											<div class="row justify-content-center">
												<form action="/reserva/reservar" method="post">
													<div class="col">
														<div class="row justify-content-center">
															<h6>Acompañantes</h6>
															<div>
																<input type="button" value="Añadir acompañante" id="add"
																	onclick="generar()">
															</div>
														</div>
														<br>
														<div class="row justify-content-center">
															<div id="cuerpo"></div>
														</div>
														<br>
														<div class="col">
															<input type="checkbox" name="chkTransporte"
																id="chkTransporte" onclick="activar()"> <label
																for="chkTransporte">Transporte</label>
														</div>
														<div class="col">
															<select name="transporte" disabled="disabled"
																id="cbTransporte" onchange="obtenerPrecioTransporte()">
																<option selected disabled>Seleccionar</option>
																<c:forEach items="${ transportes }" var="t">
																	<option value="${t.idTransporte }">
																		<c:out value="${ t.idVehiculo.marca }" />
																		<c:out value="${ t.idVehiculo.modelo }" />
																		<c:out value="$ ${ t.precio }" />
																	</option>
																</c:forEach>
															</select>
														</div>
														<div class="col">
															<br>
														</div>
														<div class="col">
															<h6>Tours Disponibles</h6>
															<c:forEach items="${ tours }" var="tour"
																varStatus="cuenta">
																<div class="card shadow ">
																	<div class="card-body">
																		<div class="row">
																			<div class="col">
																				<input type="checkbox" name="chkTour"
																					value="${ tour.idTour }" id="tour${ cuenta.count}"
																					onclick="sumarTour(${ tour.precio },${ cuenta.count})">
																			</div>
																			<div class="col">
																				<c:if test="${ tour.foto!= null }">
																					<img id="profileImage" alt="preview"
																						src="data:image/jpg;base64, ${ tour.getImg() }"
																						width="200" height="200">
																				</c:if>
																			</div>
																			<div class="col">
																				<p>
																					<c:out value="${ tour.descripcion }" />
																				</p>
																			</div>
																			<div class="col">
																				<div class="row">
																					<div class="col">
																						<p>
																							<c:out
																								value="${ tour.idDireccion.idCo.strDescripcion }" />
																						</p>
																						<p>
																							Fecha:
																							<c:out value="${ tour.fecha }" />
																						</p>
																						<p>
																							Hora:
																							<c:out value="${ tour.horaComienzo }" />
																						</p>
																					</div>
																					<div class="col">
																						<p>
																							$
																							<c:out value="${ tour.precio }" />
																						</p>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</c:forEach>
														</div>
													</div>

													<hr />

													<div class="col-lg-8 mx-auto text-center">
														<div>
															<div>Resumen</div>
															<br>
															<div>
																Desde:
																<c:out value="${ desde }" />
															</div>
															<div>
																Hasta:
																<c:out value="${ hasta }" />
															</div>
															<div>
																Total días:
																<c:out value="${ dias }" />
															</div>
															<div>
																Precio Departamento:
																<c:out value="${ depto.tarifa }" />
																x día
															</div>
															<div>
																Precio total Departamento:
																<c:out value="$ ${ total }" />
															</div>
															<input type="hidden" value="${ total }" id="totalDpto">
															<div>
																Precio transporte: $<span id="transporteTotal"></span>
															</div>
															<div>
																Precio Tours: $<span id="tourTotal"></span>
															</div>
															<div>
																Prepago reserva:
																<c:out value="${ depto.porcentajeReserva }%" />
															</div>
															<input type="hidden" value="${ depto.porcentajeReserva }"
																id="porcentaje">

														</div>
														<br> <br>
														<div class="col">
															<div>Total Reserva:</div>

															<div>
																$<span id="totalReserva"></span>
															</div>
															<br>
															<div>Prepago mínimo:</div>
															<div>
																$<span id="prepago"></span>
															</div>
														</div>

													</div>

													<br> <input type="hidden"
														value="${ depto.idDepartamento }" name="idDpto"> <input
														type="hidden" value="${ desde }" name="desde"> <input
														type="hidden" value="${ hasta }" name="hasta"> <input
														type="hidden" value="" id="total_final" name="total_final">
													<input type="hidden" value="" id="total_prepago"
														name="total_prepago"> <input type="hidden"
														value="<sec:authentication property="principal.id" />"
														name="idCliente">

													<div class="container py-5">
														<hr />
														<!-- For demo purpose -->
														<div class="row mb-4">

															<div class="col-lg-8 mx-auto text-center">
																<h1 class="display-6">Continue con su pago para
																	reservar</h1>
															</div>
														</div>
														<!-- End -->
														<div class="row">
															<div class="col-lg-8 mx-auto">
																<div class="card ">
																	<div class="card-header">
																		<div class="bg-white shadow-sm pt-4 pl-2 pr-2 pb-2">
																			<!-- Credit card form tabs -->
																			<ul role="tablist"
																				class="nav bg-light nav-pills rounded nav-fill mb-3">
																				<li class="nav-item"><a data-toggle="pill"
																					href="#credit-card" class="nav-link active "> <i
																						class="fas fa-credit-card mr-2"></i> Tarjeta de
																						crédito
																				</a></li>

																				<!--  <li class="nav-item"> <a data-toggle="pill" href="#net-banking" class="nav-link "> <i class="fas fa-mobile-alt mr-2"></i> Banco en línea </a> </li>-->
																			</ul>
																		</div>
																		<!-- End -->
																		<!-- Credit card form content -->
																		<div class="tab-content">
																			<!-- credit card info-->

																			<div id="credit-card"
																				class="tab-pane fade show active pt-3">
																				<form role="form" onsubmit="event.preventDefault()">
																					<div class="form-group">
																						<label for="username">
																							<h6>Propietario Tarjeta</h6>
																						</label> <input type="text" name="username"
																							placeholder="Nombre propietario tarjeta" required
																							class="form-control ">
																					</div>
																					<div class="form-group">
																						<label for="cardNumber">
																							<h6>Número de tarjeta</h6>
																						</label>
																						<div class="input-group">
																							<input type="text" name="cardNumber"
																								placeholder="Número de tarjeta válido"
																								class="form-control " required>
																							<div class="input-group-append">
																								<span class="input-group-text text-muted">
																									<i class="fab fa-cc-visa mx-1"></i> <i
																									class="fab fa-cc-mastercard mx-1"></i> <i
																									class="fab fa-cc-amex mx-1"></i>
																								</span>
																							</div>
																						</div>
																					</div>
																					<div class="row">
																						<div class="col-sm-8">
																							<div class="form-group">
																								<label><span class="hidden-xs">
																										<h6>Fecha de vencimiento</h6>
																								</span></label>
																								<div class="input-group">
																									<input type="number" placeholder="MM" name=""
																										class="form-control" required> <input
																										type="number" placeholder="YY" name=""
																										class="form-control" required>
																								</div>
																							</div>
																						</div>
																						<div class="col-sm-4">
																							<div class="form-group mb-4">
																								<label data-toggle="tooltip"
																									title="El grupo de 3 o 4 números situado en el reverso de la tarjeta de crédito">
																									<h6>
																										CVV <i class="fa fa-question-circle d-inline"></i>
																									</h6>
																								</label> <input type="text" required
																									class="form-control">
																							</div>
																						</div>
																					</div>
																					<div class="row justify-content-center">
																						<input type="submit" value="Reservar">
																					</div>


																				</form>
																			</div>

																			<!-- bank transfer info -->
																			<!--   <div id="net-banking" class="tab-pane fade pt-3">
                        <div class="form-group "> <label for="Select Your Bank">
                                <h6>Seleccione su banco</h6>
                            </label> <select class="form-control" id="ccmonth">
                                <option value="" selected disabled>--Por favor seleccione su banco--</option>
                                <option>Banco Estado</option>
                                <option>Santander</option>
                                <option>Scotiabank</option>
                                <option>Bci</option>
                           
                            </select> </div>
                        <div class="form-group">
                            <p> <button type="button" class="btn btn-primary "><i class="fas fa-mobile-alt mr-2"></i> Proceder al pago</button> </p>
                        </div>
                        <p class="text-muted">Nota:  UwU </p>
                    </div> <!-- End -->
																			<!-- End -->
																		</div>
																		<!-- End -->



																	</div>
																</div>
															</div>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
						<div class="text-center">
					<a class="medium" href="/">Volver a inicio</a>
				</div>
					<!-- /.container-fluid -->
				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Arriendos de Temporada 2021</span>
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
	<script src="/js/tools.js"></script>

</body>

</html>