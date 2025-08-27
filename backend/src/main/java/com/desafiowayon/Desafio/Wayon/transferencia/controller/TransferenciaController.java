package com.desafiowayon.Desafio.Wayon.transferencia.controller;

import com.desafiowayon.Desafio.Wayon.transferencia.model.Transferencia;
import com.desafiowayon.Desafio.Wayon.transferencia.repository.TransferenciaRepository;
import com.desafiowayon.Desafio.Wayon.transferencia.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// @CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping("/agendar")
    public ResponseEntity<Transferencia> agendarTransferencia(@RequestBody Transferencia transferencia) {
        return ResponseEntity.ok(transferenciaService.calcularTaxa(transferencia));
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listarTransferencias() {
        return ResponseEntity.ok(transferenciaService.buscarTransferencias());
    }
}
