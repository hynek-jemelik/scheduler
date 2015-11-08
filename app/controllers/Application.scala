package controllers

import play.api.mvc._
import scheduler.Scheduler

class Application extends Controller {

  def index = Action {
    Ok(views.html.index(""))
  }

  def remind(hour: Int, minute: Int, message: String) = Action {
    if(0 <= hour && hour < 24 && 0 <= minute && minute < 60) {
      Scheduler.printMessageDaily(hour, minute, message)
      Ok(views.html.index("OK"))
    }
    else {
      Ok(views.html.index("Please enter a valid time."))
    }
  }

}
