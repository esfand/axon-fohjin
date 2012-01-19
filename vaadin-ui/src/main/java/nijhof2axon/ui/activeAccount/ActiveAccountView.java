package nijhof2axon.ui.activeAccount;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.MediatorVerticalLayout;
import nijhof2axon.ui.UIEvent;
import nijhof2axon.ui.data.LedgerContainer;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ActiveAccountView extends MediatorVerticalLayout implements MediatorListener {
    private ActiveAccountDetailsForm activeAccountDetailsForm;
    private LedgerList ledgerList;


    public ActiveAccountView() {
        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.setWidth("50%");
        mainVerticalLayout.setSizeFull();

        VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
        verticalSplitPanel.setHeight("900px");
        verticalSplitPanel.setWidth("100%");
        verticalSplitPanel.setSplitPosition(25, Sizeable.UNITS_PERCENTAGE);

        activeAccountDetailsForm = new ActiveAccountDetailsForm();
        ledgerList = new LedgerList();

        verticalSplitPanel.setFirstComponent(activeAccountDetailsForm);
        verticalSplitPanel.setSecondComponent(ledgerList);

        mainVerticalLayout.addComponent(verticalSplitPanel);

        addComponent(mainVerticalLayout);
    }

    @Override
    public void handleEvent(UIEvent event) {
        activeAccountDetailsForm.handleEvent(event);
        ledgerList.handleEvent(event);
    }
}
