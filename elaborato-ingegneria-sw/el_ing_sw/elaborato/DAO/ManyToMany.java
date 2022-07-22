package elaborato.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ManyToMany<T,S> {
	void sync(T pivot, List<S> syncArray) throws SQLException;
}
