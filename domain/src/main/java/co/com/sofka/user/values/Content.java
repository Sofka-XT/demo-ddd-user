package co.com.sofka.user.values;

import co.com.sofka.domain.generic.ValueObject;

public class Content implements ValueObject<String> {
    private final String value;

    public Content(String value) {

        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
