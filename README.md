# iCalendar Spring Boot API

Esta aplicación contiene un ejemplo mínimo de cómo exponer eventos utilizando el formato iCalendar mediante un API REST.

## Requisitos
- Java 11
- Maven
- PostgreSQL

La base de datos se inicializa y versiona autom\u00e1ticamente con Flyway al arrancar la aplicaci\u00f3n.
Antes de ejecutar la aplicacion crea una base de datos llamada `icalendar` y un usuario `icaluser` con contrasena `icalpass`.

## Ejecución
```
mvn spring-boot:run
```

Los endpoints principales son:
- `GET /events` lista los eventos guardados en la base de datos.
- `POST /events` crea un nuevo evento.
- `GET /events/{id}/ical` descarga el evento en formato `.ics`.
