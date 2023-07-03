package med.voll.api.domain.consulta.validacoes.agendamento;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta {

    private final PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var idPaciente = dados.idPaciente();

        var pacienteEstaAtivo = repository.findAtivoById(idPaciente);
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("O paciente informado não está ativo!");
        }
    }

}
