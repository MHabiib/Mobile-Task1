package learning.com.latihan_02

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    var topping=""

    fun onRadioButtonClicked(view: View) {
        var checked = view as RadioButton
        if (keju == checked)
            topping=keju.text.toString()
        else if(pepperoni==checked)
            topping=pepperoni.text.toString()
        else if(jamur==checked)
            topping=jamur.text.toString()
        else
            topping="Anda tidak memilih topping"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        var nama=txtbox1.text.toString();
        var harga=txtbox2.text.toString();
        var topping=topping;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button_send.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("pizza", Pizza(nama, harga, topping))
            startActivity(intent)
        })


    }
}
