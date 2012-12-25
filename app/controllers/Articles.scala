package controllers

import play.api.mvc.{Action, Controller}
import models.{Article, Reply}

/**
 * Created with IntelliJ IDEA.
 * User: thlee
 * Date: 12. 12. 25.
 * Time: 오후 8:44
 * To change this template use File | Settings | File Templates.
 */
object Articles extends Controller{
  def getArticle(id:Long) = Action {
  val article = Article.get(id)

    article match{
     case None =>    Redirect(routes.Articles.showList())
      case Some(a) =>  Ok(views.html.articles.item(a, Reply.getList(id)))
    }



  }

  def showList = Action {
    NotImplemented
  }

}
