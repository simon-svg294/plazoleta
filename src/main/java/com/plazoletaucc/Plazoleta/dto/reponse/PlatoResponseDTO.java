package com.plazoletaucc.Plazoleta.dto.reponse;

import com.plazoletaucc.Plazoleta.entity.Categoria;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlatoResponseDTO {
    private String nombre;
    private String descripcion;
    private Double precio;
    private String urlImagen;
    private Boolean estado;
    private Categoria categoria;
}
