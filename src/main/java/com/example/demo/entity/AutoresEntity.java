package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AUTORES")
public class AutoresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@Column(name = "IdAutor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAutores")
    @SequenceGenerator(name = "seqAutores", allocationSize = 1, sequenceName = "SEQ_AUTORES")
	private Long id;
  
  	@Column(name = "AUTOR")
  	private String autor;
  	
  	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autores")
	@JsonIgnore
	private Set<LibrosEntity> libros;
  	
  	
}