package dbimpltest

import com.knoldus.dbimpl.ManagerImpl
import com.knoldus.models.ManagersDetails
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

class ManagerImplSpec extends AnyFlatSpec with Matchers {

  "ManagerImpl" should "add an manager" in {

    val managerImpl = new ManagerImpl
    val managersDetails: ManagersDetails = ManagersDetails("Tushar Dhiman", 101, "Level1", "Scala")

    val employee = managerImpl.addManagers(managersDetails)

    val result = Await.result(employee, 20.seconds)

    assert(result == List("Tushar Dhiman", "Level1", "Scala"))
  }

  it should "return true if an manager is removed by Id" in {

    val managerImpl = new ManagerImpl
    val managersDetails: ManagersDetails = ManagersDetails("John Doe", 101, "Level2", "Java")
    val managersDetails1: ManagersDetails = ManagersDetails("Tushar Dhiman", 102, "Level1", "Scala")

    managerImpl.addManagers(managersDetails)
    managerImpl.addManagers(managersDetails1)

    val result: Future[Boolean] = managerImpl.removeById(102)

    val finalResult = Await.result(result, 20.seconds)
    assert(finalResult)
  }

  it should "return a list of manager details by Id" in {

    val managerImpl = new ManagerImpl
    val managersDetails: ManagersDetails = ManagersDetails("John Doe", 101, "Level2", "Java")
    val managersDetails1: ManagersDetails = ManagersDetails("Tushar Dhiman", 102, "Level1", "Scala")

    managerImpl.addManagers(managersDetails)
    managerImpl.addManagers(managersDetails1)

    val manager: Future[List[String]] = managerImpl.searchById(102)

    val result = Await.result(manager, 20.seconds)
    assert(result == List("Tushar Dhiman", "Level1", "Scala"))
  }

  it should "return a list of all managers" in {

    val managerImpl = new ManagerImpl
    val managerDetails: ManagersDetails = ManagersDetails("John Doe", 101, "Level2", "Java")
    val managerDetails1: ManagersDetails = ManagersDetails("Tushar Dhiman", 102, "Level1", "Scala")

    managerImpl.addManagers(managerDetails)
    managerImpl.addManagers(managerDetails1)

    val detailsOfAllManagers: Future[List[List[String]]] = managerImpl.listAll()

    val result = Await.result(detailsOfAllManagers, 30.seconds)

    assert(result == List(List("John Doe", "Level2", "Java"), List("Tushar Dhiman", "Level1", "Scala")))
  }

  it should "return true if all managers are removed" in {

    val managerImpl = new ManagerImpl
    val managerDetails: ManagersDetails = ManagersDetails("John Doe", 101, "Level2", "Java")
    val managerDetails1: ManagersDetails = ManagersDetails("Tushar Dhiman", 102, "Level1", "Scala")

    managerImpl.addManagers(managerDetails)
    managerImpl.addManagers(managerDetails1)

    val result: Future[Boolean] = managerImpl.removeAll()

    val finalResult = Await.result(result, 20.seconds)

    assert(finalResult)
  }
}
