package me.srikavin.chatauth.domain;

import me.srikavin.chatauth.dao.listener.PasswordRemoverListener;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(PasswordRemoverListener.class)
public class RegistrationAttempt extends Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;
    @Embedded
    @Valid
    private Name name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
