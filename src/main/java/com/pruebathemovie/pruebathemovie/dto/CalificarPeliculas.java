package com.pruebathemovie.pruebathemovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CalificarPeliculas {
    private String names;

    @NotNull(message = "Se requiere el campo")
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
