package com.generation.salveraiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.salveraiz.model.Postagem;



public interface PostagemRepository extends JpaRepository <Postagem,Long> {
	
	public List<Postagem>findAllByTituloContainingIgnoreCase(@Param("Titulo")String titulo);

}
