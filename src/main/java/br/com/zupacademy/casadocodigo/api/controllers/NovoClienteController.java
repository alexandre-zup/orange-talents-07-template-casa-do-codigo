package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoClienteRequest;
import br.com.zupacademy.casadocodigo.api.dto.response.IdResponse;
import br.com.zupacademy.casadocodigo.model.entities.Cliente;
import br.com.zupacademy.casadocodigo.model.repositories.ClienteRepository;
import br.com.zupacademy.casadocodigo.model.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.model.repositories.PaisRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class NovoClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    private CNPJValidator cnpjValidator;
    private CPFValidator cpfValidator;

    @PostMapping
    public ResponseEntity<IdResponse> cadastra(@RequestBody @Valid NovoClienteRequest request) {
        Cliente cliente = request.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(new IdResponse(cliente.getId()));
    }

}
