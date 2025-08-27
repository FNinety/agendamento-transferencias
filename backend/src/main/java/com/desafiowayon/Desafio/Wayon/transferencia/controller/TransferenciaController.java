package com.desafiowayon.Desafio.Wayon.transferencia.controller;

import com.desafiowayon.Desafio.Wayon.transferencia.model.Transferencia;
import com.desafiowayon.Desafio.Wayon.transferencia.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafiowayon.Desafio.Wayon.transferencia.exception.BusinessException;

import java.util.List;

/** created by @FNinety
 * Controller REST responsável pelas APIS de agendamento de transferencias e busca de transferencias agendadas.
 */
@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;


    /**
     * Agenda uma nova transferência e calcula a taxa conforme a regra de negócio.
     *
     * @param transferencia objeto com dados enviados pelo cliente no POST
     * @return transferência salva, já com taxa e data de agendamento
     * @throws BusinessException se a transferência não for válida (ex: data acima de 50 dias)
     */
    @PostMapping("/agendar")
    public ResponseEntity<Transferencia> agendarTransferencia(@RequestBody Transferencia transferencia) {
        return ResponseEntity.ok(transferenciaService.calcularTaxa(transferencia));
    }

    /**
     * Busca no banco de dados em cash local todas as transferencias agendadas.
     * @return lista de transferências
     */
    @GetMapping
    public ResponseEntity<List<Transferencia>> listarTransferencias() {
        return ResponseEntity.ok(transferenciaService.buscarTransferencias());
    }
}
