package com.proyecto.arriendo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.arriendo.details.CustomUserDetails;
import com.proyecto.arriendo.model.Acompanante;
import com.proyecto.arriendo.model.Admin;
import com.proyecto.arriendo.model.CheckIn;
import com.proyecto.arriendo.model.CheckOut;
import com.proyecto.arriendo.model.Cliente;
import com.proyecto.arriendo.model.Comuna;
import com.proyecto.arriendo.model.Conductor;
import com.proyecto.arriendo.model.Cuenta;
import com.proyecto.arriendo.model.Departamento;
import com.proyecto.arriendo.model.Direccion;
import com.proyecto.arriendo.model.Edificio;
import com.proyecto.arriendo.model.Estado;
import com.proyecto.arriendo.model.Funcionario;
import com.proyecto.arriendo.model.Item;
import com.proyecto.arriendo.model.Mantencion;
import com.proyecto.arriendo.model.Reserva;
import com.proyecto.arriendo.model.ReservaEstado;
import com.proyecto.arriendo.model.ReservaTour;
import com.proyecto.arriendo.model.TipoCuenta;
import com.proyecto.arriendo.model.TipoMantencion;
import com.proyecto.arriendo.model.Tour;
import com.proyecto.arriendo.model.Transporte;
import com.proyecto.arriendo.model.Vehiculo;
import com.proyecto.arriendo.service.AcompananteService;
import com.proyecto.arriendo.service.AdminService;
import com.proyecto.arriendo.service.CheckInService;
import com.proyecto.arriendo.service.CheckOutService;
import com.proyecto.arriendo.service.ClienteService;
import com.proyecto.arriendo.service.ComunaService;
import com.proyecto.arriendo.service.ConductorService;
import com.proyecto.arriendo.service.CuentaService;
import com.proyecto.arriendo.service.DepartamentoService;
import com.proyecto.arriendo.service.DireccionService;
import com.proyecto.arriendo.service.EdificioService;
import com.proyecto.arriendo.service.EmailService;
import com.proyecto.arriendo.service.EstadoService;
import com.proyecto.arriendo.service.FiltroProvinciaService;
import com.proyecto.arriendo.service.FuncionarioService;
import com.proyecto.arriendo.service.ItemService;
import com.proyecto.arriendo.service.MantencionService;
import com.proyecto.arriendo.service.ProvinciaService;
import com.proyecto.arriendo.service.RegionService;
import com.proyecto.arriendo.service.ReservaEstadoService;
import com.proyecto.arriendo.service.ReservaService;
import com.proyecto.arriendo.service.ReservaTourService;
import com.proyecto.arriendo.service.TipoCuentaService;
import com.proyecto.arriendo.service.TipoMantencionService;
import com.proyecto.arriendo.service.TourService;
import com.proyecto.arriendo.service.TransporteService;
import com.proyecto.arriendo.service.VehiculoService;
import com.proyecto.arriendo.service.testService;
import com.proyecto.arriendo.util.Utilitario;

@Controller
public class WebController {

	@Autowired
	private RegionService regionServ;
	@Autowired
	private ProvinciaService provinciaServ;
	@Autowired
	private ComunaService comunaServ;
	@Autowired
	private DireccionService direccionServ;
	@Autowired
	private EdificioService edificioServ;
	@Autowired
	private TourService tourServ;
	@Autowired
	private VehiculoService vehiculoServ;
	@Autowired
	private ConductorService conductorServ;
	@Autowired
	private TransporteService transporteServ;
	@Autowired
	private DepartamentoService departamentoServ;
	@Autowired
	private ItemService itemServ;
	@Autowired
	private EstadoService estadoServ;
	@Autowired
	private MantencionService mantencionServ;
	@Autowired
	private TipoMantencionService tipoMantencionServ;
	@Autowired
	private CuentaService cuentaServ;
	@Autowired
	private TipoCuentaService tipoCuentaServ;
	@Autowired
	private AdminService adminServ;
	@Autowired
	private FuncionarioService funcionarioServ;
	@Autowired
	private ClienteService clienteServ;
	@Autowired
	private ReservaTourService reservaTourServ;
	@Autowired
	private ReservaService reservaServ;
	@Autowired
	private AcompananteService acompananteServ;
	@Autowired
	private ReservaEstadoService reservaEstadoServ;
	@Autowired
	private CheckInService checkInSer;
	@Autowired
	private CheckOutService checkOutSer;
	@Autowired
	private testService testServ;
	@Autowired
	private FiltroProvinciaService filtroProvinciaServ;
	@Autowired
	private EmailService emailService;
	
	
	
	// Listar test
		@GetMapping("/informe")
		public String getInforme(Model model) {
			model.addAttribute("informe", testServ.findAll());
			
			return "admin/informe";
		}
		
		// Informe dos
				@GetMapping("/informeDos")
				public String getInformeDos(Model model) {
					model.addAttribute("informe", filtroProvinciaServ.findAll());
					
					return "admin/informeDos";
				}
				
		

	
	//realizar Check-in
	@PostMapping("/generarcheckin")
	public String postGenerarCheckIn(String idReserva, Authentication auth, Model model)
	{
		Reserva r = reservaServ.buscar(Long.parseLong(idReserva));
		r.setIdReservaestado(new ReservaEstado(2));
		reservaServ.modificar(r);
		long idCheckIn = Utilitario.generarId();
		CheckIn checkIn = new CheckIn(idCheckIn, LocalDate.now(), LocalTime.now(), r.getTotalPagar()-r.getPagoReserva());
		checkIn.setIdReserva(r);
		checkInSer.agregar(checkIn);
		return getFuncionario(auth,model);
	}
	
