package com.plazoletaucc.Plazoleta.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RegistroRequestDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    private String documentoDeIdentidad;
    @Size(min = 1, max = 13)
    private String celular;
    private Date fechaDeNacimiento;
    @NotBlank
    @Email
    private String correo;
    @NotBlank
    private String clave;
}
