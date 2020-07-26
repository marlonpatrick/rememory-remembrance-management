package io.mpwtech.randommemories.memoriesmanagement.rest.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import io.mpwtech.randommemories.crosscutting.exception.GenericTechnicalException;

@WebListener
public class PreventHttpSessionListener implements HttpSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreventHttpSessionListener.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        LOGGER.warn("Invalidating HttpSession...");

        se.getSession().invalidate();

        throw new GenericTechnicalException(messageSource.getMessage(
                "this_application_is_stateless_must_not_create_http_sessions", null,
                request.getLocale()));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //
    }
}
