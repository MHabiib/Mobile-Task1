package learning.com.tugas_01.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextClock

abstract class MainActivity : AppCompatActivity() {
    internal abstract var jamdigital: TextClock
    internal abstract var tampiljam: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jaml = findViewById<View>(R.id.jam1) as TextClock
        jamdigital = findViewById<View>(R.id.jam2) as TextClock
        jamdigital.setVisibility(View.INVISIBLE)
        tampiljam = findViewById<View>(R.id.btn_tampil) as Button
    }

    fun showTextClock(view: View) {
        jamdigital.setVisibility(View.VISIBLE)
//        jamdigital.visibility = view.VISIBLE
        tampiljam.text = "Menampilkan Jam Digital"
    }

    fun keluar(view: View) {
        finish()
    }
}