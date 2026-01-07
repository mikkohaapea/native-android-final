package com.example.lopputyo.model

import com.google.gson.annotations.SerializedName

data class Success(
    val latestValues: LatestValues
)

data class LatestValues(
    var info: Info,
    var data: Data
)

data class Info(
    var description: String,
    var copyright: String,
    var encoding: String
)

data class Values(
    @SerializedName("Time") var time: String,
    @SerializedName("R-index") var rIndex: Int,
    @SerializedName("Geographic latitude") var latitude: Float,
    @SerializedName("Geographic longitude") var longitude: Float,
    @SerializedName("Limit value lower") var lower: Int,
    @SerializedName("Limit value higher") var higher: Int,
    @SerializedName("Probability of auroras") var probability: String,
    @SerializedName("Station") var station: String
)

data class Data(
    @SerializedName("KEV") var kev: Values,
    @SerializedName("KIL") var kil: Values,
    @SerializedName("IVA") var iva: Values,
    @SerializedName("MUO") var muo: Values,
    @SerializedName("PEL") var pel: Values,
    @SerializedName("RAN") var ran: Values,
    @SerializedName("OUJ") var ouj: Values,
    @SerializedName("MEK") var mek: Values,
    @SerializedName("HAN") var han: Values,
    @SerializedName("NUR") var nur: Values,
    @SerializedName("TAR") var tar: Values
)