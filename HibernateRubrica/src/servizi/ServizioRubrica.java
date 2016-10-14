package servizi;

import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import dao.VoceDao;

public class ServizioRubrica {

	private VoceDao vDao=new VoceDao();
	private RubricaDao rDao=new RubricaDao();

	//metodo per registrare la rubrica
	public boolean registraRubrica(String nome){

		boolean res=false;

		Rubrica r=new Rubrica(nome);

		res=rDao.creaRubrica(r);

		return res;
	}
	
	
	//metodo per aggiungere la voce
	public boolean aggiungiVoce(Rubrica r,String nome, String cognome,String tel){

		boolean res= false;


		Voce v= new Voce(nome,cognome,tel);

		v.setRubrica(r);

		r.aggiungiVoce(v);


		vDao.creaVoce(v);

		rDao.aggiornaRubrica(r);


		return res;
	}

	//metodo per aggiornare la voce
	
	
	
	
	
	//metodo per prendere tutte le voci di una rubrica
	//elimina voce dalla rubrica

}
