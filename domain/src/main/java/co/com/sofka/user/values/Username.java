package co.com.sofka.user.values;

import co.com.sofka.domain.generic.ValueObject;

public class Username implements ValueObject<String> {
    private final String value;

    public Username(String value) {
        //TODO: validations
        this.value = value;
    }

    public String value() {
        return value;
    }
}
