import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Test
import java.lang.IndexOutOfBoundsException

internal class LinkedListTest {
    lateinit var list:LinkedList<Int>

    @BeforeEach
    fun init(){
        list = LinkedList()
    }

    @Test
    fun `add() should increase size`(){
        list.add(0)
        assertEquals(1,list.size)

        list.add(1)
        assertEquals(2,list.size)
    }

    @Test
    fun `add(index) should increase size`(){
        list.add(0,0)
        assertEquals(1,list.size)

        list.add(1,1)
        assertEquals(2,list.size)
    }

    @Test
    fun `add(index) should throw exception when index is out of bound`(){
        assertFalse( list.add(-1,0) )
        assertFalse( list.add(1,1) )
        list.add(0,1)
        assertFalse( list.add(2,1) )
    }

    @Test
    fun `add(index) should add item at expected index`(){
        repeat(5){
            list.add(it)
        }

        assertTrue(list.add(0,-1000))
        assertEquals(-1000,list.get(0))

        assertTrue(list.add(3,1000))
        assertEquals(1000, list.get(3))

        assertTrue(list.add(list.size, 0))
        assertEquals(list.getLast(), 0)
    }

    @Test
    fun `addFirst() should add item at begin of list`(){
        repeat(5){
            list.add(it)
        }

        assertTrue(list.addFirst(1000))
        assertEquals(1000,list.getFirst())
    }

    @Test
    fun `addFirst() should increase size`(){
        repeat(5){
            list.add(it)
        }

        assertTrue(list.addFirst(1000))
        assertEquals(6,list.size)
    }

    @Test
    fun `addLast() should add item at end of list`(){
        repeat(5){
            list.add(it)
        }

        assertTrue(list.addLast(1000))
        assertEquals(1000,list.getLast())
    }

    @Test
    fun `addLast() should increase size`(){
        repeat(5){
            list.add(it)
        }

        assertTrue(list.addLast(1000))
        assertEquals(6,list.size)
    }



    @RepeatedTest(5)
    fun `getFirst() should return First Item`(info:RepetitionInfo){
        list.add(info.currentRepetition)
        list.add(1)

        assertEquals(info.currentRepetition,list.getFirst())
    }

    @RepeatedTest(5)
    fun `getLast() should return Last Item`(info:RepetitionInfo){
        list.add(0)
        list.add(1)
        list.add(info.currentRepetition)

        assertEquals(info.currentRepetition,list.getLast())
    }

    @Test
    fun `get() should return item at index`() {
        repeat(5){
            list.add(it+1)
        }

        repeat(5){
            assertEquals(it+1,list.get(it))
        }
    }

    @Test
    fun `get() should throw exception when index is out of bound`(){
        assertThrows(IndexOutOfBoundsException::class.java) { list.get(0) }

        repeat(5){
            list.add(it+1)
        }

        assertThrows(IndexOutOfBoundsException::class.java) { list.get(-1) }
        assertThrows(IndexOutOfBoundsException::class.java) { list.get(5) }
    }
}