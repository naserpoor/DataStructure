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

    fun getFirst():T? = getFirstNode()?.data
    fun getLast():T? {
        return getLastNode()?.data
    }
}