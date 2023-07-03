package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
//        @JsonAlias({"medico_id", "id_medico"}) // podemos especificar o nome declarado no contrato
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
//        @JsonFormat(pattern = "dd/MM/yyyy HH:mm") // podemos especificar o formato recebido
        LocalDateTime data,
        Especialidade especialidade) {
}
