import grails.util.Environment

class BootStrap {

	def fakerService
	
     def init = { servletContext ->
     	
     	switch(Environment.current){
     		case Environment.DEVELOPMENT:
		     	println "seeding database..."
				5000.times{
					new Person(firstName:fakerService.firstName(), lastName:fakerService.lastName(), 
								ssn:fakerService.numerify('###-##-####'), email:fakerService.email()).save()
					print "."
				}
				println "done seeding"
			break
		}
     }
     def destroy = {
     }
} 