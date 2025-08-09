package com.dhakar.piyush.newsapp.data.model

import com.google.gson.annotations.SerializedName
data class NewsSearchRsp(
    @SerializedName("status"       ) var status       : String?             = null,
    @SerializedName("totalResults" ) var totalResults : Int?                = null,
    @SerializedName("articles"     ) var articles     : ArrayList<Article> = arrayListOf()
)
