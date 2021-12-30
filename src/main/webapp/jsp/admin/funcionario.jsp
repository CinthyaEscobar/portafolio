<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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

<title>Admin</title>
</head>
<body id="page-top" class="bg-gradient-primary">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin">
				<div class="sidebar-brand-icon ">
					<i class="fas fa-hotel"></i>

				</div>
				<div class="sidebar-brand-text mx-3">
					Admin
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Divider -->
			<hr class="sidebar-divider">


			<!-- Nav items -->
			<li class="nav-item"><a class="nav-link" href="/edificio"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Edificios</span>
			</a></li>

			<!-- Nav items -->
			<li class="nav-item">
                <a class="nav-link" href="/departamento" aria-expanded="true" aria-controls="collapseOne" data-toggle="collapse" data-target="#collapseOne">                  
                    <span>Departamentos</span>
                </a>  
                 <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionSidebar">
                   	 <div class="bg-white py-2 collapse-inner rounded">
                   	  	<a class="collapse-item" href="/departamento">Departamento</a>
                        <h6 class="collapse-header">Mantenciones:</h6>
                        <a class="collapse-item" href="/mantencion">Mantención</a>
                        <a class="collapse-item" href="/item">Items</a>
                        
                    </div>
                </div>           
            </li>
			
			<!-- Nav items -->
            <li class="nav-item">
                <a class="nav-link" href="/tour" aria-expanded="true" aria-controls="collapseTwo">                   
                    <span>Tours</span>
                </a>               
            </li>

            <!-- Nav items -->
            <li class="nav-item">
				<a class="nav-link collapsed" href="#"	aria-expanded="true" aria-controls="collapseTwo" data-toggle="collapse" data-target="#collapseTwo">
					<span>Transporte</span>
				</a>				
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                   	 <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Transportes:</h6>
                        <a class="collapse-item" href="/transporte">Transportes</a>
                        <a class="collapse-item" href="/conductor">Conductores</a>
                        <a class="collapse-item" href="/vehiculo">Vehículos</a>
                    </div>
                </div>					
			</li>
			<!-- Nav items -->
			    <li class="nav-item">
               <a class="nav-link collapsed" href="#"	aria-expanded="true" aria-controls="collapseFour" data-toggle="collapse" data-target="#collapseFour">
					<span>Informes</span>
				</a>	
				<div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionSidebar">
                   	 <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Ver informes :</h6>
                        <a class="collapse-item" href="/informe">Departamentos</a>
                        <a class="collapse-item" href="/informeDos">Zonas</a>
                     
                    </div>
                </div>	             
            </li>
			   <!-- Nav items -->
           <li class="nav-item">
				<a class="nav-link collapsed" href="#"	aria-expanded="true" aria-controls="collapseThree" data-toggle="collapse" data-target="#collapseThree">
					<span>Cuentas</span>
				</a>				
				<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionSidebar">
                   	 <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Crear cuentas:</h6>
                        <a class="collapse-item" href="/funcionario">Funcionarios</a>
                        <a class="collapse-item" href="/administrador">Administradores</a>
                     
                    </div>
                </div>					
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
		</ul>

		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">
								 <sec:authentication property="principal.nombre" /> 
								 <sec:authentication property="principal.apellidoP" /> 
								 <sec:authentication property="principal.apellidoM" />
							</span> <img class="img-profile rounded-circle"
								src="img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Perfil
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->					
					<c:if test="${ msg != null }">
					<div class="col-xl-5 col-md-6 mb-4">
						<div class="card border-left-success shadow h-100 py-2">
                        	<div class="card-body">
                            	<div class="row no-gutters align-items-center">
                                	<div class="col mr-2">                                            
                                    	<div class="h5 mb-0 font-weight-bold text-gray-800">
                                        	<c:out value="${ msg }" />
											<c:remove var="msg" />
										</div>
                                    </div>	                               	
                            	</div>
                        	</div>
                    	</div>
                    </div>		
                        </c:if>			
					<div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Administración de Funcionarios</h6> 
								<div>
									<input type="button" onclick="location.href='/funcionario/agregar'" value="Agregar" class="btn btn-primary">
								</div>							
						</div>                
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">		
								<thead>
									<th>ID </th>
									<th>Correo</th>
									<th>RUT</th>									
									<th>Nombre </th>
									<th>Apellido Materno </th>
									<th>Apellido Paterno</th>
									<th>Teléfono</th>									
									<th>Celular</th>
									<th>Edificio</th>
									<th>Acción</th>
									
									
								</thead>
								<tbody>
									<c:forEach items="${ cuenta }" var="cu">
									<c:if test="${ cu.idTipocuenta.idTipocuenta == 2 }">
										<tr>
											<td>${ cu.idCuenta }</td>
											<td>${ cu.correo }</td>
											<td>${ cu.rut}</td>											
											<td>${ cu.nombre}</td>
											<td>${ cu.apellidop }</td>
											<td>${ cu.apellidom }</td>																						
											<td>
												<c:choose>
													<c:when test="${ cu.telefono != 0 }">
														<c:out value="${ cu.telefono }" />
													</c:when>
													<c:otherwise>
														<c:out value="Sin registro" />
													</c:otherwise>
												</c:choose>
												
											</td>
											<td>${ cu.celular }</td>											
											<c:forEach items="${funcionarios }" var="f">
												<c:if test="${ f.idCuenta.idCuenta == cu.idCuenta }">
												<td><c:out value="${ f.idEdificio.nombre }"></c:out></td>
												</c:if>											
											</c:forEach>
											<td>
												<form action="/funcionario/detalle" method="get">
												<input name="id" type="hidden" value="${ cu.idCuenta}" >	
													<input type="submit" value="Modificar" class="btn btn-info">
												</form>
											</td>
										</tr>
									</c:if>										
									</c:forEach>
								</tbody>		
							</table>
						</div>
					</div>
				</div>
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
			<!-- End of Footer -->
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

</body>

</html>