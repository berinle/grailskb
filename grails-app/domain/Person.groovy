class Person {

	String firstName
	String lastName
	String ssn
	
    static constraints = {
    }

	static mappings = {
		table 'contact'
		columns{
			firstName column:'first_name'
			lastName column:'last_name'
			ssn column:'ssn'
		}
	}
}
