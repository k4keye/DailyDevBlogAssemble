package com.birariro.playday.service.email;

import com.birariro.playday.adapter.email.EmailAdapter;
import com.birariro.playday.adapter.event.registration.NewRegistrationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final EmailAdapter emailAdapter;

    @EventListener(NewRegistrationEvent.class)
    public void event(NewRegistrationEvent event){
        log.info("RegistrationEvent email : "+event.getEmail());
        emailAdapter.authenticationCodeSend(event.getEmail());
    }

}
