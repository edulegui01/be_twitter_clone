package com.app.twitterClone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @Column(nullable = false, length = 20)
    @NotBlank(message = "Este campo es obligatorio")
    private String username;

    @Column(nullable = false, length = 300)
    @NotBlank(message = "Este campo es obligatorio")
    private String nombre;

    @Column(nullable = false, length = 300)
    @NotBlank(message = "Este campo es obligatorio")
    private String apellido;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Este campo es obligatorio")
    private String password;

    @Column(length = 50,unique = true)
    @Email(message = "Debe ser un correo valido")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Tweet> tweets;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
