import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LinkedListTest {

    @Test
    fun `should increase size when one item added`(){
        val list = LinkedList<Int>()
        list.add(0)

        assertEquals(1,list.size)
    }

}