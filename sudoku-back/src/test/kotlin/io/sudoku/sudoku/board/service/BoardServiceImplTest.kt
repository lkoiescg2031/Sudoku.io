package io.sudoku.sudoku.board.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.random.Random


// F.I.R.S.T
@ExtendWith(MockitoExtension::class)
internal class BoardServiceImplTest {

    @InjectMocks
    private lateinit var boardService: BoardServiceImpl

    @Nested
    inner class `MethodCreateRandomBoardTest` {

        @RepeatedTest(10)
        fun `정상 생성 확인 테스트`() {
            // given
            var showCount = Random.nextInt(18, 81)
            var seed = Random.nextLong()

            // when
            var board = boardService.createRandomBoard(seed, showCount)

            // then
            assertEquals(board.flatten().count { it != 0 }, showCount)
        }

        @RepeatedTest(10)
        fun `렌덤 생성 테스트`() {
            // given
            var showCount = Random.nextInt(18, 81)
            var seed = Random.nextLong()

            // when
            var board1 = boardService.createRandomBoard(seed, showCount).toTypedArray()
            var board2 = boardService.createRandomBoard(seed, showCount).toTypedArray()

            // then
            assertFalse(board1 contentDeepEquals board2)
        }

        @Test
        fun `seed 파라메터 옵션 테스트`() {
            // given
            var showCount = Random.nextInt(18, 81)
            var seed: Long? = null

            // when
            var board = boardService.createRandomBoard(seed, showCount)

            // then
            assertEquals(board.flatten().count { it != 0 }, showCount)
        }


        @ParameterizedTest
        @ValueSource(ints = [ -1, 0, 17, 18, 81, 82])
        fun `showCount 경계값 학인 테스트`(showCount: Int) {
            // given
            var seed = null

            // when
            try {
                var board = boardService.createRandomBoard(seed, showCount)

                assertNotNull(board)
                assertEquals(board.flatten().count { it != 0 }, Math.min(showCount, 81))

            } catch (e: Exception) {

                assertTrue(showCount < 0)
            }

        }
    }

//    @Test
//    fun isOriginBoard() {
//    }
//
//    @Test
//    fun isCorrectBoard() {
//    }

}