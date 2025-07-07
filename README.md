# iCalendar Spring Boot API

Esta aplicación contiene un ejemplo mínimo de cómo exponer eventos utilizando el formato iCalendar mediante un API REST.

## Requisitos
- Java 11
- Maven

## Ejecución
```
mvn spring-boot:run
```

Los endpoints principales son:
- `GET /events` lista los eventos almacenados en memoria.
- `POST /events` crea un nuevo evento.
- `GET /events/{id}/ical` descarga el evento en formato `.ics`.
