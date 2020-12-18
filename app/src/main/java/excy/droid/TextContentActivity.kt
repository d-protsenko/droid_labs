package excy.droid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class TextContentActivity : AppCompatActivity() {
    private var button: Button? = null
    private var contentText: TextView? = null
    private var contentImage: ImageView? = null
    private var category = 0
    private var position = 0
    private val categories = intArrayOf(
        R.string.Metro_2033,
        R.string.MetroLL,
        R.string.Metro_2033_Redux,
        R.string.Metro_LL_Redux,
        R.string.Metro_Exodus,
        R.string.AboutDev
    )
    private val categoryImages = intArrayOf(
        R.drawable.metro2033,
        R.drawable.metroll,
        R.drawable.metro2033redux,
        R.drawable.metrollredux,
        R.drawable.exodus
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_content)
        button = findViewById<View>(R.id.button) as Button
        contentText = findViewById(R.id.main_text_content)
        contentImage = findViewById(R.id.imageContent)
        receiveIntent()
        button!!.setOnClickListener {
            val intent = Intent(this@TextContentActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun receiveIntent() {
        val i = intent
        if (i != null) {
            category = i.getIntExtra("category", 0)
            position = i.getIntExtra("position", 0)
        }
        when (category) {
            0 -> {
                contentImage!!.foreground = getDrawable(categoryImages[position])
                contentText!!.setText(categories[position])
            }
            1 -> {
                position = 7
                contentImage!!.foreground = getDrawable(categoryImages[position])
                contentText!!.setText(categories[position])
            }
        }
    }
}