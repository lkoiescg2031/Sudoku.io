package io.sudoku.sudoku

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

// test 환경
// web server, application server, db,

//
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("local")
@AutoConfigureMockMvc
class SudokuApplicationTests {
//
//    // lateinite 원시 타입 에러
//    @LocalServerPort
//    private var serverPort: Int = 0
//
//    @Autowired
//    private lateinit var testRestTemplate: TestRestTemplate
//
//
//    @Test
//    fun `기본 생성 태스트`() {
//        testRestTemplate.getForObject("http://localhost:${serverPort}/",Unit)
//    }
}
