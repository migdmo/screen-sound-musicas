package br.com.alura.desafio.repository;

import br.com.alura.desafio.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("SELECT a FROM Artista a WHERE LOWER(a.nome) = LOWER(:nome)")
    Optional<Artista> buscarPorNome(String nome);
}
