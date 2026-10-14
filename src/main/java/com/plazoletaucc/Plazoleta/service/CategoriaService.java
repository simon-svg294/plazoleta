package com.plazoletaucc.Plazoleta.service;

import com.plazoletaucc.Plazoleta.dto.reponse.CategoriaResponseDTO;
import com.plazoletaucc.Plazoleta.dto.request.CategoriaRequestDTO;

import java.util.ArrayList;

public interface CategoriaService {
    CategoriaResponseDTO registrarCategoria(CategoriaRequestDTO categoriaRequestDTO);
    ArrayList<CategoriaResponseDTO> listarCategorias();
}
