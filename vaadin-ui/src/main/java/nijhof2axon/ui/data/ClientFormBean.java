package nijhof2axon.ui.data;

import java.io.Serializable;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientFormBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
