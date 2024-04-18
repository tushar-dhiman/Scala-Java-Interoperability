package com.knoldus.db

import com.knoldus.models.EmployeeDetails

import scala.concurrent.Future

trait Employee {

  def addEmployee(employeeDetails: EmployeeDetails): Future[List[String]]

  def removeById(employeeId: Int): Future[Boolean]

  def searchById(employeeId: Int): Future[List[String]]

  def listAll(): Future[List[List[String]]]

  def removeAll(): Future[Boolean]

}
