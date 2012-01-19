import nijhof2axon.app.command.DepositCashCommand;
import nijhof2axon.app.commandHandler.DepositCashCommandHandler;
import nijhof2axon.app.domain.ActiveAccount;
import nijhof2axon.app.event.CashDepositedEvent;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * User: Bahadir Konu (bah.konu@gmail.com)
 */
public class WhenDepositingCash {

    private FixtureConfiguration fixture;

    @Before
    public void setUp() {
        fixture = Fixtures.newGivenWhenThenFixture();
        DepositCashCommandHandler depositCashCommandHandler = new DepositCashCommandHandler();

        depositCashCommandHandler.setActiveAccountRepository(fixture.createGenericRepository(ActiveAccount.class));

        fixture.registerAnnotatedCommandHandler(depositCashCommandHandler);
    }

    @Test
    public void cash_deposited_event_will_be_published() {

        String identifier = fixture.getAggregateIdentifier().asString();

        fixture.given(
                new CashDepositedEvent(identifier, BigDecimal.valueOf(100), BigDecimal.valueOf(100))
        )
                .when(new DepositCashCommand(identifier, BigDecimal.valueOf(20)))
                .expectEvents(new CashDepositedEvent(identifier, BigDecimal.valueOf(120), BigDecimal.valueOf(20)))
                ;
    }
}