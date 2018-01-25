package me.srikavin.chatauth.dao;

import me.srikavin.chatauth.domain.RegistrationAttempt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends CrudRepository<RegistrationAttempt, Long> {
}
