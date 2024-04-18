package com.knoldus.db

import com.knoldus.models.StudioDetails
import scala.concurrent.Future

trait Studio {

  def addStudio(studioDetails: StudioDetails): Future[List[String]]

  def removeById(studioId: Int): Future[Boolean]

  def searchById(studioId: Int): Future[List[String]]

  def listAll(): Future[List[List[String]]]

  def removeAll(): Future[Boolean]

}