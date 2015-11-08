package scheduler

import org.quartz.{JobExecutionContext, Job}

class PrintMessage extends Job {
  def execute(context: JobExecutionContext) {
    val data = context.getJobDetail().getJobDataMap();
    val message = data.getString("message");
    println(message)
  }
}