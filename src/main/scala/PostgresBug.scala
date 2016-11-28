import com.twitter.finagle.Postgres
import com.twitter.util.Await


object PostgresBug extends App {
  val client = Postgres.Client()
      .withCredentials("pgsql", Some("pgsql"))
      .database("pgsql")
      .withSessionPool.maxSize(10)
      .newRichClient("db:5432")

  val create = client.execute("CREATE TABLE IF NOT EXISTS items (id SERIAL NOT NULL PRIMARY KEY, name VARCHAR(255))")
  Await.result(create)

  val insert = client.select("INSERT INTO items (name) VALUES ('item_name') RETURNING id") { row =>
    println(row.get[Int]("id"))
  }
  Await.result(insert)

  println("Done")
}
