package grailskb

class Employee {

	String firstName
	String lastName
	String employeeNo
	Date hireDate
	
	static mapping = {
		table 'employee'
		columns{
			firstName column:'fname'
			lastName column:'lname'
			employeeNo column:'emp_no'
			hireDate column:'hire_date'
		}
	}
    static constraints = {
    }
}
