package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES", "default"}) // You can have more than one active profile for your bean:
// Use default, and it let's you use ES by default without adding it to application.properties
//@Profile("ES")
@Service("i18nService") // With 'inferred' Qualifier
public class I18nSpanishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
