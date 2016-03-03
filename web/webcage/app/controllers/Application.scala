package controllers

import play.api._
import play.api.mvc._

import java.io.File

class Application extends Controller {
  def home = Action {
    Ok(views.html.home("WebCage"))
  }

  def download(id: String, name: String) = Action {
    val fileWarehouse = "upfile"
    val fpath = s"$fileWarehouse/$id.zip"
    Ok.sendFile(
      content = new File(fpath),
      fileName = _ => s"$name.zip"
    )
  }

  def about = Action {
    Ok(views.html.about())
  }
}
