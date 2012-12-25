package models

/**
 * Created with IntelliJ IDEA.
 * User: yoonjilee
 * Date: 12. 12. 25.
 * Time: 오후 7:24
 * To change this template use File | Settings | File Templates.
 */
case class Reply(id: Long, ArticleId: Long, contents: String, name: String, password: String)

object Reply {
  var replies = Set(Reply(1, 1, "contents", "play1", "play1"),
    Reply(2, 3, "contents", "play2", "play2"),
    Reply(3, 2, "contents", "play3", "play3"),
    Reply(4, 3, "contents", "play4", "play4"),
    Reply(5, 2, "contents", "play5", "play5"),
    Reply(6, 4, "contents", "play6", "play6"))

  private def getNextID = this.replies.size + 1

  def add(reply: Reply) = this.replies + reply

  //현재 소스 너무 길어서 엔터 침 -ㅁ-
  //올리기 전에 반드시 코드 리포멧 할 것
  def getList(articleId: Long): List[Reply]
  = this.replies.filter((r: Reply) => r.ArticleId == articleId).toList.sortBy(_.id)

  //Todo - Article 보고 apply 구현해 놓을 것. add도 비슷한 형식으로 바꿀 것
}
