package com.knoldus.dbimpl

import com.knoldus.EmployeeInfo.EmployeeInfoImpl
import com.knoldus.db.Employee
import com.knoldus.models.EmployeeDetails
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.jdk.CollectionConverters._


class EmployeeImpl extends Employee {

  private val employeeInfoImpl = new EmployeeInfoImpl
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  override def addEmployee(employeeDetails: EmployeeDetails): Future[List[String]] = Future {

    // converting java collection to scala collections
    val info = employeeInfoImpl.addEmployee(employeeDetails).asScala.toList
    logger.info(s"$info")
    info

  }

  override def removeById(employeeId: Int): Future[Boolean] = Future {
    employeeInfoImpl.removeById(employeeId)
  }

  override def searchById(employeeId: Int): Future[List[String]] = Future {
    employeeInfoImpl.searchById(employeeId).asScala.toList
  }

  override def listAll(): Future[List[List[String]]] = Future {

    // converting java collection to scala collections
    employeeInfoImpl.listAll().asScala.toList.map(_.asScala.toList)
  }

  override def removeAll(): Future[Boolean] = Future {
    employeeInfoImpl.removeAll()
  }
}
