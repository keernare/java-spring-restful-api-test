package uk.co.huntersix.spring.rest.referencedata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.huntersix.spring.rest.model.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class PersonDataServiceTest {

    @InjectMocks
    private PersonDataService personDataService;

    @Test
    public void findPersonTest() {
        List<Person> person = personDataService.findPerson("Smith", "Mary");
        assertEquals(person.get(0).getFirstName(), "Mary");
    }

    @Test
    public void findPersonEmptyString() {
        List<Person> person = personDataService.findPerson("", "");
        assertThat(person.isEmpty());
    }

    @Test
    public void findPersonNotFound() {
        List<Person> person = personDataService.findPerson("WillSmith", "Mary");
        assertThat(person.isEmpty());
    }
}
