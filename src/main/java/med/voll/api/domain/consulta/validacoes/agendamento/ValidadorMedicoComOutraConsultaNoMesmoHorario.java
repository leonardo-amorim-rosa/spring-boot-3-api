package med.voll.api.domain.consulta.validacoes.agendamento;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta {

    private final ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var idMedico = dados.idMedico();

        if (repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(idMedico, dataConsulta)) {
            throw new ValidacaoException("Já existe uma consulta agendada nesse dia e horário para esse médico!");
        }
    }

}
