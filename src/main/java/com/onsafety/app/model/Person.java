package com.onsafety.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank (message = "Nome é obrigatório!")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank (message = "CPF é obrigatório!")
    @CPF(message = "CPF inválido!")
    private String cpf;

    @Column(nullable = false)
    @Past(message = "A data de nascimento deve ser anterior à data atual")
    private LocalDate birthDate;

    @Column(nullable = false)
    @Email(message = "Email inválido!")
    private String email;

}
