package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Meta;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	static Form<Meta> metaForm = Form.form(Meta.class);
	private static GenericDAO dao = new GenericDAOImpl();

    public static Result index() {
    	return redirect(routes.Application.metas());
    }
	
	@Transactional
	public static Result metas(){
		List<Meta> result = getDao().findAllByClassName("Meta");
		return ok(views.html.index.render(result, metaForm));
	}
	
	@Transactional
	public static Result novaMeta(){
		List<Meta> result = getDao().findAllByClassName("Meta");
		Form<Meta> filledForm = metaForm.bindFromRequest();
		if (filledForm.hasErrors()){
			return badRequest(views.html.index.render(result, filledForm));
		} else {
			getDao.persist(filledForm.get());
			getDao.flush();
			return redirect(routes.Application.metas());
		}
	}
	
	@Transactional
	public static Result addDescricao(Long id, String descricao){
		Meta metaDaListagem = getDao().findByEntityId(Meta.class, id);
		metaDaListagem.setDescricao().add(descricao);
		getDao().merge(metaDaListagem);
		getDao().flush();
		List<Meta> result = getDao().findAllByClassName("Meta");
		return ok(views.html.index.render(result, metaForm));
	}
	
	@Transactional
	public static Result apagaMeta(Long id){
		getDao().removeById(Livro.class, id);
		getDao().flush();
		return redirect(routes.Application.metas());
	}
	
	public static GenericDAO getDao(){
		return dao;
	}
	
	public static void setDao(GenericDAO dao){
		Application.dao = dao;
	}

}
