package co.com.sofka.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.user.values.Fullname;

public class ChangedFullname extends DomainEvent {
    private final Fullname fullname;

    public ChangedFullname(Fullname fullname) {
        super("user.ChangedFullname");
        this.fullname = fullname;
    }

    public Fullname getFullname() {
        return fullname;
    }
}
