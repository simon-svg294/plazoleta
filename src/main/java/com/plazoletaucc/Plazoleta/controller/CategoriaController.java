package com.plazoletaucc.Plazoleta.controller;

import com.plazoletaucc.Plazoleta.dto.reponse.CategoriaResponseDTO;
import com.plazoletaucc.Plazoleta.dto.request.CategoriaRequestDTO;
import com.plazoletaucc.Plazoleta.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping("/registro")
    public ResponseEntity<CategoriaResponseDTO> registrarCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.registrarCategoria(categoriaRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.listarCategorias());
    }
}
