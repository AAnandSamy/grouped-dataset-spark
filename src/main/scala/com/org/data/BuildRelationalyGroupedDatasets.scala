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
import org.apache.spark.sql._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

case class Country(country: String, states: String, city: String)

object BuildRelationalyGroupedDatasets {


  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("RelationalyGroupedDatasets")
      .master("local[*]")
      .getOrCreate();

    import spark.implicits._

  /*Read the source data*/
    val df=spark
      .read
      .option("header",true)
      .csv("groupedDataset.csv").as[Country]

    df.show()

  /*Collect each row data and form as Tuples2*/

    val dfTuple = df.withColumn("JsonTuple", to_json(struct("*")) )

    /*Group the the datasets by column name and collect the grouped set as a List*/

    val gropedDS = dfTuple.groupBy("country")
      .agg(collect_list("JsonTuple").cast("String") as "json_data")
      .withColumn("country",struct("country").cast("String"))





  }

}
















