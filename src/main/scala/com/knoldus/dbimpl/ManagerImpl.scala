package com.knoldus.dbimpl

import com.knoldus.ManagersInfo.ManagersInfoImpl
import com.knoldus.db.Managers
import com.knoldus.models.ManagersDetails
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.jdk.CollectionConverters._

class ManagerImpl extends Managers {

  private val managersInfoImpl = new ManagersInfoImpl
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  override def addManagers(managersDetails: ManagersDetails): Future[List[String]] = Future {
    // converting java collection to scala collections
    val info = managersInfoImpl.addManager(managersDetails).asScala.toList
    logger.info(s"$info")
    info
  }

  override def removeById(managerId: Int): Future[Boolean] = Future {
    managersInfoImpl.removeById(managerId)
  }

  override def searchById(managerId: Int): Future[List[String]] = Future {
    managersInfoImpl.searchById(managerId).asScala.toList
  }

  override def listAll(): Future[List[List[String]]] = Future {

    // converting java collection to scala collections
    managersInfoImpl.listAll().asScala.toList.map(_.asScala.toList)
  }

  override def removeAll(): Future[Boolean] = Future {
    managersInfoImpl.removeAll()
  }
}
