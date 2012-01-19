package nijhof2axon.ui;

import com.vaadin.ui.VerticalLayout;
import org.axonframework.commandhandling.CommandBus;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class MediatorVerticalLayout extends VerticalLayout {

    @Override
    public Nijhof2AxonApplication getApplication() {
        return (Nijhof2AxonApplication) super.getApplication();
    }

    public void fire(UIEvent event) {
        getApplication().getMainWindow().fireEvent(event);
    }

}
