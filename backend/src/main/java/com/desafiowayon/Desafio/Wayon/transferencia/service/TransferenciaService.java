package com.desafiowayon.Desafio.Wayon.transferencia.service;

import com.desafiowayon.Desafio.Wayon.transferencia.exception.BusinessException;
import com.desafiowayon.Desafio.Wayon.transferencia.model.Transferencia;
import com.desafiowayon.Desafio.Wayon.transferencia.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/** created by @FNinety
 * Service responsável regras de negócio de agendamento de transferencias e busca de transferencias agendadas.
 */
@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    /**
     * Calcula a taxa baseada na diferença de dias entre agendamento(data atual) e realização da tranferencia.
     * @throws  BusinessException se data for maior que 50 dias ou no passado.
     */
    public Transferencia calcularTaxa(Transferencia transferencia) {
        transferencia.setDataAgendamento(LocalDate.now());
        long dias = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());
        BigDecimal taxa;
        if (dias <= -1 ) {
            throw new BusinessException("Não há taxa aplicável para transações no passado. Por favor informe uma data igual a hoje ou no futuro");
        }
        if (dias == 0) {
            taxa = transferencia.getValor().multiply(new BigDecimal("0.025"));
        } else if (dias >= 1 && dias <= 10) {
            taxa = new BigDecimal("0.00");
        } else if (dias >= 11 && dias <= 20) {
            taxa = transferencia.getValor().multiply(new BigDecimal("0.082"));
        } else if (dias >= 21 && dias <= 30) {
            taxa = transferencia.getValor().multiply(new BigDecimal("0.069"));
        } else if (dias >= 31 && dias <= 40) {
            taxa = transferencia.getValor().multiply(new BigDecimal("0.047"));
        } else if (dias >= 41 && dias <= 50) {
            taxa = transferencia.getValor().multiply(new BigDecimal("0.017"));
        } else {
            throw new BusinessException("Não há taxa aplicável para a quantidade de dias informada. Por favor informe uma data entre 1 e 50 dias.");
        }
        transferencia.setTaxa(taxa);
        return transferenciaRepository.save(transferencia);
    }

    /**
     * Busca todas as transferencias no banco de dados
     */
    public List<Transferencia> buscarTransferencias() {
        return transferenciaRepository.findAll();
    }
}
