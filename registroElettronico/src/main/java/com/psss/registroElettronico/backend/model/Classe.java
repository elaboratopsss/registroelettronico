package com.psss.registroElettronico.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "classi")
public class Classe {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private int anno;
    private Character sezione;
    private int annoScolastico;

    @ManyToMany()
    private List<Materia> materie;
    @OneToMany
    private List<Assegno> assegni;
    @ManyToMany
    private List<Docente> docenti;
    @OneToMany
    private List<Studente> studenti;



}