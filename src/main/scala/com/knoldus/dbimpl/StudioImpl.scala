package com.knoldus.dbimpl

import com.knoldus.StudioInfo.StudioInfoImpl
import com.knoldus.db.Studio
import com.knoldus.models.StudioDetails
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.jdk.CollectionConverters._

class StudioImpl extends Studio {

  private val studioInfoImpl = new StudioInfoImpl
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  override def addStudio(studioDetails: StudioDetails): Future[List[String]] = Future {
    // converting java collection to scala collections
    val info = studioInfoImpl.addStudio(studioDetails).asScala.toList
    logger.info(s"$info")
    info
  }

  override def removeById(studioId: Int): Future[Boolean] = Future {
    studioInfoImpl.removeById(studioId)
  }

  override def searchById(studioId: Int): Future[List[String]] = Future {
    studioInfoImpl.searchById(studioId).asScala.toList
  }

  override def listAll(): Future[List[List[String]]] = Future {
    // converting java collection to scala collections
    studioInfoImpl.listAll().asScala.toList.map(_.asScala.toList)
  }

  override def removeAll(): Future[Boolean] = Future {
    studioInfoImpl.removeAll()
  }
}
