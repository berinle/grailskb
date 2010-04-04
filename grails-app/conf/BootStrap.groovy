import grails.util.Environment
import grailskb.Employee

class BootStrap {

	def fakerService
	def sessionFactory
	
     def init = { servletContext ->
     	
     	switch(Environment.current){
     		case Environment.DEVELOPMENT:
		     	println "seeding database..."
				/*5000.times{
					new Person(firstName:fakerService.firstName(), lastName:fakerService.lastName(), 
								ssn:fakerService.numerify('###-##-####'), email:fakerService.email()).save()
					print "."
				}*/
				
				List<Employee> batch = []
				def startTime = System.nanoTime()
				10000.times{					
					Employee e = new Employee(firstName:fakerService.firstName(), lastName:fakerService.lastName(),
						hireDate: new Date(), employeeNo: fakerService.numerify('###-##-###'))
					
					batch.add(e)
					if(batch.size() % 100 == 0){
						Employee.withTransaction{
							for(Employee emp in batch){
								emp.save()
							}
						}
						
						batch.clear()
						print "."												
					}
					
					//batch.clear()
					def session = sessionFactory.getCurrentSession()	
					session.clear()

				}
				
				def endTime =  System.nanoTime()
				def diff = (startTime-endTime)/1000000000
				println "TIME TAKEN IS :::"+diff
				
				/*5000.times{
					Employee e = new Employee(firstName:fakerService.firstName(), lastName:fakerService.lastName(),
						hireDate: new Date(), employeeNo: fakerService.numerify('###-##-###')).save()
					print "."
				}*/
				
				println "done seeding"
			break
		}
     }
     def destroy = {
     }
} 