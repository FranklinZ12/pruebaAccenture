# API de Manejo de Franquicias

Este proyecto es una API desarrollada con **Spring Boot 3** y **Java 21** para manejar una lista de franquicias.  
Cada franquicia está compuesta por:
- Un **nombre** y un listado de **sucursales**.
- Cada sucursal tiene un **nombre** y un listado de **productos ofertados**.
- Los productos incluyen un **nombre** y una cantidad de **stock**.

---

## Requisitos previos

1. **Java Development Kit (JDK) 21**
    - Descárgalo desde [Oracle](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) o [OpenJDK](https://openjdk.org/).

2. **Maven** (versión 3.9 o superior)
    - Descárgalo desde [Apache Maven](https://maven.apache.org/download.cgi).

3. **XAMPP**
    - Descárgalo desde [XAMPP](https://www.apachefriends.org/download.html) e inicia el servidor MySQL.

4. **Git** (opcional, para clonar el repositorio).

---
## Links

-[Repositorio del proyecto](https://github.com/FranklinZ12/pruebaAccenture):Enlace al repositorio donde se encuentra este proyecto.

---
## Colección de Postman

En el directorio raíz del proyecto se incluye un archivo llamado `pruebaAccenture.postman_collection.json`. Este archivo contiene todos los endpoints necesarios para interactuar con la API.

---
## Configuración de la base de datos

### 1. Crear la base de datos
En **XAMPP**, accede a phpMyAdmin y ejecuta el siguiente script SQL para crear la base de datos:

```sql
CREATE DATABASE IF NOT EXISTS franquicias 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_general_ci;
