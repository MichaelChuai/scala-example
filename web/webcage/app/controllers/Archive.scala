package controllers

/**
  * Created by michael on 1/17/16.
  */


import play.api._
import play.api.mvc._

import scala.concurrent.Await
import scala.concurrent.duration.Duration.Inf

import models.{Curated, CuratedData}
import play.api.libs.json._

class Archive extends Controller {
  def showArchive = Action {
    Ok(views.html.archive())
  }

  def getData = Action {
    val curated = Await.result(CuratedData.getAll, Inf).toList
    Ok(Json.toJson(curated)(Curated.curatedSeqWrites))
  }

}





