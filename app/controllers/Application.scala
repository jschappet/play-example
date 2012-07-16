package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models.Task
import models.{AppDB, Bar}


import com.codahale.jerkson.Json
import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}

import org.squeryl.PrimitiveTypeMode._

object Application extends Controller {
    
  
  val barForm = Form(
    mapping(
      "name" -> optional(text)
    )(Bar.apply)(Bar.unapply)
  )
  
  
  def index = Action {
    Ok(views.html.index(barForm))
  }

  def addBar = Action { implicit request =>
    barForm.bindFromRequest.value map { bar =>
      inTransaction(AppDB.barTable insert bar)
      Redirect(routes.Application.index())
    } getOrElse BadRequest
  }
  
  
  def getBars = Action {
    val json = inTransaction {
      val bars = from(AppDB.barTable)(barTable =>
        select(barTable)
      )
      Json.generate(bars)
    }
    Ok(json).as(JSON)
  }
  
  
  
  
  
  
}
