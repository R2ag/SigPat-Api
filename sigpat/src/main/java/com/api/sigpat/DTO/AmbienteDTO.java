package com.api.sigpat.DTO;

import com.api.sigpat.model.Ambiente;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class AmbienteDTO {
    @NotBlank
    private String nome;

    private Ambiente filiacao;

    @NotBlank
    private String endereco;
    @NotBlank
    private String cidade;
    @NotBlank
    private String Estado;
}
