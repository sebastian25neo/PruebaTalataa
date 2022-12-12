package com.pruebathemovie.pruebathemovie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebathemovie.pruebathemovie.dto.ListaPeliculas;
import com.pruebathemovie.pruebathemovie.dto.PeliculasDTO;
import com.pruebathemovie.pruebathemovie.dto.CalificarPeliculas;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeliculasService {
    //  @Value("${base-url}")
    @Value("${spring.external.service.base-url}")
    private String basePath;
    @Value("${spring.external.service.api-key}")
    private String api_key;
    @Value("${spring.external.service.api-token}")
    private String  token;
    private final RestTemplate restTemplate;

    public List<PeliculasDTO> getSeries() {
        String url = basePath + "/movie/upcoming?" + api_key;
        PeliculasDTO response = restTemplate.getForObject(url, PeliculasDTO.class );
        return Arrays.asList(response) ;
    }

    public Object getDetallePeliculas(Integer id){
        String url=basePath+"movie/"+id+"?"+api_key;
        Object response = restTemplate.getForObject(url, Object.class);
        return response;
    }


    public Object saveCalificarPelicula(Integer id, CalificarPeliculas calificarPeliculas){

        String  postUrl =basePath+"movie/"+id+"/rating?"+api_key;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            String json = new ObjectMapper().writeValueAsString(calificarPeliculas);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            ResponseEntity<Object> response = restTemplate.exchange(postUrl, HttpMethod.POST, entity, Object.class);
            return response.getBody();

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }



    public Object updateListadoPelicula(Integer id, ListaPeliculas peliculasPut){

        String  putUrl =basePath+"list/"+id+"?"+api_key;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            String json = new ObjectMapper().writeValueAsString(peliculasPut);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            ResponseEntity<Object> response = restTemplate.exchange(putUrl, HttpMethod.POST, entity, Object.class);

            return response.getBody();

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    public  Object deleteClasificacion(Integer id){
        String DeleteUrl=basePath+"movie/"+id+"/rating?"+api_key;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            String json = new ObjectMapper().writeValueAsString(id);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            ResponseEntity<Object> response = restTemplate.exchange(DeleteUrl, HttpMethod.DELETE, entity, Object.class);
            return response.getBody();

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
