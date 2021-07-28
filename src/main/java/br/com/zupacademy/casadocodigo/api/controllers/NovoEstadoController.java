package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoEstadoRequest;
import br.com.zupacademy.casadocodigo.model.entities.Estado;
import br.com.zupacademy.casadocodigo.model.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.model.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class NovoEstadoController {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public void cadastra(@RequestBody @Valid NovoEstadoRequest request) {
        Estado estado = request.toModel(paisRepository);
        estadoRepository.save(estado);
    }
}
