package com.maislivros.livraria.service;

/**
 *
 * @author Rangel
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maislivros.livraria.entity.Livro;
import com.maislivros.livraria.repository.LivroRepository;
import com.maislivros.livraria.service.EntityNotFound.EntityNotFound;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro create(Livro obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Livro getId(Long id) {
		Optional<Livro> obj = repository.findById(id);
                if(obj.isEmpty()){
                    throw new EntityNotFound("Autor de ID " + obj + " não encontrado");
                }
		return obj.get();
		
	}
	public List<Livro> getAll(){
		
		return repository.findAll();
	}
	
	public Livro update(Livro obj) {
		Optional<Livro> newObj = repository.findById(obj.getId());
                 if(newObj.isEmpty()){
                    throw new EntityNotFound("Autor de ID " + obj.getId() + " não encontrado");
                }
		updateLivro(newObj, obj);
		return repository.save(newObj.get());
	}
	
	private void updateLivro(Optional<Livro> newObj, Livro obj) {
		newObj.get().setNome(obj.getNome());
	}

}
