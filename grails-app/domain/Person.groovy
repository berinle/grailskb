class Person {

	String firstName
	String lastName
	String ssn
	String email
	
    static constraints = {
    }

	static mapping = {
		table 'contact'
		columns{
			firstName column:'first_name'
			lastName column:'last_name'
			ssn column:'ssn'
			email column:'email'
		}
	}
}
