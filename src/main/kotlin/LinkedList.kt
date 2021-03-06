import java.lang.IndexOutOfBoundsException

class LinkedList<T> {
    private var top:Node<T>? = null
    private class Node<T>(var data:T,var next:Node<T>? = null)
    var size = 0
        private set

    fun add(data:T):Boolean{
        val newNode = Node(data)
        val lastNode = getLastNode()
        lastNode?.next = newNode
        if (top == null) {
            top = newNode
        }
        size++
        return true
    }

    fun add(index: Int,data: T):Boolean {
        if (index < 0 || index > size) {
            return false
        }
        val newNode = Node(data)
        val cur = getNode(index)
        val prev = getNode(index - 1)
        prev?.next = newNode
        newNode.next = cur
        if(index == 0){
            top = newNode
        }
        size++
        return true
    }

    fun addFirst(data: T):Boolean{
        return add(0,data)
    }

    fun addLast(data: T):Boolean{
        return add(data)
    }

    private fun getFirstNode() = top
    private fun getLastNode():Node<T>? {
        var cur = top ?: return null
        var next = cur.next
        while (next != null) {
            cur = next
            next = cur.next
        }
        return cur
    }
    private fun getNode(index: Int):Node<T>? {
        if (index < 0 || index >= size) {
            return null
        }
        var cur = top ?: return null
        var next = cur.next
        var idx = index
        while (next != null && idx != 0) {
            cur = next
            next = cur.next
            idx--
        }
        return cur
    }

    fun getFirst():T? = getFirstNode()?.data
    fun getLast():T? {
        return getLastNode()?.data
    }
    operator fun get(index:Int) = getNode(index)?.data ?: throw IndexOutOfBoundsException()

    fun removeAt(index: Int):T {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }
        val cur = getNode(index) ?: throw IndexOutOfBoundsException()
        val prev = getNode(index - 1)
        prev?.next = cur.next
        if(index == 0){
            top = cur.next
        }
        size--
        return cur.data
    }

    fun remove(data: T):Int {
        var prev:Node<T>? = null
        var cur = top ?: return -1
        var next = cur.next
        var idx = 0
        while (next != null && cur.data != data) {
            prev = cur
            cur = next
            next = cur.next
            idx++
        }

        if (cur.data == data) {
            prev?.next = cur.next
            if (idx == 0) {
                top = cur.next
            }
            size--
            return idx
        } else {
            return -1
        }
    }

    fun removeLast():T {
        return removeAt(size - 1)
    }

    fun removeFirst():T {
        return removeAt(0)
    }

    fun remove():T {
        return removeLast()
    }
}