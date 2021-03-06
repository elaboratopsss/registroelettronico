package com.psss.registro;

import com.psss.registro.app.security.User;
import com.psss.registro.app.security.UserAuthority;
import com.psss.registro.app.security.UserAuthorityRepository;
import com.psss.registro.app.security.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EventListenerInitialize {

    private static final Logger logger = LoggerFactory.getLogger(EventListenerInitialize.class);

    private final UserRepository userRepository;
    private final UserAuthorityRepository userAuthorityRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabase() {
        // Decommentare la prima volta per popolare il database
//         logger.info("Initializing database");
//         UserAuthority segretarioAuthority = new UserAuthority("SEGRETARIO");
//         UserAuthority docenteAuthority = new UserAuthority("DOCENTE");
//         UserAuthority studenteAuthority = new UserAuthority("STUDENTE");
//
//         User segretario = new User("admin@gmail.com", passwordEncoder.encode("admin"));
//
//         segretario.setUserAuthority(segretarioAuthority);
//         segretarioAuthority.addUser(segretario);
//         userAuthorityRepository.saveAndFlush(segretarioAuthority);
//         userAuthorityRepository.saveAndFlush(docenteAuthority);
//         userAuthorityRepository.saveAndFlush(studenteAuthority);
//         userRepository.saveAndFlush(segretario);
    }
}