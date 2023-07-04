package com.generation.salveraiz.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;




@Entity
@Table(name = "tb_Postagem")
public class Postagem {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull(message = "titulo é obrigatório")
		private String titulo;
		
		@NotNull
		@Size(min = 10, max = 500)
		private String texto;
		
		@UpdateTimestamp
		private LocalDateTime data;
		
		@NotNull

		private String foto;
		
		

		private Long curtidas;

		
		@ManyToOne
		@JsonIgnoreProperties("postagem") 
		private Tema tema;   
		
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public LocalDateTime getData() {
			return data;
		}

		public void setData(LocalDateTime data) {
			this.data = data;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public Long getCurtidas() {
			return curtidas;
		}

		public void setCurtidas(Long curtidas) {
			this.curtidas = curtidas;
		}
		
		
		

}
