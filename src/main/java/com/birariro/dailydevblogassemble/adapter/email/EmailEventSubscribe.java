package com.birariro.dailydevblogassemble.adapter.email;

import com.birariro.dailydevblogassemble.adapter.batch.step.event.DailyDocumentEvent;
import com.birariro.dailydevblogassemble.domain.member.event.NewRegistrationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailEventSubscribe {

    private final EmailService emailService;

    @EventListener(NewRegistrationEvent.class)
    public void event(NewRegistrationEvent event){
        log.info("RegistrationEvent email : "+event.getEmail());
        emailService.authenticationCodeSend(event.getEmail(), event.getAuthCode());
    }

    @EventListener(DailyDocumentEvent.class)
    public void sendDailyDocument(DailyDocumentEvent event){
        emailService.toDayDocumentsSend(event.getDocuments());
    }
}
