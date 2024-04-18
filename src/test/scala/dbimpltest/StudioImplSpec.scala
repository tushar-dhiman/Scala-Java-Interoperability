package dbimpltest

import com.knoldus.dbimpl.StudioImpl
import com.knoldus.models.StudioDetails
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

class StudioImplSpec extends AnyFlatSpec with Matchers {

  "StudioImpl" should "add an Studio" in {

    val studioImpl = new StudioImpl
    val studioDetails: StudioDetails = StudioDetails("Scala", 101, "Level1", "Tushar Dhiman")

    val studio = studioImpl.addStudio(studioDetails)

    val result = Await.result(studio, 20.seconds)

    assert(result == List("Scala", "Level1", "Tushar Dhiman"))
  }

  it should "return true if an studio is removed by Id" in {

    val studioImpl = new StudioImpl

    val studioDetails: StudioDetails = StudioDetails("Scala", 101, "Level1", "Tushar Dhiman")
    val studioDetails1: StudioDetails = StudioDetails("Java", 102, "Level2", "Sant Singh")

    studioImpl.addStudio(studioDetails)
    studioImpl.addStudio(studioDetails1)

    val result: Future[Boolean] = studioImpl.removeById(102)

    val finalResult = Await.result(result, 20.seconds)
    assert(finalResult)
  }

  it should "return a list of studio details by Id" in {

    val studioImpl = new StudioImpl

    val studioDetails: StudioDetails = StudioDetails("Scala", 101, "Level1", "Tushar Dhiman")
    val studioDetails1: StudioDetails = StudioDetails("Java", 102, "Level2", "Sant Singh")

    studioImpl.addStudio(studioDetails)
    studioImpl.addStudio(studioDetails1)

    val manager: Future[List[String]] = studioImpl.searchById(102)

    val result = Await.result(manager, 20.seconds)
    assert(result == List("Java", "Level2", "Sant Singh"))
  }

  it should "return a list of all studios" in {

    val studioImpl = new StudioImpl

    val studioDetails: StudioDetails = StudioDetails("Scala", 101, "Level1", "Tushar Dhiman")
    val studioDetails1: StudioDetails = StudioDetails("Java", 102, "Level2", "Sant Singh")

    studioImpl.addStudio(studioDetails)
    studioImpl.addStudio(studioDetails1)

    val detailsOfAllStudios: Future[List[List[String]]] = studioImpl.listAll()

    val result = Await.result(detailsOfAllStudios, 30.seconds)

    assert(result == List(List("Scala", "Level1", "Tushar Dhiman"), List("Java", "Level2", "Sant Singh")))
  }

  it should "return true if all studios are removed" in {

    val studioImpl = new StudioImpl

    val studioDetails: StudioDetails = StudioDetails("Scala", 101, "Level1", "Tushar Dhiman")
    val studioDetails1: StudioDetails = StudioDetails("Java", 102, "Level2", "Sant Singh")

    studioImpl.addStudio(studioDetails)
    studioImpl.addStudio(studioDetails1)

    val result: Future[Boolean] = studioImpl.removeAll()

    val finalResult = Await.result(result, 20.seconds)

    assert(finalResult)
  }
}
