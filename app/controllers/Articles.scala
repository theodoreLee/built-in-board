package controllers

import play.api.mvc._
import models._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.Messages

/**
 * Created with IntelliJ IDEA.
 * User: thlee
 * Date: 12. 12. 25.
 * Time: 오후 8:44
 * To change this template use File | Settings | File Templates.
 */
object Articles extends Controller {
  val articleForm = Form(
    mapping(
      "Title" -> nonEmptyText,
      "Contents" -> nonEmptyText,
      "Creator" -> nonEmptyText,
      "Password" -> nonEmptyText
    )(Article.apply)(Article.unApplyForCreate)
  )
  def getArticle(id: Long) = Action {
    val article = Article.get(id)

    article match {
      case None => Redirect(routes.Articles.list())
      case Some(a) => Ok(views.html.articles.item(a, Reply.getList(id)))
    }
  }

  def list = Action {
    Ok(views.html.articles.list(Article.getList))
  }

  def newPage = Action {implicit request=>
    Ok(views.html.articles.create(articleForm))
  }
  def create = Action { implicit request =>
    val newForm =articleForm.bindFromRequest
    newForm.fold(
    form => {
      //Todo - 좀 더 찾아볼 것.
      Ok(views.html.articles.create(form)).flashing(("error" -> Messages("validation.error")))
    },
    article => {
      Article.add(article) match {
        case Some(item) => Redirect(routes.Articles.list)
          //Todo - 좀 더 찾아 볼것..s
        case None => Ok(views.html.articles.create(newForm)).flashing(Flash(newForm.data)+("error" -> Messages("validation.error")))
      }
    })
  }

}
