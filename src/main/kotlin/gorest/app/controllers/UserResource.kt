package gorest.app.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import gorest.app.pojo.User
import gorest.app.repo.UserRepo
import java.util.Optional

@RestController
class UserResource {
	
	@Autowired
    val usersRepo = UserRepo()
	
	@GetMapping("my-api/posts")
    fun getUser(@RequestParam   user_id:Optional<Int>): List<User>{

		if(user_id.isPresent())
		{
			return listOfNotNull( usersRepo.findUserById(user_id.get()) )
		}
		else
			return usersRepo.retrieveAllStudents()
    }
}