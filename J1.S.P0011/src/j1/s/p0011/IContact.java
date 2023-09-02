package j1.s.p0011;

import java.util.List;

/**
 *
 * @author DatDDCE171299
 */
public interface IContact {

    /**
     * Add new contact with given information
     */
    public void addContact();

    /**
     * Return contact information with given ID
     *
     * @param id
     * @return
     */
    public Contact display(int id);

    /**
     * Delete contact with given ID
     *
     * @param id
     */
    public void deleteContact(int id);
}
