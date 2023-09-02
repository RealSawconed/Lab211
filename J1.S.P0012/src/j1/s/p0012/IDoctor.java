package j1.s.p0012;

import java.util.Hashtable;

/**
 *
 * @author DatDDCE171299
 */
public interface IDoctor {

    /**
     * Add new doctor's data
     */
    public void add();

    /**
     * Update current doctor's data with code
     */
    public void update();

    /**
     * Delete current doctor's data with code
     */
    public void delete();

    /**
     * Search doctor's data with given information text
     *
     * @param str
     * @return
     */
    public Hashtable<String, DoctorHash> search(String str);
}
