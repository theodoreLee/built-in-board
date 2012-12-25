package controllers

import play.mvc.Controller
import play.api.mvc._
import play.api.mvc.Results._
import models.Article

/**
 * Created with IntelliJ IDEA.
 * User: thlee
 * Date: 12. 12. 25.
 * Time: 오후 8:44
 * To change this template use File | Settings | File Templates.
 */
object Articles extends Controller{
  def getArticle(id:Long) = Action {
    NotImplemented
  }

  def showList = Action {
    Ok(views.html.articles.list(Article.getList))
  }

}
