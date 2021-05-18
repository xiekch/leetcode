import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Solution {
    fun findLadders(
        beginWord: String,
        endWord: String,
        wordList: List<String>
    ): List<List<String>> {
        val res = ArrayList<List<String>>()
        val levelMap = HashMap<String, Int>()
        val allComboDict = HashMap<String, MutableList<String>>()
        val parents = HashMap<String, MutableList<String>>()
        val wordLen = beginWord.length

        if (!wordList.contains(endWord)) return res
        for (word in wordList) {
            levelMap[word] = 0
            parents[word] = mutableListOf()
            for (i in 0 until wordLen) {
                val newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLen)
                val transformations = allComboDict.getOrDefault(newWord, ArrayList())
                transformations.add(word)
                allComboDict[newWord] = transformations
            }
        }
        parents[beginWord] = mutableListOf()
        levelMap[beginWord] = 1

        val qu = LinkedList<String>()
        qu.add(beginWord)
        while (!qu.isEmpty()) {
            val word = qu.remove()
            for (i in 0 until wordLen) {
                val newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLen)
                for (adjacentWord in allComboDict.getOrDefault(newWord, ArrayList())) {
                    if (levelMap[adjacentWord] == 0 || (levelMap[word]?.plus(1) ?: 0 <= levelMap[adjacentWord]!!
                            && !parents[adjacentWord]!!.contains(word))
                    ) {
                        levelMap[adjacentWord] = (levelMap[word] ?: 0) + 1
//                        println("$word - $newWord - $adjacentWord")
                        parents[adjacentWord]?.add(word)
                        if (adjacentWord == endWord) {
                            continue
                        }
                        qu.add(adjacentWord)
                    }
                }
            }
        }
        if (parents[endWord].isNullOrEmpty())
            return res
//        println(parents)
        backtrack(endWord, parents, mutableListOf(endWord), res)
        return res
    }

    private fun backtrack(
        word: String,
        parents: HashMap<String, MutableList<String>>,
        path: MutableList<String>,
        res: ArrayList<List<String>>
    ) {
        if (parents[word]!!.isEmpty()) {
            res.add(path.toList())
            return
        }
        for (i in parents[word] ?: mutableListOf()) {
            path.add(0, i)
            backtrack(i, parents, path, res)
            path.removeAt(0)
        }
    }
}

fun main() {
    class TestCase(val beginWord: String, val endWord: String, val wordList: List<String>)

    val solution = Solution()
    val testCases = arrayOf(
        TestCase("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")),
        TestCase("hit", "log", listOf("hot", "dot", "dog", "lot", "log", "cog")),
        TestCase("hot", "dog", listOf("hot", "dog")),
        TestCase("hit", "cog", listOf("hot", "dot", "dog", "lot", "log")),
        TestCase("red", "tax", listOf("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"))
    )
    for (testCase in testCases) {
        println(
            solution.findLadders(testCase.beginWord, testCase.endWord, testCase.wordList)
                .joinToString("\n")
        )
        println()
    }
}