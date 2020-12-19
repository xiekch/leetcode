import java.util.AbstractQueue

/**
 * @brief max heap
 */
class Heap<T : Comparable<T>> {
    private val data: ArrayList<T> by lazy { ArrayList<T>() }
    private var count = 0
    fun pool(): T? {
        if (isEmpty()) return null
        count--
        val res = data[0]
        if (!isEmpty()) {
            data[0] = data[count - 1]
            data.removeAt(count - 1)
            adjustHeap(0)
        }
        return res
    }

    fun add(ele: T) {
        data.add(ele)
        var i = count
        count++
        while (i >= 0) {
            adjustHeap(i)
            if (i == 0) break
            i /= 2
        }
    }

    fun isEmpty(): Boolean {
        return this.count == 0
    }

    private fun adjustHeap(start: Int) {
        val copy = data[start]
        var i = start
        var j = i * 2
        while (j < count) {
            if (j + 1 < count && data[j] < data[j + 1]) j++
            if (copy >= data[j]) break
            data[i] = data[j]
            i = j
            j *= 2
        }
        data[i] = copy
    }
}

fun main() {
    val heap = Heap<Int>()
    for (i in 0..10) heap.add((Math.random() * 100).toInt())
    while (!heap.isEmpty()) {
        println(heap.pool())
    }
}