package com.knoldus.models

final case class StudioDetails(studioName: String,
                               studioId: Int,
                               studioLevel: String,
                               studioManager: String) {
  assert(studioName.nonEmpty && studioName.length < 10)
  assert(studioId > 0)
  assert(studioLevel.length >= 6)
  assert(studioManager.nonEmpty && studioManager.length < 20)
}
