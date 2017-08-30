/****
 * Created by vuduclong0309 on 30/8/2017
 */
package org.apache.spark.status.api.v1

import javax.ws.rs._
import javax.ws.rs.core.MediaType
import org.apache.spark.ui.SparkUI

@Produces(Array(MediaType.APPLICATION_JSON))
private[v1] class ExecutorFullResource(ui: SparkUI) {

  @GET
  def getExecutorFullInfo(): ExecutorFullInfo = {
    val listener = ui.executorsListener
    listener.synchronized {
      val executorInfo = listener.executorIdToData.toMap
     
      new ExecutorFullInfo(executorInfo)
    }
  }

}
