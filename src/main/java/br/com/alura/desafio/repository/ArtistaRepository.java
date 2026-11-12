package br.com.alura.desafio.repository;

import br.com.alura.desafio.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
