package scheduler

import org.quartz.CronScheduleBuilder._
import org.quartz.JobBuilder.newJob
import org.quartz.TriggerBuilder._
import org.quartz.impl.StdSchedulerFactory

object Scheduler {
  val scheduler = StdSchedulerFactory.getDefaultScheduler()

  def printMessageDaily(hour: Int, minute: Int, message: String) {
    val job = newJob(classOf[PrintMessage]).build()
    job.getJobDataMap().put("message", message)
    val trigger = newTrigger().withSchedule(dailyAtHourAndMinute(hour, minute)).build()
    scheduler.scheduleJob(job, trigger)
  }
}
