package com.knoldus.db

import com.knoldus.models.ManagersDetails
import scala.concurrent.Future

trait Managers {

  def addManagers(ManagersDetails: ManagersDetails): Future[List[String]]

  def removeById(managerId: Int): Future[Boolean]

  def searchById(managerId: Int): Future[List[String]]

  def listAll(): Future[List[List[String]]]

  def removeAll(): Future[Boolean]

}