	//Realizar Check-out
	@PostMapping("/generarcheckout")
	public String postGenerarCheckOut(String idReserva, String multa, String desMulta,Authentication auth, Model model) {
		Reserva r = reservaServ.buscar(Long.parseLong(idReserva));
		r.setIdReservaestado(new ReservaEstado(3));
		reservaServ.modificar(r);
		long idCheckOut = Utilitario.generarId();
		int mu = 0;
		if(!multa.isEmpty())
		{
			mu = Integer.parseInt(multa);
		}
		CheckOut checkOut = new CheckOut(idCheckOut, LocalDate.now(), LocalTime.now(), mu, desMulta);		
		checkOut.setIdReserva(r);
		checkOutSer.agregar(checkOut);
		return getFuncionario(auth,model);
	}
	
	///detalle check-out
	@PostMapping("/detallecheckout")
	public String postDetalleCheckOut(String idReserva,Model model)
	{
		Reserva reserva = reservaServ.buscar(Long.parseLong(idReserva));
		List<Item> items = itemServ.buscarPorDepartamento(reserva.getIdDepartamento());
		List<ReservaTour> rTours = reservaTourServ.buscarPorReserva(reserva.getIdReserva());
		model.addAttribute("reserva", reserva);		
		model.addAttribute("items", items);
		model.addAttribute("rTours", rTours);
		return "/fun/detallecheckout";
	}
	
	//detalle check-in
	@PostMapping("/detallecheckin")
	public String postDetalleCheckIn(String idReserva, Model model)
	{
		Reserva reserva = reservaServ.buscar(Long.parseLong(idReserva));
		List<Item> items = itemServ.buscarPorDepartamento(reserva.getIdDepartamento());
		List<ReservaTour> rTours = reservaTourServ.buscarPorReserva(reserva.getIdReserva());
		model.addAttribute("reserva", reserva);		
		model.addAttribute("items", items);
		model.addAttribute("rTours", rTours);
		return "/fun/detallecheckin";
	}
	
