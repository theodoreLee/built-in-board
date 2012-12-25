package models

/**
 * Created with IntelliJ IDEA.
 * User: thlee
 * Date: 12. 12. 25.
 * Time: 오후 6:49
 * To change this template use File | Settings | File Templates.
 */

case class Article(id:Long,
                   title:String,
                   contents:String,
                   name:String,
                   password:String) {
}

object Article {
  var data = Set(
    Article(1,"Hi", "test", "thlee","1234"),
    Article(2,"메렁~", "믕믕믕", "thlee","1234"),
    Article(3,"ㅋㅋㅋㅋㅋ", "뭥미~? ㅋ", "thlee","1234")
  )

  private def getNextID = this.data.size + 1

  def getList:List[Article] = data.toList.sortBy(_.id)

  def add(item:Article):Option[Article] = {
    item.id match {
      case -1 =>
        val newItem = apply(item.title,item.contents,item.name,item.password)
        this.data = this.data + newItem
        Some(newItem)
      case id if (this.data.find((article) => article.id == item.id).isEmpty) =>
        None
      case id =>
        this.data = this.data + item
        Some(item)
    }
  }

  def apply(title:String,contents:String,name:String,password:String):Article = {
    Article(getNextID,title,contents,name,password)
  }
}