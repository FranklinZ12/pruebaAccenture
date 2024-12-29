# Proyecto Accenture

## Descripción
Este proyecto es una API desarrollada con **Spring Boot 3** y **Java 21** para manejar una lista de franquicias. Cada franquicia está compuesta por un nombre y un listado de sucursales. Las sucursales tienen un nombre y un listado de productos, y cada producto contiene un nombre y una cantidad de stock.

---

## Pasos para desplegar el proyecto en local

### 1. Clonar el repositorio
Abre una terminal y ejecuta el siguiente comando para clonar el repositorio:

```bash
git clone https://github.com/usuario/repo-accenture.git
cd repo-accenture
```

### 2. Configurar la base de datos
1. Asegúrate de tener **MySQL** instalado y en ejecución (puedes usar herramientas como **XAMPP** si prefieres).
2. Si usas **XAMP** tienes que darle star el servidor apache y activar la bd MySql desde el xamp control panel.
3. Crea la base de datos ejecutando el script SQL incluido en el archivo `README.md` o directamente en tu terminal MySQL:

   ```sql
   CREATE DATABASE franquicias
   CHARACTER SET utf8mb4
   COLLATE utf8mb4_general_ci;
   ```

4. Verifica que las credenciales de conexión en `src/main/resources/application.properties` sean correctas para tu entorno. Por defecto, están configuradas así:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/franquicias
   spring.datasource.username=root
   spring.datasource.password=
   ```

   Si usas otro usuario o contraseña, actualiza estas líneas con tus valores.

---

### 3. Instalar dependencias
Ejecuta el siguiente comando para descargar todas las dependencias del proyecto:

```bash
mvn clean install
```

---

### 4. Ejecutar la aplicación
Inicia la aplicación localmente con:

```bash
mvn spring-boot:run
```

O bien, genera el archivo JAR y ejecútalo:

```bash
mvn clean package
java -jar target/accenture-0.0.1-SNAPSHOT.jar
```

---

### 5. Importar la colección de Postman (opcional)
Si deseas probar los endpoints directamente, importa la colección `pruebaAccenture.postman_collection.json` en Postman:

1. Abre **Postman**.
2. Haz clic en **Importar**.
3. Selecciona el archivo `pruebaAccenture.postman_collection.json` ubicado en el directorio raíz del proyecto.

---

### 6. Acceder a la aplicación
Una vez que el servidor esté en ejecución, puedes acceder a la API desde tu navegador o herramientas como Postman en:

```
http://localhost:9091
```

---

## Links

- [Documentación oficial de Spring Boot](https://spring.io/projects/spring-boot): Página oficial del framework Spring Boot.
- [Guía de instalación de Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html): Descarga e instrucciones para instalar Java 21.
- [MySQL](https://dev.mysql.com/): Página oficial para descargar MySQL.
- [Postman](https://www.postman.com/): Herramienta para probar y documentar APIs.
- [Repositorio del proyecto](https://github.com/FranklinZ12/pruebaAccenture):Enlace al repositorio donde se encuentra este proyecto.
- [Descarga de XAMPP](https://www.apachefriends.org/download.html): Herramienta para ejecutar el servidor MySQL en local.

---

## Notas adicionales

- **Puertos ocupados:** Si el puerto `9091` ya está en uso, puedes cambiarlo modificando el archivo `application.properties`:

   ```properties
   server.port=PUERTO_DESEADO
   ```

- **Errores comunes:** Si hay problemas con la conexión a la base de datos, verifica que el servidor MySQL esté activo y que la configuración sea correcta.

---

¡Ahora el proyecto está listo para desplegarse en tu entorno local!

