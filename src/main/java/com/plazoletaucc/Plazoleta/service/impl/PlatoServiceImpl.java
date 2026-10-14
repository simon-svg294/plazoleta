package com.plazoletaucc.Plazoleta.service.impl;

import com.plazoletaucc.Plazoleta.dto.reponse.PlatoResponseDTO;
import com.plazoletaucc.Plazoleta.dto.request.PlatoRequestDTO;
import com.plazoletaucc.Plazoleta.entity.Categoria;
import com.plazoletaucc.Plazoleta.entity.Plato;
import com.plazoletaucc.Plazoleta.repository.CategoriaRepository;
import com.plazoletaucc.Plazoleta.repository.PlatoRespository;
import com.plazoletaucc.Plazoleta.service.PlatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements PlatoService {
    private final PlatoRespository platoRespository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public PlatoResponseDTO registrarPlato(PlatoRequestDTO platoRequestDTO) {
        Categoria categoria = categoriaRepository.findById(platoRequestDTO.getCategoria())
                .orElseThrow(()-> new RuntimeException("Categoria no encontrada"));

        Plato plato = Plato.builder()
                .nombre(platoRequestDTO.getNombre())
                .descripcion(platoRequestDTO.getDescripcion())
                .urlImagen(platoRequestDTO.getUrlImagen())
                .precio(platoRequestDTO.getPrecio())
                .estado(platoRequestDTO.getEstado())
                .categoria(categoria)
                .build();

        Plato platoGuardado = platoRespository.save(plato);

        return PlatoResponseDTO.builder()
                .nombre(platoGuardado.getNombre())
                .descripcion(platoGuardado.getDescripcion())
                .urlImagen(platoGuardado.getUrlImagen())
                .precio(platoGuardado.getPrecio())
                .estado(platoGuardado.getEstado())
                .categoria(categoria)
                .build();
    }
}
