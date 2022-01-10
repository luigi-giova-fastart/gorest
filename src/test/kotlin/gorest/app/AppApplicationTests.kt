package gorest.app

import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest
import gorest.app.repo.UserRepo
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.http.HttpStatus
import org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class AppApplicationTests {
	
	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
    fun testPosts() {
        val result = testRestTemplate.getForEntity("/my-api/posts", String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
    }
	
	@Test
    fun testPostsWithUserId() {
        val result = testRestTemplate.getForEntity("/my-api/posts?user_id=2", String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
    }
}
