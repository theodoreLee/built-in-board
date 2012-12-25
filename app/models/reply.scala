package models

/**
 * Created with IntelliJ IDEA.
 * User: yoonjilee
 * Date: 12. 12. 25.
 * Time: 오후 7:24
 * To change this template use File | Settings | File Templates.
 */
case class Reply(id:Long, ArticleId:Long, contents:String, name:String, password:String )
object Reply {
  var replies = Set(Reply(1,1,"contents","play1","play1"),
    Reply(2,3,"contents","play2","play2"),
    Reply(3,2,"contents","play3","play3"),
    Reply(4,3,"contents","play4","play4"),
    Reply(5,2,"contents","play5","play5"),
    Reply(6,4,"contents","play6","play6"))

  private def getNextID = this.replies.size + 1

  def add(reply:Reply)=this.replies + reply

  def getList(articleId:Long):List[Reply]=this.replies.filter((r:Reply) => r.ArticleId == articleId).toList().sortBy(_.id)
}
