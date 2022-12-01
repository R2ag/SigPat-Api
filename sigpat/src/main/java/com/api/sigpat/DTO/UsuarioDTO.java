package com.api.sigpat.DTO;


import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class UsuarioDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String usuário;
    @NotBlank
    private String senha;
}
