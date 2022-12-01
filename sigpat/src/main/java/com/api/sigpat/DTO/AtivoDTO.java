package com.api.sigpat.DTO;

import com.api.sigpat.model.TipoAtivo;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AtivoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String idPatrimonio;
    @NotBlank
    private TipoAtivo tipoAtivo;

}
