class BootStrap {

	def fakerService
	
     def init = { servletContext ->
		20.times{
			new Person(firstName:fakerService.firstName(), lastName:fakerService.lastName(), ssn:fakerService.numerify('#########')).save()
		}
		println "done seeding"
     }
     def destroy = {
     }
} 