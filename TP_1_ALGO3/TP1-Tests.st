TestCase subclass: #AlgoPedidosTests	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:10'!test05SeCambiaCantidadDeProductosEnPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Carlos'.
	
	algoPedidos agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 1 para: 'Carlos'.
	algoPedidos agregarProductoConNombre: 'Gaseosa' precio: 250.0 yCantidad: 1 para: 'Carlos'.
	
	self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos') equals: 2.
	
	algoPedidos actualizarProductoConNombre: 'Gaseosa' conCantidad: 3 para: 'Carlos'.
	
	self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos') equals: 4.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 19:05'!test04AplicarCuponDeDescuentoPorcentualAPedidoConProductos
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Tomás'.
	
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 1 para: 'Tomás'.
	algoPedidos agregarCuponAPedidoDe: 'Tomás' conPorcentaje: 10. 
	
	self assert: (algoPedidos precioPedidoDe: 'Tomás') closeTo: (200*0.9) precision: 0.01. "-10%"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:11'!test06AplicarCuponDeDescuentoFijoAPedidoConProductos
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Diego'.

	algoPedidos agregarCuponAPedidoDe: 'Diego' conValor: 15. 	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 350.0 yCantidad: 1 para: 'Diego'.
	
	self assert: (algoPedidos precioPedidoDe: 'Diego') closeTo: 335.0 precision: 0.01. "-15"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:11'!test07AgregarCuponAPedidoConMenuNoRealizaDescuento
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Julian'.

	algoPedidos agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 1 para: 'Julian'.
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2 para: 'Julian'.

	algoPedidos agregarCuponAPedidoDe: 'Julian' conValor: 15.
	
	self assert: (algoPedidos precioPedidoDe: 'Julian') equals: 600.0.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:11'!test09RemoverProductosAPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Sebas'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 1 para: 'Sebas'.
	algoPedidos agregarMenuConNombre: 'Menú Lunes' precio: 200.0 yCantidad: 1 para: 'Sebas'.
	algoPedidos agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 1 para: 'Sebas'.
	 
	self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (950*1.2). "20% extra"
	
	algoPedidos removerProductoConNombre: 'vino' para: 'Sebas'.
	algoPedidos removerMenuConNombre: 'Menú Lunes' para: 'Sebas'.
	
	self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (500*1.2). "20% extra"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tomas 11/8/2020 16:24'!test10SiElPedidoNoTieneNombreLanzaUnaExcepcion	|algoPedidos|	algoPedidos := AlgoPedidos new.	self should: [algoPedidos crearPedidoParaRetirarPara: ''] raise: PedidoSinNombreError.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tomas 11/5/2020 18:12'!test01SeAgreganProductosAPedidoParaRetirar
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Eugenio'.
	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 250.0 yCantidad: 2 para: 'Eugenio'.
	algoPedidos agregarProductoConNombre: 'Gelatina' precio: 100.0 yCantidad: 1 para: 'Eugenio'.
	 
	self assert: (algoPedidos precioPedidoDe: 'Eugenio') equals: 600.0.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/3/2020 00:02'!test03SeAgregaMenuAPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Pablo'.
	
	algoPedidos agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 1 para: 'Pablo'.
	algoPedidos agregarProductoConNombre: 'Gaseosa' precio: 250.0 yCantidad: 1 para: 'Pablo'.
	
	self assert: (algoPedidos precioPedidoDe: 'Pablo') closeTo: 450.0 precision: 0.1.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 19:17'!test02SeAgreganProductosAPedidoConDelivery
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Santiago'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 1 para: 'Santiago'.
	algoPedidos agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 1 para: 'Santiago'.
	 
	self assert: (algoPedidos precioPedidoDe: 'Santiago') equals: (750*1.2). "20% extra"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:11'!test08RemoverCuponDeDescuentoAPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Martin'.

	algoPedidos agregarCuponAPedidoDe: 'Martin' conValor: 15. 	
	algoPedidos agregarProductoConNombre: 'Pizza' precio: 350.0 yCantidad: 1 para: 'Martin'.
	
	self assert: (algoPedidos precioPedidoDe: 'Martin') closeTo: 335.0 precision: 0.01.  "-15"
	
	algoPedidos removerCuponDePedidoDe: 'Martin'.

	self assert: (algoPedidos precioPedidoDe: 'Martin') closeTo: 350.0 precision: 0.01.! !TestCase subclass: #CuponPorcentualTest	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!CuponPorcentualTest methodsFor: 'as yet unclassified' stamp: 'Tomas 11/4/2020 19:10'!test01AplicoUnCuponPorcentualDe15YElDescuentoEsDe15Porciento 	| cupon |	cupon := CuponPorcentual conPorcentaje: 15.	self assert: (cupon calcularTotalConDescuento: 1000) equals: 850.! !!CuponPorcentualTest methodsFor: 'tests' stamp: 'Tomas 11/5/2020 16:35'!test02SiElCuponTienePorcentajeMenorACeroOMayorACienEsUnError	self should: [CuponPorcentual conPorcentaje: -1] raise: CuponConValorIgualOMenorQueCeroError.	self should: [CuponPorcentual conPorcentaje: 102] raise: PorcentajeFueraDeRangoError.! !TestCase subclass: #CuponValorFijoTest	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!CuponValorFijoTest methodsFor: 'tests' stamp: 'Tomas 11/5/2020 15:05'!test01AplicoUnCuponDeValorFijo1000YSeDescuentan1000		| cupon |	cupon := CuponValorFijo conValor: 1000.	self assert: (cupon calcularTotalConDescuento: 1200) equals: 200! !!CuponValorFijoTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 16:28'!test02SiElCuponTieneValorMenorOIgualACeroEsUnError	self should: [CuponValorFijo conValor: -10] raise: CuponConValorIgualOMenorQueCeroError.	self should: [CuponValorFijo conValor: 0] raise: CuponConValorIgualOMenorQueCeroError.! !TestCase subclass: #PedidoParaDeliveryTest	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:46'!test01SiAgregoUnMenuEfectivamentePidoUnMenu	| pedido |	pedido := PedidoParaDelivery new.	pedido agregarMenuConNombre: 'Menu Lunes' precio: 120 yCantidad: 2.		self assert: [ pedido pidioMenu = true ]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:03'!test06SiRemuevoElCuponNoSeRealizanDescuentos	| pedido cupon|		cupon := CuponValorFijo conValor: 100.	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarCupon: cupon.	pedido removerCuponDeDescuento.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 150 ]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:58'!test08SiRemuevoUnProductoEfectivamenteSeVaDeMiPedido	| pedido |	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarProductoConNombre: 'Milanesa' precio: 250 yCantidad: 1.		pedido removerProducto: 'Agua Mineral'.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 250]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:35'!test10SiCalculoElTotalSeAgregaUn20Porciento	| pedido |	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 1.	pedido agregarMenuConNombre: 'Menu Lunes' precio: 250 yCantidad: 1.		self assert: [ pedido calcularTotal = 360]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:00'!test09SiRemuevoUnMenuEfectivamenteSeVaDeMiPedido	| pedido |	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarMenuConNombre: 'Menu Lunes' precio: 250 yCantidad: 1.		pedido removerMenu: 'Menu Lunes'.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 150]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:46'!test02SiAgregoUnProductoNoAgregueUnMenu	| pedido |	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Alfajor' precio: 50 yCantidad: 3.	pedido agregarProductoConNombre: 'Gaseosa' precio: 90 yCantidad: 1.		self assert: [ pedido pidioMenu = false]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:47'!test04SiCambioLaCantidadDeMiProductoTengoUnaNuevaCantidad	| pedido |	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.		self assert: [ pedido calcularCantidadTotalDeProductos = 3].		pedido actualizarProducto: 'Agua Mineral' conCantidad: 6.		self assert: [ pedido calcularCantidadTotalDeProductos = 6]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:56'!test07AgregoUnPedidoANombreDeJuanYAlObtenerQuienPidioDevuelveJuan	| pedido |	pedido := PedidoParaDelivery new.	pedido esElPedidoDe: 'Tomas'.		self assert: [ pedido obtenerQuienPidio = 'Tomas' ]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:46'!test03SiAgrego5ProductosEnTotalTengo5Productos	| pedido |	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarProductoConNombre: 'Fideos' precio: 90 yCantidad: 2.		self assert: [ pedido calcularCantidadTotalDeProductos = 5]	! !!PedidoParaDeliveryTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:47'!test05SiAgregoUnCuponSeRealizaUnDescuento	| pedido cupon|		cupon := CuponValorFijo conValor: 100.	pedido := PedidoParaDelivery new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarCupon: cupon.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 50 ]	! !TestCase subclass: #PedidoParaRetirarTest	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test01SiAgregoUnMenuEfectivamentePidoUnMenu	| pedido |	pedido := PedidoParaRetirar new.	pedido agregarMenuConNombre: 'Menu Lunes' precio: 120 yCantidad: 2.		self assert: [ pedido pidioMenu = true ]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test06SiRemuevoElCuponNoSeRealizanDescuentos	| pedido cupon|		cupon := CuponValorFijo conValor: 100.	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarCupon: cupon.	pedido removerCuponDeDescuento.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 150 ]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test08SiRemuevoUnProductoEfectivamenteSeVaDeMiPedido	| pedido |	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarProductoConNombre: 'Milanesa' precio: 250 yCantidad: 1.		pedido removerProducto: 'Agua Mineral'.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 250]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:35'!test10SiCalculoElTotalNoSeAgregaNada	| pedido |	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 1.	pedido agregarMenuConNombre: 'Menu Lunes' precio: 250 yCantidad: 1.		self assert: [ pedido calcularTotal = 300]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:08'!test09SiRemuevoUnMenuEfectivamenteSeVaDeMiPedido	| pedido |	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarMenuConNombre: 'Menu Lunes' precio: 250 yCantidad: 1.		pedido removerMenu: 'Menu Lunes'.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 150]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test02SiAgregoUnProductoNoAgregueUnMenu	| pedido |	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Alfajor' precio: 50 yCantidad: 3.	pedido agregarProductoConNombre: 'Gaseosa' precio: 90 yCantidad: 1.		self assert: [ pedido pidioMenu = false]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test04SiCambioLaCantidadDeMiProductoTengoUnaNuevaCantidad	| pedido |	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.		self assert: [ pedido calcularCantidadTotalDeProductos = 3].		pedido actualizarProducto: 'Agua Mineral' conCantidad: 6.		self assert: [ pedido calcularCantidadTotalDeProductos = 6]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test07AgregoUnPedidoANombreDeJuanYAlObtenerQuienPidioDevuelveJuan	| pedido |	pedido := PedidoParaRetirar new.	pedido esElPedidoDe: 'Tomas'.		self assert: [ pedido obtenerQuienPidio = 'Tomas' ]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test03SiAgrego5ProductosEnTotalTengo5Productos	| pedido |	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarProductoConNombre: 'Fideos' precio: 90 yCantidad: 2.		self assert: [ pedido calcularCantidadTotalDeProductos = 5]	! !!PedidoParaRetirarTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 18:07'!test05SiAgregoUnCuponSeRealizaUnDescuento	| pedido cupon|		cupon := CuponValorFijo conValor: 100.	pedido := PedidoParaRetirar new.	pedido agregarProductoConNombre: 'Agua Mineral' precio: 50 yCantidad: 3.	pedido agregarCupon: cupon.		self assert: [ pedido calcularTotalSinConsiderarElTipoDePedido = 50 ]	! !TestCase subclass: #ProductoTest	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!ProductoTest methodsFor: 'tests' stamp: 'Tomas 11/5/2020 16:43'!test01SiLaCantidadIngresadaEsIgualOMenorACeroSeLanzaUnaExcepcion	self should: [Producto conNombre: 'Pescado' precio: 100  yCantidad: 0] raise: CantidadMenorOIgualQueCeroError.	self should: [Producto conNombre: 'Queso' precio: 40  yCantidad: -2] raise: CantidadMenorOIgualQueCeroError.	! !!ProductoTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:23'!test05SiPidoSalmonElNombreDelProductoEsSalmon	| unPedido |	unPedido := Producto new.	unPedido conNombre: 'Salmon' yPrecio: 200.	unPedido cantidad: 2.		self assert: [ unPedido obtenerNombreProducto  = 'Salmon' ]! !!ProductoTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:22'!test04SiElPrecioTotalCantidadPorProductoEs1000EfectivamenteElPrecioEs1000	| unPedido |	unPedido := Producto new.	unPedido conNombre: 'Salmon' yPrecio: 200.	unPedido cantidad: 2.		self assert: [ unPedido precioTotal = 400 ]! !!ProductoTest methodsFor: 'tests' stamp: 'Tomas 11/5/2020 17:12'!test03SiElPrecioEsIgualOMenorACeroSeLanzaUnaExcepcion	self should: [ Producto conNombre: 'Salmon' precio: -100  yCantidad: 2] raise: PrecioMenorOIgualQueCeroError.! !!ProductoTest methodsFor: 'tests' stamp: 'Tomas 11/5/2020 16:25'!test02SiElProductoNoTieneNombreLanzaUnaExcepcion	self should: [ Producto conNombre: '' precio: 100  yCantidad: 2] raise: ProductoSinNombreError.! !!ProductoTest methodsFor: 'tests' stamp: 'Tomas 11/8/2020 17:25'!test06SiPidoDosGaseosasLaCantidadDeProductosEsDos	| unPedido |	unPedido := Producto new.	unPedido conNombre: 'Gaseosa' yPrecio: 100.	unPedido cantidad: 2.		self assert: [ unPedido obtenerCantidad = 2]! !