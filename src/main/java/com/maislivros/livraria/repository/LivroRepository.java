package com.maislivros.livraria.repository;

/**
 *
 * @author Rangel
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.maislivros.livraria.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
