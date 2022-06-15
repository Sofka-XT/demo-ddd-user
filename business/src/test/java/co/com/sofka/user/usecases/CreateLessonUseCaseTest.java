package co.com.sofka.user.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.user.LessonFactory;
import co.com.sofka.user.command.CreateLessonCommand;
import co.com.sofka.user.events.CreatedStudent;
import co.com.sofka.user.events.LessonAdded;
import co.com.sofka.user.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateLessonUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CreateLessonUseCase useCase;

    @Test
     void agregarLeccionAlEstudiante(){
        //arrange
        LessonFactory factory = LessonFactory.getInstance()
                .add(LessonId.of("xxxx"), new Content("prueba unitaria"), new Category("testing"), new LessonType(LessonType.Types.TEXT))
                .add(LessonId.of("yyyy"), new Content("prueba integrales"), new Category("testing"), new LessonType(LessonType.Types.TEXT));

        StudentId id = new StudentId();
        var command = new CreateLessonCommand(factory, id);
        when(repository.getEventsBy(id.value())).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(2, events.size());

    }

    private List<DomainEvent> history() {
        Username username = new Username("raulalzate");
        Password password = new Password("xxxxx");
        Email email = Email.of("alzategomez.raul@gmail.com");
        return List.of(
                new CreatedStudent(username, password, email),
                new LessonAdded(LessonId.of("fffff"),
                        new Content("prueba unitaria"),
                        new Category("testing"),
                        new LessonType(LessonType.Types.TEXT)
                ));
    }
}