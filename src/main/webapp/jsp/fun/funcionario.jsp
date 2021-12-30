<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Custom fonts for this template -->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
<title>Funcionario</title>
</head>
<body id="page-top" class="bg-gradient-primary">
 	<!-- Page Wrapper -->
	<div id="wrapper" >
		<!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index/funcionario">
                <div class="sidebar-brand-icon">
                  <i class="fas fa-user-circle"></i>

                </div>
                <div class="sidebar-brand-text mx-3">Funcionario</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">            

            <!-- Divider -->
            <hr class="sidebar-divider">
            

            <!-- Nav items -->
            <li class="nav-item">
                <a class="nav-link" href="/index/funcionario" aria-expanded="true" aria-controls="collapseTwo">                   
                    <span>Reservas</span>
                </a>               
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
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                        <sec:authentication property="principal.nombre"/>
                                        <sec:authentication property="principal.apellidoP"/>
                                        <sec:authentication property="principal.apellidoM"/>
                                    </span>
                                <img class="img-profile rounded-circle"
                                    src="/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Perfil
                                </a>  
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>

                <!-- Begin Page Content -->
                <div class="container-fluid">                   
                    <!-- Page Heading -->
					<div class="card shadow">
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="table-responsive">
                                			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                			<thead>
												<th>Dpto </th>
												<th>Cliente</th>
												<th>Fecha Ingreso</th>
												<th>Fecha Salida </th>
												<th>Pagos </th>
												<th>Acción</th>	
											</thead>
											<tbody>
												<c:forEach items="${ reservas }" var="r">
													<tr>
														<td>
															<c:out value="Departamento # ${ r.idDepartamento.numero }" />
														</td>
														<td>
															<c:out value="Rut: ${ r.idCliente.idCuenta.rut }" /><br>
															<c:out value="Nombre: ${ r.idCliente.idCuenta.nombre } ${ r.idCliente.idCuenta.apellidop } ${ r.idCliente.idCuenta.apellidom }" />
														</td>
														<td>
															<c:out value="${ r.fechaIngreso }" />
														</td>
														<td>
															<c:out value="${ r.fechaSalida}" />
														</td>
														<td>
															Prepago: $<c:out value="${ r.pagoReserva}" />	<br>														
															Pago pendiente $<c:out value="${ r.totalPagar - r.pagoReserva }" />			<br>												
															Reserva Total $<c:out value="${ r.totalPagar}" />
														</td>
														<td>
															<c:choose>
																	<c:when test="${ r.idReservaestado.idReservaestado  == 1}">
																		<div>
																			Reservada
																		</div>
																		<form action="/detallecheckin" method="post">
																			<input type="hidden" value="${ r.idReserva }" name="idReserva">
																			<input type="submit" value="Check-in">
																		</form>																	
																	</c:when>
																	<c:when test="${ r.idReservaestado.idReservaestado  == 2}">
																		<div>
																			Check-in
																		</div>
																		<form action="/detallecheckout" method="post">
																			<input type="hidden" value="${ r.idReserva }" name="idReserva">
																			<input type="submit" value="Check-out">
																		</form>	
																	</c:when>
																	<c:when test="${ r.idReservaestado.idReservaestado  == 3}">
																		<div>
																			Check-out
																		</div>															
																	</c:when>																
															</c:choose>	
														</td>
													</tr>	
												</c:forEach>
											</tbody>
                                			</table>
                                		</div>										
									</div>
								</div>
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
     <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿Listo para salir?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">¿Está seguro que quiere cerrar sesión?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
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