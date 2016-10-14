package dao;

import HibernateUtil.HibernateUtil;

import model.Voce;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VoceDao {


	// 1- Create 

	public boolean creaVoce(Voce v){
		boolean res=false;


		Session session=HibernateUtil.openSession();

		Transaction tx=null;

		try{

			tx=session.getTransaction();

			tx.begin();

			session.persist(v); 


			tx.commit(); 
			res=true;
		}catch(Exception ex){

			tx.rollback();


		}finally{
			session.close();
		}



		return res;

	}




	// 2- Create 

	public boolean creaVoce2(String nome,String cognome,String telefono){
		boolean res=false;


		Session session=HibernateUtil.openSession();

		Transaction tx=null;
		Voce v=new Voce(nome,cognome,telefono);
		try{

			tx=session.getTransaction();

			tx.begin();

			session.persist(v); 


			tx.commit(); 
			res=true;
		}catch(Exception ex){

			tx.rollback();


		}finally{
			session.close();
		}



		return res;

	}


	// 3- Read ( con Id)

	public Voce leggiVoceConId(long v_id){

		Voce v=null;
		Session session=HibernateUtil.openSession();

		Transaction tx=null;

		try{

			tx=session.getTransaction();

			tx.begin();


			v=session.get(Voce.class, v_id); 

			tx.commit(); 

		}catch(Exception ex){

			tx.rollback();


		}finally{
			session.close();
		}



		return v;

	}


	// 4- Read ( con nome,cognome e telefono )

	public Voce leggiVoceConNomCognTel(String nome,String cognome,String telefono) {
		Voce v = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			Query query = session
					.createQuery("from Voce where nome=:nomeInserito and cognome:=cognomeInserito and telefono:=telInserito ");

			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			query.setString("telInserito", telefono);

			v = (Voce) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return v;

	}


	// 5- Update 

	public boolean aggiornaVoce(Voce v){
		boolean res=false;



		Session session=HibernateUtil.openSession();

		Transaction tx=null;

		try{

			tx=session.getTransaction();

			tx.begin();

			session.update(v); 


			tx.commit(); 
			res=true;
		}catch(Exception ex){

			tx.rollback();


		}finally{
			session.close();
		}



		return res;

	}

	//6-delete
	
	public boolean rimuoviVoce(String nome,String cognome,String telefono){
		boolean res=false;


		Session session=HibernateUtil.openSession();

		Transaction tx=null;
		Voce v=null;
		try{

			tx=session.getTransaction();

			tx.begin();
			v=leggiVoceConNomCognTel(nome, cognome, telefono);
			session.delete(v);


			tx.commit(); 
			res=true;
		}catch(Exception ex){

			tx.rollback();


		}finally{
			session.close();
		}



		return res;

	}

	//7-delete
	
		public boolean rimuoviVoce2(long v_id){
			boolean res=false;

			Voce v=null;
			Session session=HibernateUtil.openSession();

			Transaction tx=null;
			
			try{

				tx=session.getTransaction();

				tx.begin();
				v=session.get(Voce.class, v_id);
				session.delete(v);


				tx.commit(); 
				res=true;
			}catch(Exception ex){

				tx.rollback();


			}finally{
				session.close();
			}



			return res;

		}


}
