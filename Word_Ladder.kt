// https://leetcode.com/problems/word-ladder/solution/
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.set

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val levelMap = HashMap<String, Int>()
        val allComboDict = HashMap<String, MutableList<String>>()
        val wordLen = beginWord.length

        for (word in wordList) {
            levelMap[word] = 0
            for (i in 0 until wordLen) {
                val newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLen)
                val transformations = allComboDict.getOrDefault(newWord, ArrayList())
                transformations.add(word)
                allComboDict[newWord] = transformations
            }
        }
        levelMap[beginWord] = 1

        val qu = LinkedList<String>()
        qu.add(beginWord)
        while (!qu.isEmpty()) {
            val word = qu.remove()
            for (i in 0 until wordLen) {
                val newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLen)
                for (adjacentWord in allComboDict.getOrDefault(newWord, ArrayList())) {
                    if (levelMap[adjacentWord] == 0) {
                        levelMap[adjacentWord] = (levelMap[word] ?: 0) + 1
                        if (adjacentWord == endWord) return levelMap[adjacentWord]!!
                        qu.add(adjacentWord)
                    }
                }
            }
        }
        return 0
    }
}

fun main() {
    val solution = Solution()
    println(solution.ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
}