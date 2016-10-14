package prova;
import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import servizi.ServizioRubrica;

public class TestHQLRubrica {

	public static void main(String[] args) {


		ServizioRubrica sRub= new ServizioRubrica();
		
		System.out.println(sRub.registraRubrica("aaaaa"));
					
		RubricaDao rDao=new RubricaDao();

		Rubrica r=rDao.leggiRubricaConId(1);
		System.out.println(r.getId_Rubrica()+" "+r.getNome());
		
		sRub.aggiungiVoce(r,"vv", "ccc", "tel");
		for (Voce v:r.getVoci()){
			System.out.println(v.getId_voce()+" "+v.getNome());
		}
		
		

	}



}
