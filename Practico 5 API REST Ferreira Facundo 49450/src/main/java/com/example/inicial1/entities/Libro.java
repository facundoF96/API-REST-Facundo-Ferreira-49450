package com.example.inicial1.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = "libro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@Setter
@Audited
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    private int fecha;
    @Column(name = "genero")
    private String genero;
    @Column(name = "paginas")
    private int paginas;
    @Column(name = "autor")
    private String autor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "fk_libro"),
            inverseJoinColumns = @JoinColumn(name = "fk_autor")
    )
    private List<Autor> autores;
}