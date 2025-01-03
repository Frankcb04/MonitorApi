# Proyecto de Gestión de Productos en Spring Boot

Este es un proyecto de gestión de productos utilizando Spring Boot y MySQL. El sistema permite gestionar productos, verificar su disponibilidad de stock, y emitir alertas cuando el stock baja del umbral configurado.

## Tecnologías Utilizadas

- **Spring Boot**: Framework para construir aplicaciones Java de manera rápida y eficiente.
- **Spring Data JPA**: Para la gestión de la base de datos y la interacción con MySQL.
- **MySQL**: Base de datos relacional utilizada para almacenar la información de los productos.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

## Funcionalidades

- **Gestión de Productos**: CRUD (Crear, Leer, Actualizar, Eliminar) de productos.
- **Monitoreo de Stock**: Revisión periódica del stock de productos y generación de alertas cuando el stock baja por debajo del umbral configurado.
- **API REST**: Endpoints para interactuar con los productos (GET, POST, PUT, DELETE).
- **Alertas Simuladas**: Alerta por consola cuando el stock de un producto baja del umbral.
