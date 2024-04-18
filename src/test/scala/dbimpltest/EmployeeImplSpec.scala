package dbimpltest

import com.knoldus.dbimpl.EmployeeImpl
import com.knoldus.models.EmployeeDetails
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

class EmployeeImplSpec extends AnyFlatSpec with Matchers {

  "EmployeeImpl" should "add an employee" in {

    val employeeImpl = new EmployeeImpl
    val employeeDetails: EmployeeDetails = EmployeeDetails("Tushar Dhiman", 102, "Tushardhiman@example.com", "scala", "Noida")

    val employee = employeeImpl.addEmployee(employeeDetails)

    val result = Await.result(employee, 20.seconds)

    assert(result == List("Tushar Dhiman", "Tushardhiman@example.com", "scala", "Noida"))
  }

  it should "return true if an employee is removed by Id" in {

    val employeeImpl = new EmployeeImpl
    val employeeDetails: EmployeeDetails = EmployeeDetails("John Doe", 101, "john.doe@example.com", "Sales", "New York")
    val employeeDetails1: EmployeeDetails = EmployeeDetails("Tushar Dhiman", 102, "Tushardhiman@example.com", "scala", "Noida")

    employeeImpl.addEmployee(employeeDetails)
    employeeImpl.addEmployee(employeeDetails1)

    val result: Future[Boolean] = employeeImpl.removeById(102)

    val finalResult = Await.result(result, 20.seconds)
    assert(finalResult)
  }

  it should "return a list of employee details by Id" in {

    val employeeImpl = new EmployeeImpl
    val employeeDetails: EmployeeDetails = EmployeeDetails("John Doe", 101, "john.doe@example.com", "Sales", "New York")
    val employeeDetails1: EmployeeDetails = EmployeeDetails("Tushar Dhiman", 102, "Tushardhiman@example.com", "scala", "Noida")

    employeeImpl.addEmployee(employeeDetails)
    employeeImpl.addEmployee(employeeDetails1)

    val employee: Future[List[String]] = employeeImpl.searchById(102)

    val result = Await.result(employee, 20.seconds)
    assert(result == List("Tushar Dhiman", "Tushardhiman@example.com", "scala", "Noida"))
  }

  it should "return a list of all employees" in {

    val employeeImpl = new EmployeeImpl
    val employeeDetails: EmployeeDetails = EmployeeDetails("John Doe", 101, "john.doe@example.com", "Sales", "New York")
    val employeeDetails1: EmployeeDetails = EmployeeDetails("Tushar Dhiman", 102, "Tushardhiman@example.com", "scala", "Noida")

    employeeImpl.addEmployee(employeeDetails)
    employeeImpl.addEmployee(employeeDetails1)

    val detailsOfAllEmployees: Future[List[List[String]]] = employeeImpl.listAll()

    val result = Await.result(detailsOfAllEmployees, 30.seconds)

    assert(result == List(List("John Doe", "john.doe@example.com", "Sales", "New York"), List("Tushar Dhiman", "Tushardhiman@example.com", "scala", "Noida")))
  }

    it should "return true if all employees are removed" in {

      val employeeImpl = new EmployeeImpl
      val employeeDetails: EmployeeDetails = EmployeeDetails("John Doe", 101, "john.doe@example.com", "Sales", "New York")
      val employeeDetails1: EmployeeDetails = EmployeeDetails("Tushar Dhiman", 102, "Tushardhiman@example.com", "scala", "Noida")

      employeeImpl.addEmployee(employeeDetails)
      employeeImpl.addEmployee(employeeDetails1)

      val result: Future[Boolean] = employeeImpl.removeAll()

      val finalResult = Await.result(result, 20.seconds)

      assert(finalResult)
    }
}
