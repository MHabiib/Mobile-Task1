package learning.com.latihan_02

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pizza (val nama:String, val harga: String, val topping: String) : Parcelable
