/**
  * Created by michael on 2/6/16.
  */

import java.nio.file.Paths

object MyUtil {
  def getPath(p: String): String = {
    s"hdfs://localhost:9000/${Paths.get("user/michael", p).toString}"
  }
 }
