package gorest.app.repo

import gorest.app.pojo.User
import org.springframework.stereotype.Repository

@Repository
public class UserRepo {
   
   var mAllUsers = mutableListOf<User>()

    init {
          val u1 = User(1, "Mario",24,"Via Roma 1")
          val u2 = User(2, "Luigi",33,"Via Dante 12")
          val u3 = User(3, "Giovanni",23,"Via Milano 5")

          mAllUsers.add(u1)
          mAllUsers.add(u2)
          mAllUsers.add(u3)
    }
	
	fun retrieveAllStudents(): List<User>{
        return mAllUsers
    }

	/**
     * Find student by name.
     */
    fun findUserById(id:Int): User?{
        return mAllUsers.find{it.id == id}
    }
}