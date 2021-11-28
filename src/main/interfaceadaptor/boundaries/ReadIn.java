package interfaceadaptor.boundaries;

import java.util.ArrayList;

/**
 * This interface is used for dependency inversion when we need to read from the database and take that information into
 * inner layers.
 */

public interface ReadIn {
    public ArrayList<ArrayList<String>> csv_to_list(String s);
}
