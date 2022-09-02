package searchVO

import java.io.Serializable

class SearchVO : Serializable {
    constructor()

    private var siteName = ""
    private var searchWord = ""
    private var resultLink = ""

    public fun getSiteName() : String {
        return this.siteName
    }

    public fun setSiteName(siteName : String) {
        this.siteName = siteName
    }

    public fun getSearchWord() : String {
        return this.searchWord
    }

    public fun setSearchWord(searchWord : String) {
        this.searchWord = searchWord
    }

    public fun getResultLink() : String {
        return this.resultLink
    }

    public fun setResultLink(resultLink : String) {
        this.resultLink = resultLink
    }
}