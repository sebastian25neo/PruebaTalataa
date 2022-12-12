package com.pruebathemovie.pruebathemovie.controller;

import com.pruebathemovie.pruebathemovie.dto.CalificarPeliculas;
import com.pruebathemovie.pruebathemovie.dto.ListaPeliculas;
import com.pruebathemovie.pruebathemovie.dto.PeliculasDTO;
import com.pruebathemovie.pruebathemovie.service.PeliculasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@RequiredArgsConstructor
public class SerieController {
    private final PeliculasService peliculasService;

    /**
     * NOTA: Endpoints de Búsqueda de películas donde muestra todas las peliculas las mas de mejor calificacion
     *
     * **/
    @GetMapping("/GET")
    public ResponseEntity<List<PeliculasDTO>> getAll(){
        List<PeliculasDTO> list = peliculasService.getSeries();
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    /**
     * NOTA: Endpoints de Búsqueda de detalles de la películas
     *
     * **/
    @GetMapping("/DETALLE/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity getDetallePeliculas(@PathVariable("id") Integer id){
        return new ResponseEntity(peliculasService.getDetallePeliculas(id),HttpStatus.OK);
    }
    /**
     * NOTA: Endpoints de clasificación de una película
     *
     * **/

    @PostMapping("/POST/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveCalificarPelicula(@Valid @PathVariable("id") Integer id, @RequestBody @Valid CalificarPeliculas calificarPeliculas ){
        return new ResponseEntity(peliculasService.saveCalificarPelicula(id, calificarPeliculas), HttpStatus.OK );
    }

    /**
     * NOTA: No encontré un método put en la página de themoviedb y encuentre el de la lista, pero aún no está funcionado bien, por
     * eso el método put no hace nada solo esta
     * **/

    @PutMapping("/PUT/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity updateLista(@PathVariable("id") Integer id,@RequestBody ListaPeliculas peliculasPut){
        return new ResponseEntity(peliculasService.updateListadoPelicula(id, peliculasPut), HttpStatus.OK );
    }

    /**
     * NOTA: Endpoints de Eliminar la clasificación de la película
     *
     * **/
    @DeleteMapping("/DELETE/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteClasificacion(@PathVariable("id") Integer id){
        return new ResponseEntity(peliculasService.deleteClasificacion(id), HttpStatus.OK );

    }

}
