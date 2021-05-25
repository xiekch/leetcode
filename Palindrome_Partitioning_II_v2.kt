// https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42213/Easiest-Java-DP-Solution-(97.36)
class Solution {
    fun minCut(s: String): Int {
        val n = s.length
        if (n <= 1) return 0
        val isPalindrome = Array(n) { BooleanArray(n) { false } }
        val minCuts = IntArray(n)
        for (i in 0 until n) {
            var min = i
            for (j in 0..i) {
                if (s[i] == s[j] && (j + 1 >= i - 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true
                    min = minOf(min, if (j == 0) 0 else minCuts[j - 1] + 1)
                }
            }
            minCuts[i] = min
        }
//        println(isPalindrome.joinToString(separator = "\n") { it.joinToString() })
        return minCuts[n - 1]
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        "abbc",
        "a",
        "aaa",
        "aabba",
        "aabbb",
        "fiefhgdcdcgfeibggchibffahiededbbegegdfibdbfdadfbdbceaadeceeefiheibahgece" +
            "cggaehbdcgebaigfacifhdbecbebfhiefchaaheiichgdbheacfbhfiaffaecicbegdgeiaiccgh" +
            "ggdfggbebdaefcagihbdhhigdgbghbahhhdagbdaefeccfiaifffcfehfcdiiieibadcedibbedgfegibefag" +
            "fccahfcbegdfdhhdgfhgbchiaieehdgdabhidhfeecgfiibediiafacagigbhchcdhbaigdcedggehhgdhedaebchcafcdehc" +
            "ffdiagcafcgiidhdhedgaaegdchibhdaegdfdaiiidcihifbfidechicighbcbgibadbabieaafgeagfhebfaheaeeibagdfha" +
            "difafghbfihehgcgggffgbfccgafigieadfehieafaehaggeeaaaehggffccddchibegfhdfafhadgeieggiigacbfgcagigbhb" +
            "hefcadafhafdiegahbhccidbeeagcgebehheebfaechceefdiafgeddhdfcadfdafbhiifigcbddahbabbeedidhaieagheihhgf" +
            "fbfbiacgdaifbedaegbhigghfeiahcdieghhdabdggfcgbafgibiifdeefcbegcfcdihaeacihgdchihdadifeifdgecbchgdgdcif" +
            "edacfddhhbcagaicbebbiadgbddcbagbafeadhddaeebdgdebafabghcabdhdgieiahggddigefddccfccibifgbfcdccghgceigdfd" +
            "bghdihechfabhbacifgbiiiihcgifhdbhfcaiefhccibebcahidachfabicbdabibiachahggffiibbgchbidfbbhfcicfafgcagaaadb" +
            "acddfiigdiiffhbbehaaacidggfbhgeaghigihggfcdcidbfccahhgaffiibbhidhdacacdfebedbiacaidaachegffaiiegeabfdgdcgdacfcf" +
            "hdcbfiaaifgfaciacfghagceaaebhhibbieehhcbiggabefbeigcbhbcidbfhfcgdddgdffghidbbbfbdhcgabaagddcebaechbbiegeiggbabdhgg" +
            "hciheabdibefdfghbfbfebidhicdhbeghebeddgfdfhefebiiebdchifbcbahaddhbfafbbcebiigadhgcfbebgbebhfddgdeehhgdegaeedfadegfeihc" +
            "geefbbagbbacbgggciehdhiggcgaaicceeaefgcehfhfdciaghcbbgdihbhecfbgffefhgiefgeiggcebgaacefidghdfdhiabgibchdicdehahbibeddeg" +
            "fciaeaffgbefbbeihbafbagagedgbdadfdggfeaebaidchgdbcifhahgfdcehbahhdggcdggceiabhhafghegfdiegbcadgaecdcdddfhicabdfhbdiiceie" +
            "giedecdifhbhhfhgdbhibbdgafhgdcheefdhifgddchadbdggiidhbhegbdfdidhhfbehibiaacdfbiagcbheabaaebfeaeafbgigiefeaeheabifgcfibid" +
            "dadicheahgbfhbhddaheghddceedigddhchecaghdegigbegcbfgbggdgbbigegffhcfcbbebdchffhddbfhhfgegggibhafiebcfgeaeehgdgbccbfghagfdb" +
            "dfcbcigbigaccecfehcffahiafgabfcaefbghccieehhhiighcfeabffggfchfdgcfhadgidabdceediefdccceidcfbfiiaidechhbhdccccaigeegcaicabbifigcghcefaafaefd"
    )

    for (testCase in testCases) {
        println(solution.minCut(testCase))
    }
}