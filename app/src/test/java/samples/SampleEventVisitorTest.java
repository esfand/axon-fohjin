package samples;

import org.axonframework.domain.DomainEvent;
import org.axonframework.eventstore.EventVisitor;
import org.axonframework.eventstore.jpa.JpaEventStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author: Bahadýr Konu (bah.konu@gmail.com)
 * <p/>
 * An example on replaying events from an event store.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/META-INF/spring/application-context.xml", "/META-INF/spring/database-context.xml"})
public class SampleEventVisitorTest {

    @Autowired
    private JpaEventStore eventStore;

    @Test
    public void visitEvents() {
        eventStore.visitEvents(new MyEventVisitor());
    }

    private class MyEventVisitor implements EventVisitor {
        @Override
        public void doWithEvent(DomainEvent domainEvent) {
            //Do whatever you want
            System.out.println(domainEvent.toString());
        }
    }
}
