package com.sertsev.money_transfer_api_act.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance = 0.0;

    @NotBlank(message = "First name is mandatory.")
    @Column(nullable = false)
    @Size(max = 15, min = 3)
    private String firstName;

    @NotBlank(message = "Middle name is mandatory.")
    @Column(nullable = false)
    @Size(max = 15, min = 3)
    private String middleName;

    @NotBlank(message = "Last name is mandatory.")
    @Column(nullable = false)
    @Size(max = 15, min = 3)
    private String lastName;

    @NotBlank(message = "Email is mandatory.")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "Birthday Should be date!")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank(message = "Phone number is mandatory.")
    @Column(nullable = false, unique = true)
    @Size(max = 18, min = 8)
    private String phoneNumber;

    @NotNull(message = "PIN or Password is mandatory.")
    @Column(nullable = false)
    private Integer pin;

    private Boolean isVerified = Boolean.TRUE;

}











