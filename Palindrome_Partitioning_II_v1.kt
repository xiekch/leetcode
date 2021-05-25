// TLE
class Solution {
    fun minCut(s: String): Int {
        val n = s.length
        if (n <= 1) return 0
        val dp = Array(n) { IntArray(n) { 0 } }
        for (i in n - 1 downTo 0) {
            dp[i][i] = 0
            if (i < n - 1)
                dp[i][i + 1] = if (s[i] == s[i + 1]) 0 else 1
            for (j in i + 2 until n) {
                if (s[i] == s[j] && dp[i + 1][j - 1] == 0) {
                    dp[i][j] = 0
                    continue
                }
                dp[i][j] = dp[i + 1][j] + 1
                for (k in i + 1 until j) {
                    dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k + 1][j] + 1)
                }
            }
        }
        println(dp.joinToString(separator = "\n") { it.joinToString() })
        return dp[0][n - 1]
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