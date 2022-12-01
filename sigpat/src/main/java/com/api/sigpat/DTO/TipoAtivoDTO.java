package com.api.sigpat.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class TipoAtivoDTO {
    @NotBlank
    private String nome;

}
