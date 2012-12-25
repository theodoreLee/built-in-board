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
  var replies = Set(Reply(123,1,"contents","play1","play1"),
    Reply(234,2,"contents","play2","play2"),
    Reply(345,3,"contents","play3","play3"),
    Reply(2,4,"contents","play4","play4"),
    Reply(12,5,"contents","play5","play5"),
    Reply(13,6,"contents","play6","play6"))
}
