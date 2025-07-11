package br.ufra.nap01.controller;

import br.ufra.nap01.model.Produto;
import br.ufra.nap01.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoRepository repository;

    // GET /produtos
    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // GET /produtos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /produtos
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto salvo = repository.save(produto);
        return ResponseEntity.status(201).body(salvo);
    }

    // PUT /produtos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto novo) {
        return repository.findById(id)
                .map(p -> {
                    p.setNome(novo.getNome());
                    p.setDescricao(novo.getDescricao());
                    p.setPreco(novo.getPreco());
                    p.setQuantidade(novo.getQuantidade());
                    return ResponseEntity.ok(repository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /produtos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
