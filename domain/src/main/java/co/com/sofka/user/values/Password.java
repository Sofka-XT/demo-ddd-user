package co.com.sofka.user.values;

import co.com.sofka.domain.generic.ValueObject;

public class Password implements ValueObject<String> {
    private final String value;

    public Password(String value) {
        //TODO: validations

        this.value = value;
    }

    public String value() {
        return value;
    }
}
