package io.sudoku.sudoku.sudoku.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import io.sudoku.sudoku.sudoku.service.SudokuService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

// spring test
// - jUnit 5
// - asdfasdf

// test -> spring RESTDOCS
//      -> kotiln test DSL

// spring test

// web layer test

// junit ?? service layer, repistory test??

// tc -> 로직  -----> 반영 ----> tc -> 로직
// unit test
// -> spec 대상인가
// -> happy path (가장 일반적인 값), 예외사항 (spec에 포함 된 경우)
@WebMvcTest(SudokuController::class)
@ActiveProfiles("local")
internal class SudokuControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    // mockBean을 커스텀하게 생성하는 방법
    @MockBean
    private lateinit var sudokuService: SudokuService

    @Test
    fun `렌덤 게임 생성 요청 파라메터 테스트`() {
        val request = SudokuRequest(18,null)

        mockMvc.perform {
            MockMvcRequestBuilders.post("/api/v1/games/random")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jacksonObjectMapper().writeValueAsBytes(request))
                    .buildRequest(it)
        }.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk)
    }
}