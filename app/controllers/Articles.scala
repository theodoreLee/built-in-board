package controllers

import play.api.mvc.{Action, Controller}
import models.{Article, Reply}
import play.api.data._
import play.api.data.Forms._

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

  def newPage = Action {
    Ok(views.html.articles.create(articleForm))
  }
  def create = Action { implicit request =>
    articleForm.bindFromRequest.fold(
    error => {
      println(s"error :" + error.errors.toString())
      Ok("..")
    },
    okForm => {
      Article.add(okForm) match {
        case Some(article) => Redirect(routes.Articles.list)
        case None => Ok("-a-")
      }
    })
  }

}
