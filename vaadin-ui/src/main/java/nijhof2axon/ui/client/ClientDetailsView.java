package nijhof2axon.ui.client;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.MediatorVerticalLayout;
import nijhof2axon.ui.UIEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientDetailsView extends MediatorVerticalLayout implements MediatorListener {
    private ClientDetailsForm clientDetailsForm;
    private ActiveAccountList activeAccountList;

    public ClientDetailsView() {
                
        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.setWidth("50%");
        mainVerticalLayout.setSizeFull();

        VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
        verticalSplitPanel.setHeight("900px");
        verticalSplitPanel.setWidth("100%");
        verticalSplitPanel.setSplitPosition(30, Sizeable.UNITS_PERCENTAGE);

        clientDetailsForm = new ClientDetailsForm();
        activeAccountList = new ActiveAccountList();

        verticalSplitPanel.setFirstComponent(clientDetailsForm);
        verticalSplitPanel.setSecondComponent(activeAccountList);

        mainVerticalLayout.addComponent(verticalSplitPanel);

        addComponent(mainVerticalLayout);


    }

    @Override
    public void handleEvent(UIEvent event) {
        clientDetailsForm.handleEvent(event);
        activeAccountList.handleEvent(event);
    }

}
