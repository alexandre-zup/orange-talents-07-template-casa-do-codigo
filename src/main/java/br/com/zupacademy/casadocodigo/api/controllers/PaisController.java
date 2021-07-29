package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoPaisRequest;
import br.com.zupacademy.casadocodigo.model.entities.Pais;
import br.com.zupacademy.casadocodigo.model.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public void cadastra(@RequestBody @Valid NovoPaisRequest request) {
        Pais pais = request.toModel();
        repository.save(pais);
    }
}
