import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.ex2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val textViewEmptyOrBlank = findViewById<TextView>(R.id.textView)
        val textViewAcronym = findViewById<TextView>(R.id.textView2)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val inputString = editText.text.toString()

            // Check if input string is empty or blank
            if (inputString.isEmptyOrBlank()) {
                textViewEmptyOrBlank.text = "The input string is empty or blank."
            } else {
                textViewEmptyOrBlank.text = "The input string is not empty or blank."
            }

            // Get acronym of input string
            val acronym = inputString.acronym()
            textViewAcronym.text = "The acronym of the input string is $acronym."
        }
    }
}

// Extension function to check if string is empty or blank
fun String.isEmptyOrBlank(): Boolean {
    return this.trim().isEmpty()
}

// Extension function to get acronym of string
fun String.acronym(): String {
    return this.split("\\s+".toRegex())
        .joinToString("") { it.first().toUpperCase().toString() }
}
