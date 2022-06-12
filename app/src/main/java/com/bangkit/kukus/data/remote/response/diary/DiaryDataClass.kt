package com.bangkit.kukus.data.remote.response.diary

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DiaryDataClass (
    var tujuan_ideal : Int = 0,
    var jeniS_kelamin : Int = 0,
    var ttl : Int = 0,
    var tinggi_badan : Int = 0,
    var berat_badan : Int = 0,
    var tingkat_aktivitas : Int = 0,
    var kecepatan_ideal : Int = 0,

    ) : Parcelable
