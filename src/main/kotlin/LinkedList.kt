class LinkedList<T> {
    private var top:Node<T>? = null
    private class Node<T>(var data:T,var next:Node<T>? = null)
    var size = 0
        get
        private set

    fun add(data:T):Boolean{
        top = Node(data,top)
        size++
        return true
    }
}