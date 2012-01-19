package nijhof2axon.ui;

import com.vaadin.ui.Window;

import java.util.Collection;
import java.util.HashSet;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class MainWindow extends Window {

    private Collection<MediatorListener> collaborators = new HashSet<MediatorListener>();


    public void addCollaborator(MediatorListener collaborator) {
        collaborators.add(collaborator);
    }

    public void removeCollaborator(MediatorListener collaborator) {
        collaborators.remove(collaborator);
    }

    public void fireEvent(UIEvent event) {
        for (MediatorListener ml : collaborators) {
            ml.handleEvent(event);
        }
    }

}
