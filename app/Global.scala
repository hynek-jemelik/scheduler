import play.api.{Application, GlobalSettings}
import scheduler.Scheduler.scheduler

object Global extends GlobalSettings {
  override def onStart(app: Application) {
    scheduler.start()
  }

  override def onStop(app: Application) {
    scheduler.clear()
    scheduler.standby()
    scheduler.shutdown()
  }
}