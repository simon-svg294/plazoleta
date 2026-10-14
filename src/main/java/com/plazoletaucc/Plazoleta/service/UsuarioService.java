package com.plazoletaucc.Plazoleta.service;

import com.plazoletaucc.Plazoleta.dto.reponse.RegistroResponseDTO;
import com.plazoletaucc.Plazoleta.dto.request.RegistroRequestDTO;

public interface UsuarioService {
    RegistroResponseDTO registrarUsuario(RegistroRequestDTO registroRequestDTO);
}
