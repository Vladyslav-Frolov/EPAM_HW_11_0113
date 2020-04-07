package info.vladyslav.EPAM_HW_11_0113.repository;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {
    // create (Crud)

    void create(T t) throws IOException;

    // read (cRud)

    T getById(ID id);

    Long getLastId() throws IOException;

    List<T> getAll() throws IOException;

    // update (crUd)

    void update(ID idForUpdate, T infoForUpdate) throws IOException;

    // delete (cruD)

    void delete(T t) throws IOException;
    // total delete is not permitted for Account and Developer, that's why this function not realized for this entities
}
