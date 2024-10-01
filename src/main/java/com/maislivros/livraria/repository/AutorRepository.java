package com.maislivros.livraria.repository;

/**
 *
 * @author Rangel
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.maislivros.livraria.entity.Autor;
                                                      //<model Autor e o tipo de dado, o tipo sempre vai ser uma classe, ou Integer ou Long, etc>
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
