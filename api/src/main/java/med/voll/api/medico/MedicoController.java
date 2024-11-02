package med.voll.api.medico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Getter;
import med.voll.api.controller.DadosCadastroMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
//teste
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
       repository.save(new Medico(dados));

    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
