/*
# Program      : LDAP_UID_Streaming_Logs.scala
# Date Created : 07/03/2018
# Description  : This is a Main class for Streaming Job for Unify Identity
# Parameters   :
#
# Modification history:
#
# Date         Author               Description
# ===========  ===================  ============================================
# 09/03/2018   Anand Ayyasamy        Creation
# ===========  ===================  ============================================
*/
package com.org.data

import org.apache.log4j.Logger
import org.apache.spark.sql._
import scala.collection.JavaConverters._

case class Country(country: String, states: String, city: String)

object BuildRelationalyGroupedDatasets {

   System.setProperty("hadoop.home.dir", "C:\\software\\hadoop");

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("RelationalyGroupedDatasets")
      .master("local[*]")
      .getOrCreate();

    import spark.implicits._





  }

}
