	//funcionario
	@GetMapping("/index/funcionario")
	public String getFuncionario(Authentication auth, Model model) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		Funcionario f = funcionarioServ.buscarPorCuenta(cuentaServ.buscar(user.getId()));
		List<Reserva> lista = reservaServ.listarPorFuncionario(f.getIdFuncionario());
		model.addAttribute("reservas", lista);
		return "/fun/funcionario";
	}	
	
	
	//Buscar Departamentos disponibles para reservar
	@PostMapping("/index/buscar")
	public String getDepartamentoBuscar(String region, String provincia, String comuna, String desde, String hasta, Model model)
	{
		if (region.equals("0")) {
			//buscar todas
			//List<Departamento> lista = departamentoServ.buscarTodoDisponibles();			
			List<Departamento> lista = departamentoServ.buscarTodoDisponibles();	
			model.addAttribute("lista",lista);
		} else if(provincia.equals("0")) {
			//buscar Región especifica
			List<Departamento> lista = departamentoServ.buscarTodoDisponiblesPorRegion(Long.parseLong(region));			
			model.addAttribute("lista",lista);
		} else if(comuna.equals("0")) {
			// buscar Provincia especifica
			List<Departamento> lista = departamentoServ.buscarTodoDisponiblesPorProvincia(Long.parseLong(provincia));			
			model.addAttribute("lista",lista);
		} else {
			//buscar Comuna especifica
			List<Departamento> lista = departamentoServ.buscarTodoDisponiblesPorComuna(Long.parseLong(comuna));			
			model.addAttribute("lista",lista);
		}		
		model.addAttribute("region_old", region);
		model.addAttribute("provincia_old", provincia);
		model.addAttribute("comuna_old", comuna);
		model.addAttribute("desde_old", desde);
		model.addAttribute("hasta_old", hasta);
		model = llenarRegiones(model);
		model.addAttribute("path", "/img/depa/");
		return "index";
	}
	
	
	// Reserva
	@PostMapping("/reserva")
	public String getReserva(String idDepto, String desde, String hasta,Model model)
	{
		
		LocalDate d = LocalDate.parse(desde);
		LocalDate h = LocalDate.parse(hasta);
		int dif = Period.between(d, h).getDays();
		Departamento dpto = departamentoServ.buscar(Long.parseLong(idDepto));
		double total = (dpto.getTarifa() * dif);
		double prepago = total * ((double)dpto.getPorcentajeReserva() / 100) ;
		List<Item> items = itemServ.buscarPorDepartamento(dpto);
		
		List<Transporte> transportes = transporteServ.listar();
		List<Tour> tours = tourServ.buscarParaReserva(dpto.getIdEdificio().getIdDireccion().getIdCo().getIdPr().getIdPr(), d.plusDays(1) , h.minusDays(1));		
		
		model.addAttribute("path", "/img/depa/");
		model.addAttribute("depto", dpto);
		model.addAttribute("desde",desde);
		model.addAttribute("hasta",hasta);
		model.addAttribute("dias", dif);
		model.addAttribute("total", Math.round(total));
		model.addAttribute("prepago",  Math.round(prepago));
		model.addAttribute("items",  items);
		model.addAttribute("transportes",transportes);
		model.addAttribute("tours", tours);
		return "reserva";
	}
	
	// Generar Reserva
	@PostMapping("/reserva/reservar")
	public String postGenerarReserva(String idDpto, String[] chkTour, String transporte, String chkTransporte, String[] runAcom, String[] nombreAcom, 
			String desde, String hasta, String total_final, String total_prepago, String idCliente, Model model)
	{
		long idReserva = Utilitario.generarId();
		Reserva reserva = new Reserva(idReserva, LocalDate.parse(desde), LocalDate.parse(hasta), Integer.parseInt(total_prepago), Integer.parseInt(total_final));
		Departamento d = departamentoServ.buscar(Long.parseLong(idDpto));
		reserva.setIdDepartamento(d);
		reserva.setIdReservaestado(new ReservaEstado(1l));
		Cliente c = clienteServ.buscar(Long.parseLong(idCliente));
		reserva.setIdCliente(c);
		if (chkTransporte != null) {
			reserva.setIdTransporte(new Transporte(Long.parseLong(transporte)));
		}
		reservaServ.agregar(reserva);
		if (chkTour != null) {
			List<ReservaTour> tours = new ArrayList<ReservaTour>();
			for(String id : chkTour)
			{
				long idReservaTour = Utilitario.generarId();
				ReservaTour r = new ReservaTour(idReservaTour);
				r.setIdReserva(reserva);
				r.setIdTour(new Tour(Long.parseLong(id)));
				tours.add(r);
				//agregar ReservaTour en BD
				reservaTourServ.agregar(r);
			}
			reserva.setReservaTourList(tours);			
		}
		if(runAcom != null)
		{
			List<Acompanante> acompanantes = new ArrayList<Acompanante>();
			for(int i = 0; i < runAcom.length; i++)
			{
				long idAcompanante = Utilitario.generarId();
				Acompanante acom = new Acompanante(idAcompanante, runAcom[i], nombreAcom[i]);
				acom.setIdReserva(reserva);
				acompanantes.add(acom);
				//agregar Acompanante en BD
				acompananteServ.agregar(acom);				
			}
			
			reserva.setAcompananteList(acompanantes);			
		}
		
		//Guardar Reserva en DB		
		
		String mensaje = String.format("Estimado/a:\r\n"
				+ "\r\n"
				+ "Su reserva n° %d fue realizada exitosamente.\r\n"
				+ "\r\n"
				+ "Departamento: %d, Edificio: %s, Fecha: %s \r\n"
				+ "Total Reserva: $%d\r\n"
				+ "Total Prepago: $%d\r\n"
				+ "Estado: Reservado\r\n"
				,reserva.getIdReserva()
				,d.getNumero()
				,d.getIdEdificio().getNombre()
				,reserva.getFechaIngreso().toString()
				,reserva.getTotalPagar()
				,reserva.getPagoReserva());
				 
		
		emailService.sendEmail(c.getIdCuenta().getCorreo(), "Reserva Realizada", mensaje);
		
		
		model.addAttribute("reservas", reservaServ.listarPorCliente(new Cliente(Long.parseLong(idCliente))));
		return "resumen";
	}
	
	// Resumen Reserva cliente
	@GetMapping("/resumen")
	public String getResumen(String idCliente, Model model)
	{
		model.addAttribute("reservas", reservaServ.listarPorCliente(new Cliente(Long.parseLong(idCliente))));
		return "resumen";
	}
	
	// Cancelar Reserva
	@PostMapping("/cancelarReserva")
	public String PostCancelarReserva(String idCliente,String idReserva, Model model)
	{
		Reserva r = reservaServ.buscar(Long.parseLong(idReserva));
		r.setIdReservaestado(reservaEstadoServ.buscar(4l));
		
		reservaServ.modificar(r);
		List<Reserva> reservas = reservaServ.listarPorCliente(new Cliente(Long.parseLong(idCliente)));
		
		model.addAttribute("reservas", reservas);
		return "resumen";			
	}
	
	// Index
	@GetMapping("/")
	public String getIndex(Authentication auth,Model model) {
		if(auth != null)
		{
			if (auth.getAuthorities().contains(new SimpleGrantedAuthority("1"))) {
				return getAdmin(model);
			}
			else if(auth.getAuthorities().contains(new SimpleGrantedAuthority("2")))
			{
				return getFuncionario(auth,model);
			}
		}		
		model = llenarRegiones(model);
		return "index";
	}

	// Login
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	// admin
	@GetMapping("/admin")
	public String getAdmin(Model model) {
		return getDepartamento(model);
	}

	// Listar Edificios
	@GetMapping("/edificio")
	public String getEdificio(Model model) {
		model.addAttribute("edificios", edificioServ.listar());
		return "admin/edificio";
	}

	// Agregar Edificios - GET
	@GetMapping("/edificio/agregar")
	public String getEdificioAgregar(Model model) {
		model = llenarRegiones(model);
		return "admin/edificioagregar";
	}

	// Detalle Edificio
	@GetMapping("/edificio/detalle")
	public String getEdificioDetalle(@RequestParam String id, Model model) {
		model.addAttribute("edificio", edificioServ.buscar(Long.parseLong(id)));
		model = llenarRegiones(model);
		return "/admin/edificiodetalle";
	}

	// Agregar Edificio - POST
	@PostMapping("/edificio/agregar")
	public String postEdificioAgregar(@RequestParam String comuna, String calle, String numero, String nombre,
			Model model) {
		System.out.println("test");

		try {
			Direccion d = new Direccion(Utilitario.generarId(), calle, Integer.parseInt(numero));
			d.setIdCo(new Comuna(Long.parseLong(comuna)));
			Edificio e = new Edificio(Utilitario.generarId(), nombre, Utilitario.ACTIVO);
			e.setIdDireccion(d);
			direccionServ.agregar(d);
			edificioServ.agregar(e);
			model.addAttribute("msg", "Edificio Agregado Exitosamente");
			model.addAttribute("edificios", edificioServ.listar());
			return "admin/edificio";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model = llenarRegiones(model);
			return "admin/edificio";
		}
	}

	// Actualizar Edificio - POST
	@PostMapping("/edificio/actualizar")
	public String postModificarEdificio(@RequestParam String idEd, String idDi, String comuna, String calle,
			String numero, String nombre, String estado, Model model) {
		try {
			Direccion d = new Direccion(Long.parseLong(idDi), calle, Integer.parseInt(numero));
			d.setIdCo(new Comuna(Long.parseLong(comuna)));
			Edificio e = new Edificio(Long.parseLong(idEd), nombre, Utilitario.ACTIVO);
			e.setIdDireccion(d);
			direccionServ.modificar(d);
			edificioServ.modificar(e);
			model.addAttribute("msg", "Edificio Modificado Exitosamente");
			model.addAttribute("edificios", edificioServ.listar());
			return "admin/edificio";

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return getEdificioDetalle(idEd, model);
		}
	}

	// listarTour
	@GetMapping("/tour")
	public String getTour(Model model) {

		model.addAttribute("tours", tourServ.listar());
		model.addAttribute("path", "/img/tour/");
		return "admin/tour";
	}

	// agregarTour - get
	@GetMapping("/tour/agregar")
	public String getTourAgregar(Model model) {
		model = llenarRegiones(model);
		return "admin/touragregar";
	}

	// agregarTour - post
	@PostMapping("/tour/agregar")
	public String postTourAgregar(@RequestParam String comuna, String calle, String numero, String lugar, String precio,
			String cantidad, String descripcion, String fecha, String comienzo, String termino, MultipartFile foto,
			Model model) throws IOException {

		long id = Utilitario.generarId();
		// NOMBRE FOTO
		//String nombre = String.valueOf(id) + StringUtils.cleanPath(foto.getOriginalFilename());

		Direccion d = new Direccion(Utilitario.generarId(), calle, Integer.parseInt(numero));
		d.setIdCo(new Comuna(Long.parseLong(comuna)));
		direccionServ.agregar(d);
		Tour t = new Tour(id, lugar, descripcion, LocalDate.parse(fecha),
				LocalTime.parse(comienzo.concat(":00"), DateTimeFormatter.ofPattern("HH:mm:ss")),
				LocalTime.parse(termino.concat(":00"), DateTimeFormatter.ofPattern("HH:mm:ss")),
				Integer.parseInt(precio), Integer.parseInt(cantidad), foto.getBytes(), Utilitario.ACTIVO);
		t.setIdDireccion(d);
		tourServ.agregar(t);

		// SUBIR FOTO
		//String dir = Utilitario.PATH + "tour";
		//FileUploadUtil.saveFile(dir, nombre, foto);
		model.addAttribute("msg", "Tour agregado Exitosamente");
		return getTour(model);
	}

	// Tour Detalle
	@GetMapping("/tour/detalle")
	public String getTourDetalle(@RequestParam String id, Model model) {
		model.addAttribute("tour", tourServ.buscar(Long.parseLong(id)));
		model = llenarRegiones(model);
		return "/admin/tourdetalle";
	}

	// Tour Modificar
	@PostMapping("/tour/modificar")
	public String postTourModificar(@RequestParam String comuna, String calle, String numero, String lugar,
			String precio, String cantidad, String descripcion, String fecha, String comienzo, String termino,
			MultipartFile foto, String oldPic, String idDi, String idTo, String activo, Model model)
			throws IOException {

		//String fotoNueva = StringUtils.cleanPath(foto.getOriginalFilename().trim());

		///String nombre = oldPic;

		//if (!fotoNueva.isEmpty()) {
			//nombre = idTo + fotoNueva;
		//}

		Direccion d = new Direccion(Long.parseLong(idDi), calle, Integer.parseInt(numero));
		d.setIdCo(new Comuna(Long.parseLong(comuna)));
		direccionServ.agregar(d);
		Tour t = new Tour(Long.parseLong(idTo), lugar, descripcion, LocalDate.parse(fecha),
				LocalTime.parse(comienzo.concat(":00"), DateTimeFormatter.ofPattern("HH:mm:ss")),
				LocalTime.parse(termino.concat(":00"), DateTimeFormatter.ofPattern("HH:mm:ss")),
				Integer.parseInt(precio), Integer.parseInt(cantidad), foto.getBytes(),
				activo != null ? Utilitario.ACTIVO : Utilitario.INACTIVO);
		byte[] nueva;
		if (foto.getOriginalFilename().isEmpty()) {
			nueva = Base64.getDecoder().decode(oldPic.getBytes());
			t.setFoto(nueva);
		}	
		else
		{
			t.setFoto(foto.getBytes());
		}
		t.setIdDireccion(d);
		tourServ.agregar(t);

		//if (!fotoNueva.isEmpty()) {
			//String dir = Utilitario.PATH + "tour";
			//FileUploadUtil.saveFile(dir, nombre, foto);
		//}

		model.addAttribute("msg", "Tour modificado Exitosamente");
		return getTour(model);
	}

	// listar Vehiculos
	@GetMapping("/vehiculo")
	public String getVehiculo(Model model) {
		model.addAttribute("vehiculos", vehiculoServ.listar());
		return "admin/vehiculo";
	}

	// Agregar vehiculos - get
	@GetMapping("/vehiculo/agregar")
	public String getVehiculoAgregar(Model model) {
		return "admin/vehiculoagregar";
	}

	// Agregar Vehiculo - post
	@PostMapping("/vehiculo/agregar")
	public String postVehiculoAgregar(@RequestParam String patente, String marca, String modelo, String anio,
			Model model) {
		Vehiculo v = new Vehiculo(Utilitario.generarId(), patente, marca, modelo, Integer.parseInt(anio));
		vehiculoServ.agregar(v);
		model.addAttribute("msg", "Vehiculo agregado exitosamente");
		model.addAttribute("vehiculos", vehiculoServ.listar());
		return "admin/vehiculo";

	}

	// Vehiculo Detalle
	@GetMapping("/vehiculo/detalle")
	public String getVehiculoDetalle(@RequestParam String id, Model model) {
		model.addAttribute("vehiculo", vehiculoServ.buscar(Long.parseLong(id)));
		return "/admin/vehiculodetalle";
	}

	// Modificar vehículo
	@PostMapping("vehiculo/modificar")
	public String postVehiculoModificar(@RequestParam String idVe, String patente, String marca, String modelo,
			String anio, Model model) throws IOException {
		Vehiculo v = new Vehiculo(Long.parseLong(idVe), patente, marca, modelo, Integer.parseInt(anio));
		vehiculoServ.agregar(v);
		model.addAttribute("msg", "Vehiculo modificado exitosamente");
		return getVehiculo(model);
	}

	//listar Conductores
	@GetMapping("/conductor")
	public String getConductor(Model model) {
		model.addAttribute("conductores", conductorServ.listar());
		return "admin/conductor";
	}

	// Agregar conductor - get
	@GetMapping("/conductor/agregar")
	public String getConductorAgregar(Model model) {
		return "admin/conductoragregar";
	}

	// Agregar conductor - post
	@PostMapping("/conductor/agregar")
	public String postConductorAgregar(@RequestParam String rut, String nombre, String apellidop, Model model) {
		Conductor c = new Conductor(Utilitario.generarId(), rut, nombre, apellidop);
		conductorServ.agregar(c);
		model.addAttribute("msg", "Conductor agregado exitosamente");
		model.addAttribute("conductores", conductorServ.listar());
		return getConductor(model);

	}

	// Modificar conductor
	@PostMapping("conductor/modificar")
	public String postConductorModificar(@RequestParam String idCo, String rut, String nombre, String apellidop,
			Model model) throws IOException {
		Conductor c = new Conductor(Long.parseLong(idCo), rut, nombre, apellidop);
		conductorServ.modificar(c);
		model.addAttribute("msg", "Conductor modificado exitosamente");
		return getConductor(model);
	}

	// Conductor Detalle
	@GetMapping("/conductor/detalle")
	public String getConductorDetalle(@RequestParam String id, Model model) {
		model.addAttribute("conductor", conductorServ.buscar(Long.parseLong(id)));
		return "/admin/conductordetalle";
	}

	// UTILS
	private Model llenarRegiones(Model model) {
		model.addAttribute("region", regionServ.listar());
		model.addAttribute("provincia", provinciaServ.listar());
		model.addAttribute("comuna", comunaServ.listar());
		return model;
	}

	private Model llenarTransportes(Model model) {
		model.addAttribute("vehiculo", vehiculoServ.listar());
		model.addAttribute("conductor", conductorServ.listar());
		return model;
	}

	private Model llenarDepartamentos(Model model) {
		model.addAttribute("departamento", departamentoServ.listar());
		return model;
	}

	private Model llenarMantenciones(Model model) {
		model.addAttribute("tipomantencion", tipoMantencionServ.listar());
		return model;
	}

	private Model llenarCuentas(Model model) {
		model.addAttribute("tipocuenta", tipoCuentaServ.listar());
		return model;
	}

	// Listar Transportes
	@GetMapping("/transporte")
	public String getTransporte(Model model) {
		model.addAttribute("transporte", transporteServ.listar());
		return "admin/transporte";
	}

	// Agregar transporte- GET
	@GetMapping("/transporte/agregar")
	public String getTransporteAgregar(Model model) {
		model = llenarTransportes(model);
		return "admin/transporteagregar"; 
	}

	// Detalle transporte
	@GetMapping("/transporte/detalle")
	public String getTransporte(@RequestParam String id, Model model) {
		model.addAttribute("transporte", transporteServ.buscar(Long.parseLong(id)));
		model = llenarTransportes(model);
		return "/admin/transportedetalle";
	}

	// Agregar Transporte - POST
	@PostMapping("/transporte/agregar")
	public String postAgregarTransporte(@RequestParam String vehiculo, String conductor, String precio, Model model) {

		try {
			Transporte t = new Transporte(Utilitario.generarId(), "1" ,Integer.parseInt(precio));
			t.setIdConductor(new Conductor(Long.parseLong(conductor)));
			t.setIdVehiculo(new Vehiculo(Long.parseLong(vehiculo)));
			transporteServ.agregar(t);
			model.addAttribute("msg", "Transporte Agregado Exitosamente");
			model.addAttribute("transporte", transporteServ.listar());
			return "admin/transporte";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model = llenarTransportes(model);
			return "admin/agregar";
		}
	}

	// Modificar Transporte - POST
	@PostMapping("/transporte/actualizar")
	public String postModificarTransporte(@RequestParam String id, String vehiculo, String conductor, String precio, Model model) {

		try {
			Transporte t = new Transporte(Long.parseLong(id), "1",Integer.parseInt(precio));
			t.setIdConductor(new Conductor(Long.parseLong(conductor)));
			t.setIdVehiculo(new Vehiculo(Long.parseLong(vehiculo)));
			transporteServ.modificar(t);
			model.addAttribute("msg", "Transporte Modificado Exitosamente");
			model.addAttribute("transporte", transporteServ.listar());
			return "admin/transporte";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model = llenarTransportes(model);
			return "admin/transportedetalle";
		}
	}

	// Listar Departamento
	@GetMapping("/departamento")
	public String getDepartamento(Model model) {
		model.addAttribute("departamento", departamentoServ.listar());			
		return "admin/departamento";
	}

	// Agregar departamento- GET
	@GetMapping("/departamento/agregar")
	public String getDepartamentoAgregar(Model model) {
		model.addAttribute("edificios", edificioServ.listar());
		model.addAttribute("estados", estadoServ.listar());
		return "admin/departamentoagregar";
	}

	// Detalle Departamento
	@GetMapping("/departamento/detalle")
	public String getDepartamentoDetalle(@RequestParam String id, Model model) {
		model.addAttribute("departamento", departamentoServ.buscar(Long.parseLong(id)));
		model.addAttribute("estados", estadoServ.listar());
		model.addAttribute("edificios",edificioServ.listar());
		return "/admin/departamentodetalle";
	}

	// Agregar departamento - post
	@PostMapping("/departamento/agregar")
	public String postDepartamentoAgregar(@RequestParam String numero, String piso, String tarifa,
			String porcentajeReserva, String descripcion, String edificio, MultipartFile foto, Model model)
			throws IOException {

		long id = Utilitario.generarId();
		// NOMBRE FOTO
		//String nombre = String.valueOf(id) + StringUtils.cleanPath(foto.getOriginalFilename());

		Departamento d = new Departamento(id, Integer.parseInt(numero), Integer.parseInt(piso),
				Integer.parseInt(tarifa), Integer.parseInt(porcentajeReserva), descripcion, Utilitario.ACTIVO, foto.getBytes());
		d.setIdEstado(new Estado(3l));
		d.setIdEdificio(new Edificio(Long.parseLong(edificio)));
		departamentoServ.Agregar(d);

		// SUBIR FOTO
		//String dir = Utilitario.PATH + "depa";
		//FileUploadUtil.saveFile(dir, nombre, foto);
		model.addAttribute("msg", "Departamento agregado exitosamente");
		model.addAttribute("departamento", departamentoServ.listar());
		return getDepartamento(model);

	}

	// Modificar Departamento
	@PostMapping("departamento/modificar")
	public String postDepartamentoModificar(@RequestParam String idDe, String idEd, String idEs, String numero,
			String piso, String tarifa, String porcentajeReserva, String descripcion, String edificio, String estado, String activo,
			MultipartFile foto, String oldPic, Model model) throws IOException {

		///String fotoNueva = StringUtils.cleanPath(foto.getOriginalFilename().trim());
		//String nombre = oldPic;
		Departamento d = new Departamento(Long.parseLong(idDe), Integer.parseInt(numero), Integer.parseInt(piso),
				Integer.parseInt(tarifa), Integer.parseInt(porcentajeReserva), descripcion,
				activo != null ? Utilitario.ACTIVO : Utilitario.INACTIVO);
		byte[] nueva;
		if (foto.getOriginalFilename().isEmpty()) {
			nueva = Base64.getDecoder().decode(oldPic.getBytes());
			d.setFoto(nueva);
		}	
		else
		{
			d.setFoto(foto.getBytes());
		}
				
		d.setIdEdificio(new Edificio(Long.parseLong(edificio)));
		d.setIdEstado(new Estado(Long.parseLong(estado)));
		departamentoServ.Modificar(d);

		/**if (!fotoNueva.isEmpty()) {
			String dir = Utilitario.PATH + "depa";
			FileUploadUtil.saveFile(dir, nombre, foto);
		}*/

		model.addAttribute("msg", "Departamento modificado exitosamente");
		return getDepartamento(model);
	}

	// Listar Item
	@GetMapping("/item")
	public String getItem(Model model) {
		model.addAttribute("item", itemServ.listar());
		return "admin/item";
	}

	// Agregar item- GET
	@GetMapping("/item/agregar")
	public String getItemAgregar(Model model) {
		model = llenarDepartamentos(model);
		return "admin/itemagregar";
	}

	// Detalle item
	@GetMapping("/item/detalle")
	public String getItemDetalle(@RequestParam String id, Model model) {
		model.addAttribute("item", itemServ.buscar(Long.parseLong(id)));
		model = llenarDepartamentos(model);
		return "/admin/itemdetalle";
	}

	// Agregar Item -post

	@PostMapping("/item/agregar")
	public String postAgregarTransporte(@RequestParam String departamento, String nombre, String descripcion,
			String costo, Model model) {

		try {
			Item i = new Item(Utilitario.generarId(), nombre, descripcion, Integer.parseInt(costo), Utilitario.ACTIVO);
			i.setIdDepartamento(new Departamento(Long.parseLong(departamento)));
			itemServ.agregar(i);
			model.addAttribute("msg", "Item Agregado Exitosamente");
			model.addAttribute("item", itemServ.listar());
			return "admin/item";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model = llenarDepartamentos(model);
			return "admin/agregar";
		}
	}

	// Modificar Item - POST
	@PostMapping("item/actualizar")
	public String postItemModificar(@RequestParam String id, String departamento, String nombre, String descripcion,
			String costo, String activo, Model model) throws IOException {
		Item i = new Item(Long.parseLong(id), nombre, descripcion, Integer.parseInt(costo),
				activo != null ? Utilitario.ACTIVO : Utilitario.INACTIVO);
		i.setIdDepartamento(new Departamento(Long.parseLong(departamento)));
		itemServ.agregar(i);
		model.addAttribute("msg", "Item modificado exitosamente");
		return getItem(model);
	}

	// Listar Mantenciom
	@GetMapping("/mantencion")
	public String getMantencion(Model model) {
		model.addAttribute("mantencion", mantencionServ.listar());
		return "admin/mantencion";
	}

	// Agregar mantencion- GET
	@GetMapping("/mantencion/agregar")
	public String getMantencionAgregar(Model model) {
		model = llenarDepartamentos(model);
		model = llenarMantenciones(model);
		return "admin/mantencionagregar";
	}

	// Detalle mantencion
	@GetMapping("/mantencion/detalle")
	public String getMantencionDetalle(@RequestParam String id, Model model) {
		model.addAttribute("mantencion", mantencionServ.buscar(Long.parseLong(id)));
		model = llenarDepartamentos(model);
		model = llenarMantenciones(model);
		return "/admin/mantenciondetalle";
	}

	// Agregar mantencion -post
	@PostMapping("/mantencion/agregar")
	public String postAgregarMantencion(@RequestParam String departamento, String tipomantencion, String man,
			String fecha, String descripcion, String costo, String activo, Model model) {

		try {
			Mantencion m = new Mantencion(Utilitario.generarId(), LocalDate.parse(fecha), Integer.parseInt(costo));
			m.setIdDepartamento(new Departamento(Long.parseLong(departamento)));
			m.setIdTipomantencion(new TipoMantencion(Long.parseLong(tipomantencion)));
			mantencionServ.agregar(m);
			model.addAttribute("msg", "Mantencion Agregado Exitosamente");
			model.addAttribute("mantencion", mantencionServ.listar());
			return "admin/mantencion";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model = llenarDepartamentos(model);
			model = llenarMantenciones(model);
			return "admin/mantencionagregar";
		}
	}

	// Actualizar Mantencion - POST
	@PostMapping("/mantencion/modificar")
	public String postMantencionModificar(@RequestParam String idMan, String departamento, String fecha, String costo,
			String descripcion, String Tipomantencion, Model model) throws IOException {
		Mantencion m = new Mantencion(Long.parseLong(idMan), LocalDate.parse(fecha), Integer.parseInt(costo));
		m.setIdDepartamento(new Departamento(Long.parseLong(departamento)));
		m.setIdTipomantencion(new TipoMantencion(Long.parseLong(Tipomantencion)));
		mantencionServ.modificar(m);
		model.addAttribute("msg", "Mantención modificada exitosamente");
		return getMantencion(model);
	}

	// Listar Cuentas adm
	@GetMapping("/administrador")
	public String getAdministrador(Model model) {
		model.addAttribute("cuenta", cuentaServ.listar());
		return "admin/administrador";
	}

	// Agregar cuenta adm- GET
	@GetMapping("/administrador/agregar")
	public String getAdministradorAgregar(Model model) {
		model = llenarCuentas(model);
		return "admin/administradoragregar";
	}

	// Detalle cuenta adm
	@GetMapping("/administrador/detalle")
	public String getAdministradorDetalle(@RequestParam String id, Model model) {
		model.addAttribute("cuenta", cuentaServ.buscar(Long.parseLong(id)));
		model = llenarCuentas(model);
		return "/admin/administradordetalle";
	}

	// Agregar Admin - post
	@PostMapping("/administrador/agregar")
	public String postAdministradorAgregar(@RequestParam String correo, String rut, String nombre, String apellidop,
			String apellidom, String celular, String password, String telefono, Model model) {

		Long idCuenta = Utilitario.generarId();
		String passBCryp = Utilitario.passwordEncoder().encode(password);
		Cuenta c = new Cuenta(idCuenta, correo, passBCryp, rut, nombre, apellidop, apellidom,
				Integer.parseInt(celular));
		c.setTelefono(telefono != null ? Integer.parseInt(telefono) : -1);
		c.setIdTipocuenta(new TipoCuenta(1l));
		cuentaServ.agregar(c);
		Long idAdmin = Utilitario.generarId();
		Admin ad = new Admin(idAdmin, "1");
		ad.setIdCuenta(c);
		adminServ.agregar(ad);
		model.addAttribute("msg", "Administrador agregado exitosamente");
		model.addAttribute("administrador", adminServ.listar());
		return "admin/administrador";

	}

	// Modificar administrador
	@PostMapping("administrador/modificar")
	public String postAdministradorModificar(@RequestParam String idCu, String correo, String rut, String nombre,
			String apellidop, String apellidom, String celular, String password, String telefono, Model model)
			throws IOException {

		String passBCryp;

		if (password != null) {
			passBCryp = Utilitario.passwordEncoder().encode(password);
		} else {
			passBCryp = cuentaServ.buscar(Long.parseLong(idCu)).getContrasena();
		}

		Cuenta c = new Cuenta(Long.parseLong(idCu), correo, passBCryp, rut, nombre, apellidop, apellidom,
				Integer.parseInt(celular));
		c.setTelefono(telefono != null ? Integer.parseInt(telefono) : -1);
		c.setIdTipocuenta(new TipoCuenta(1l));
		cuentaServ.modificar(c);
		model.addAttribute("msg", "Administrador modificado exitosamente");
		return getAdministrador(model);
	}

	// Listar Cuentas funcionario
	@GetMapping("/funcionario")
	public String getFuncionario(Model model) {
		model.addAttribute("cuenta", cuentaServ.listar());
		model.addAttribute("funcionarios", funcionarioServ.listar());
		return "admin/funcionario";
	}

	// Agregar cuenta funcionario- GET
	@GetMapping("/funcionario/agregar")
	public String getFuncionarioAgregar(Model model) {
		model.addAttribute("edificios", edificioServ.listar());
		model = llenarCuentas(model);
		return "admin/funcionarioagregar";
	}

	// Detalle cuenta funcionairo
	@GetMapping("/funcionario/detalle")
	public String getFuncionarioDetalle(@RequestParam String id, Model model) {
		Cuenta c = cuentaServ.buscar(Long.parseLong(id));
		model.addAttribute("cuenta", c);
		model.addAttribute("funcionario", funcionarioServ.buscarPorCuenta(c));
		model.addAttribute("edificios", edificioServ.listar());
		model = llenarCuentas(model);
		return "/admin/funcionariodetalle";
	}

	// Agregar funcionario - post
	@PostMapping("/funcionario/agregar")
	public String postFuncionarioAgregar(@RequestParam String edificio, String correo, String rut, String nombre,
			String apellidop, String apellidom, String celular, String password, String telefono, Model model) {

		Long idCuenta = Utilitario.generarId();
		String passBCryp = Utilitario.passwordEncoder().encode(password);
		Cuenta c = new Cuenta(idCuenta, correo, passBCryp, rut, nombre, apellidop, apellidom,
				Integer.parseInt(celular));
		c.setTelefono(telefono != null ? Integer.parseInt(telefono) : -1);
		c.setIdTipocuenta(new TipoCuenta(2l));
		cuentaServ.agregar(c);
		Long idFuncionario = Utilitario.generarId();
		Funcionario fun = new Funcionario(idFuncionario, "2");
		fun.setIdCuenta(c);
		fun.setIdEdificio(new Edificio(Long.parseLong(edificio)));
		funcionarioServ.agregar(fun);
		model.addAttribute("msg", "Funcionario agregado exitosamente");
		model.addAttribute("funcionario", funcionarioServ.listar());
		return "admin/funcionario";

	}

	// Modificar funcionario
	@PostMapping("funcionario/modificar")
	public String postFuncionarioModificar(@RequestParam String idCu, String edificio, String idFu, String correo,
			String rut, String nombre, String apellidop, String apellidom, String celular, String password,
			String telefono, Model model) throws IOException {

		String passBCryp;

		if (password != null) {
			passBCryp = Utilitario.passwordEncoder().encode(password);
		} else {
			passBCryp = cuentaServ.buscar(Long.parseLong(idCu)).getContrasena();
		}

		Cuenta c = new Cuenta(Long.parseLong(idCu), correo, passBCryp, rut, nombre, apellidop, apellidom,
				Integer.parseInt(celular));
		c.setTelefono(telefono != null ? Integer.parseInt(telefono) : -1);
		Funcionario fun = new Funcionario(Long.parseLong(idFu), "1");
		fun.setIdEdificio(new Edificio(Long.parseLong(edificio)));
		c.setIdTipocuenta(new TipoCuenta(2l));
		fun.setIdCuenta(c);
		cuentaServ.modificar(c);
		funcionarioServ.modificar(fun);
		model.addAttribute("msg", "Funcionario modificado exitosamente");
		return getFuncionario(model);
	}

	// Agregar cuenta cli- GET
	@GetMapping("/registro")
	public String getRegistroAgregar(Model model) {
		return "/registro";
	}

	// Agregar cli - post
	@PostMapping("/registro/agregar")
	public String postRegistroAgregar(@RequestParam String correo, String rut, String nombre, String apellidop,
			String apellidom, String celular, String password, String telefono, Model model) {

		Long idCuenta = Utilitario.generarId();
		String passBCryp = Utilitario.passwordEncoder().encode(password);
		Cuenta c = new Cuenta(idCuenta, correo, passBCryp, rut, nombre, apellidop, apellidom,
				Integer.parseInt(celular));
		c.setTelefono(telefono != null ? Integer.parseInt(telefono) : -1);
		c.setIdTipocuenta(new TipoCuenta(3l));
		cuentaServ.agregar(c);
		//Long idCliente = Utilitario.generarId();
		Cliente cli = new Cliente(idCuenta, "1");
		cli.setIdCuenta(c);
		clienteServ.agregar(cli);

		model.addAttribute("msg", "     ¡ Cuenta registrada exitosamente ! :D");
		return "login";

	}

}
