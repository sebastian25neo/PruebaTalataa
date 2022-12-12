### Bienvenido Funcionamiento de RESTful 
**Funcionamiento de RESTful **
Este es el README de funcionamiento de la RESTful API de películas de la prueba para ingresar a Talataa del consumo de la API de **https://www.themoviedb.org/documentation/api.**
**Nota: todo El método se escriben en mayusculas ejemplo **
**https://pruebathemovieapplication.azurewebsites.net/api/peliculas/GET**

**El Endpoints principal es https://pruebathemovieapplication.azurewebsites.net/api/peliculas/ para las consultas de los métodos que se encuentra en minecraft azure**

Listo para el Endpoints  del método de **GET** para ver todas las películas se utiliza **https://pruebathemovieapplication.azurewebsites.net/api/peliculas/GET**  asi podremos ver todas las películas que nos trae la API de **https://www.themoviedb.org/documentation/api**

Para el Endpoints del método **GET** de detalles de la película se utiliza  con  un **ID:505642** de una Película
**https://pruebathemovieapplication.azurewebsites.net/api/peliculas/DETALLE/505642**

Para el Endpoints del método **POST** se utiliza la siguiente ruta: 
**https://pruebathemovieapplication.azurewebsites.net/api/peliculas/POST/705996** este método nos guarda una calificación de que queramos poner a una película, el cuerpo pare enviar la calificación es este
```json
{
   "value": 5.0
}
```
En el Postman con la URL ya mencionada antes. 

**No encontré un método put en la página de themoviedb y encuentre el de la lista, pero aún no está funcionado bien, por eso el método put no hace nada solo esta**

Para el Endpoints del método **DELETE**  mos permite eliminar la calificación que le  pusimos a una película, la ruta que es utiliza para usar el método es esta.
**https://pruebathemovieapplication.azurewebsites.net/api/peliculas/DETALLE/705996** este método requiere de un **ID**  **ID:505642** de la pelicula película que calificamos para borrar la calificación

**Muchas Gracias por el tiempo y la oportunidad :)**
