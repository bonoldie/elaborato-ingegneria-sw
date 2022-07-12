package elaborato.DAO;

import java.util.List;

public interface ILinguaDAO {
	public List<Lingua> getAllLingue();

	public Lingua getLingua(int id_lingua);

	public void updateLingua(Lingua lingua);

	public void deleteLingua(Lingua lingua);
}
