package com.knoldus.models

final case class EmployeeDetails(employeeName: String,
                           employeeId: Int,
                           employeeEmail: String,
                           employeeDepartment: String,
                           employeeCity: String){
  assert(employeeName.nonEmpty && employeeName.length < 20)
  assert(employeeId > 0)
  assert{
    if("""(?=[^\s]+)(?=(\w+)@([\w\.]+))""".r.findFirstIn(employeeEmail) == None)false else true
  }
  assert(employeeCity.nonEmpty && employeeCity.length < 20)
  assert(employeeDepartment.nonEmpty && employeeDepartment.length < 20)
}
