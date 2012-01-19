package nijhof2axon.app.init;

import nijhof2axon.app.command.CreateClientCommand;
import nijhof2axon.app.domain.Address;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.domain.AggregateIdentifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class SampleDataGenerator implements ApplicationListener {

    private CommandBus commandBus;
    private AtomicBoolean initialized = new AtomicBoolean();

    public SampleDataGenerator(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    public void onApplicationEvent(ApplicationEvent event) {
        if (!initialized.get() && event instanceof ContextRefreshedEvent) {
            initializeData();
        }
    }

    public void initializeData() {
        if (initialized.compareAndSet(false, true)) {

            //BKONU: Issue 6
            // query db, if no client found, add sample data

            commandBus.dispatch(new CreateClientCommand("Sample Client 1",
                    new Address("a street", "123", "123", "123"), "12345678"));

            //BKONU:
            // Ask repository
            //  for the client you created. then use it!
            // bus.dispatch(cmd, callback) should be used to be sure command is handled!!

            // (We dont have client id yet..)
            AggregateIdentifier clientId = null;
//            OpenNewAccountForClientCommand accountForClientCommand = new OpenNewAccountForClientCommand
//                    (clientId, "account name");
        }
    }
}
