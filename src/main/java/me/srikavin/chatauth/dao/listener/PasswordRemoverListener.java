package me.srikavin.chatauth.dao.listener;

import me.srikavin.chatauth.domain.RegistrationAttempt;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.PrePersist;
import java.time.Instant;
import java.util.Date;

@Configurable()
public class PasswordRemoverListener {
    @PrePersist
    public void removePasswordsAndSetTime(RegistrationAttempt login) {
        login.setPassword("<removed>");
        login.setCreation(Date.from(Instant.now()));
    }
}
