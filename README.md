# pruebavalid

El presente esta construdio siguiendo principios de la metodología basada en dominios DDD; 
esto mediante un proyecto Maven de multiples módulos "bounded contexts" con Spring  5.3.5. 


Para ello se define un proyecto padre el cual gestiona los diferentes modulos:

Prueba Valid
    └── commons
    └── validParent
	└── validArchetype
			└── validArchetypeCore
					└──registro-core
			└── validArchetypeWeb
						└──registro-web
					    └──registro_web-client
			      
	


commons:             Contiene pojos transversales en el aplicativo.
parent y archetypes: Conforman las configuraciones de depenencias, compilaciones, reglas de estilo acorde a cada modulo (web o core).
registro-core:       Pojos de negocio asociados al dominio de registro, estos se empaquetaran como .jar dentro del artefacto desplegable 
registro-web:        Pojos que exponen servicios rest asociados al registro. desplegable war.

registro_web-client: Ejemplo de un aplicativo web basado en html y javascript(contine los requerimientos frontend solicitados). 
					 Desplegable .war a manera de incluirlo en el proyecto para el ejemplo, pero pudiese ser simplemente el html con los recursos.

De esta forma se propone un crecimiento del aplicativo por sub-modulos core y/o web asociados al negocio. 
Ejemplo: Para un nuevo sub modulo los archetypes ya estan definidos, simplemente ejecutar mvn archetype:generate ...


Consideraciones de arquitectura:

Uso de patron Strategy en la conexiones a la bd mediante JDBCTemplate.
uso de patron Bussiness Delegate para el ocultamiento de la implementación en los servicios de negocio.
Uso de patron Modulo en frontend, separando las funcionalidades en .js y relacionandola en su respectiva vista (Html más limpios).

Programación por aspecto AOP para:
									Logging
									Monitoreo de rendimiento
									Manejo de errores
									
Metodolodia TDD (Test-Driven Development) para la construcción de servicios.	
