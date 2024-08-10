# Sistema de Inventario en Java

Este proyecto es una implementación de un sistema de inventario en Java, utilizando clases abstractas y genéricos para manejar diferentes tipos de productos. Los productos pueden ser electrónicos, libros o ropa, y el sistema permite agregar, actualizar, eliminar y consultar productos.

## Descripción del Proyecto

El sistema de inventario incluye:
- **Clases de productos** (`Product`, `Electronic`, `Book`, `Clothes`) que definen los atributos y métodos para cada tipo de producto.
- **Manejo de excepciones** para casos en los que un producto no se encuentra.
- **Interfaz de usuario en consola** para interactuar con el sistema.

## Conceptos Aprendidos

Durante el desarrollo de este proyecto, he aprendido y aplicado varios conceptos clave de Java:

### 1. **Clases Abstractas**
Las clases abstractas se usan para definir una clase base con atributos y métodos comunes, mientras que las subclases proporcionan implementaciones específicas. En este proyecto:
- La clase `Product` es una clase abstracta que define atributos como `name`, `price`, y `mount`, y métodos abstractos como `getDetails()`, `equals()`, y `hashCode()`.
- Las clases `Electronic`, `Book`, y `Clothes` extienden `Product` y proporcionan implementaciones específicas de los métodos abstractos.

### 2. **Genéricos**
El uso de genéricos permite crear clases y métodos que funcionan con cualquier tipo de datos, mientras se mantiene la seguridad de tipo en tiempo de compilación. En este proyecto:
- La clase `Inventory<T extends Product>` utiliza un parámetro de tipo genérico `T` que está restringido a clases que extienden `Product`. Esto permite que `Inventory` maneje diferentes tipos de productos de manera flexible y segura.

### 3. **Métodos `equals()` y `hashCode()`**
Estos métodos se utilizan para comparar objetos y para el uso en colecciones basadas en hash. En este proyecto:
- Cada clase que extiende `Product` (`Electronic`, `Book`, `Clothes`) implementa su propio `equals()` y `hashCode()` para asegurar comparaciones precisas y un comportamiento correcto en colecciones como `List`.

### 4. **Manejo de Excepciones Personalizadas**
El proyecto utiliza excepciones personalizadas para manejar errores específicos. En este caso:
- `ProductNotFoundException` es una excepción personalizada que se lanza cuando se intenta buscar un producto que no existe en el inventario.

### 5. **Interfaz de Usuario en Consola**
El proyecto incluye una interfaz de usuario basada en consola para interactuar con el sistema. Se utiliza un menú con opciones para agregar, actualizar, eliminar, y consultar productos, lo que proporciona una forma simple de gestionar el inventario.

## Uso

1. **Ejecutar el programa:**
2. **Opciones del menú:**
- `1. Agregar Producto`: Permite agregar un nuevo producto al inventario.
- `2. Actualizar Producto`: Permite actualizar la información de un producto existente.
- `3. Eliminar Producto`: Permite eliminar un producto del inventario.
- `4. Consultar Producto`: Permite consultar los detalles de un producto.
- `5. Mostrar Inventario`: Muestra todos los productos en el inventario.
- `6. Salir`: Finaliza el programa.

## Instalación

1. **Clonar el repositorio:**
```bash
git clone https://github.com/tu_usuario/tu_repositorio.git
