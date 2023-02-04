# liverpool
## Guía de implementación

### Trabajando con la API de Liverpool

Este proyecto implementa el API de Liverpool.

### Arquitectura

Este proyecto sigue buenas prácticas de la arquitectura limpia (Clean Architecture) planteada por Robert C. Martin para hacer un código más independiente, mantenible y sencillo para generar pruebas unitarias.

#### Capas

* Presentación: UI y View Models.
* Casos de uso: GetProductsByPageUseCase
* Dominio: ProductsModel y DTO
* Datos: ProductsRepository, RemoteDataSource

Este proyecto usa ViewModel para almacenar y manejar datos, así como comunicar cambios hacia la vista.

Este proyecto usa LiveData.

### Administrador de solicitudes: Retrofit

Este proyecto utiliza Retrofit para proporcionar una lista de productos y su información desde una API.

### Biblioteca de imágenes - Glide

Este proyecto utiliza Glide para cargar las imágenes de los productos.

### Inyección de dependencia - Dagger Hilt

Este proyecto utiliza Dagger Hilt para gestionar la inyección de dependencia.
