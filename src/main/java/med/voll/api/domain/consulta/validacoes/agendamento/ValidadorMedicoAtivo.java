package med.voll.api.domain.consulta.validacoes.agendamento;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {

    private final MedicoRepository repository;
    public void validar(DadosAgendamentoConsulta dados) {
        var idMedico = dados.idMedico();

        boolean medicoEstaAtivo = repository.findAtivoBytId(idMedico);
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("O médico escolhido não está ativo!");
        }
    }
}
