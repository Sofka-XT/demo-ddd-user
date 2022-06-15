package co.com.sofka.user.values;

import co.com.sofka.domain.generic.ValueObject;

public class Category implements ValueObject<String> {
    private final String value;

    public Category(String value) {

        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
