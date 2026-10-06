package br.org.edu.ifrn.usuarioatv.controller;

import br.org.edu.ifrn.usuarioatv.model.Usuario;
import br.org.edu.ifrn.usuarioatv.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {

        Usuario usuarioSalvo = usuarioService.salvar(usuario);

        return ResponseEntity.ok(usuarioSalvo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {

        return ResponseEntity.ok(
                usuarioService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(
            @PathVariable Long id) {

        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        return ResponseEntity.ok(
                usuarioService.atualizar(id, usuario)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}