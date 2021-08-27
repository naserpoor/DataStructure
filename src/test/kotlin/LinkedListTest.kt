import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Test

internal class LinkedListTest {
    lateinit var list:LinkedList<Int>

    @BeforeEach
    fun init(){
        list = LinkedList()
    }

    @Test
    fun `should increase size when one item added`(){
        list.add(0)
        assertEquals(1,list.size)

        list.add(1)
        assertEquals(2,list.size)
    }

    @RepeatedTest(5)
    fun `getFirst should return First Item`(info:RepetitionInfo){
        list.add(info.currentRepetition)
        list.add(1)

        assertEquals(info.currentRepetition,list.getFirst())
    }

    @RepeatedTest(5)
    fun `getLast should return Last Item`(info:RepetitionInfo){
        list.add(0)
        list.add(1)
        list.add(info.currentRepetition)

        assertEquals(info.currentRepetition,list.getLast())
    }

}