package learning.com.latihan_02

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = intent.extras
        val pizza = data.getParcelable<Pizza>("pizza")

        textView_stu.text = pizza.nama + " " + pizza.harga + " " + pizza.topping

        button_buat.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        })
    }
}
