package com.knoldus.models

final case class ManagersDetails(managerName: String,
                           managerId: Int,
                           managerLevel: String,
                           managerDepartment: String){
  assert(managerName.nonEmpty && managerName.length < 20)
  assert(managerId > 0)
  assert(managerLevel.length >= 6)
  assert(managerDepartment.nonEmpty && managerDepartment.length < 20)
}
