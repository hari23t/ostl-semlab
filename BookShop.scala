import scala.io.StdIn._
 
   case class Book(author: String, title: String, price: Double, publisher: String, stock: Int)

object BookShop{
  def main(args: Array[String]): Unit = {
    val books = List(
      Book("madhu", "Harry Potter", 450.0, "Bloomsbury", 10),
      Book("bhava", "Inferno", 550.0, "Doubleday", 5),
      Book("arjun", "Wings of Fire", 300.0, "Universities Press", 3),
      Book("kalai", "3 Mistakes of My Life", 200.0, "Rupa", 0)
    )
     println("Enter Book Title: ")
    val inputTitle = scala.io.StdIn.readLine()
    println("Enter Author Name: ")
    val inputAuthor = scala.io.StdIn.readLine()
    val foundBook = books.find(b => 
      b.title.equalsIgnoreCase(inputTitle) && 
      b.author.equalsIgnoreCase(inputAuthor)
    )
    foundBook match {
      case Some(book) =>
        println(s"Book Found: ${book.title} by ${book.author}")
        println(s"Price per copy: ${book.price}")
        println(s"Available stock: ${book.stock}")

        println("Enter number of copies required: ")
        val copies = scala.io.StdIn.readInt()

        if (copies <= book.stock) {
          val totalCost = copies * book.price
          println(s"Total Cost: $totalCost")
        } else {
          println("Required copies not in stock")
        }

      case None =>
        println("Book not available in the shop.")
    }
  }
}

