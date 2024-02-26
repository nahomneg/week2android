import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private val chemicalList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNewChemical = findViewById<EditText>(R.id.editTextNewChemical)
        val buttonAddChemical = findViewById<Button>(R.id.buttonAddChemical)
        val editTextGuess = findViewById<EditText>(R.id.editTextGuess)
        val buttonGuess = findViewById<Button>(R.id.buttonGuess)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonAddChemical.setOnClickListener {
            val newChemical = editTextNewChemical.text.toString().trim()
            if (newChemical.isNotBlank()) {
                if (!chemicalList.contains(newChemical)) {
                    chemicalList.add(newChemical)
                    textViewResult.text = "Chemical '$newChemical' added."
                } else {
                    textViewResult.text = "Chemical '$newChemical' is already available."
                }
                editTextNewChemical.text.clear()
            }
        }

        buttonGuess.setOnClickListener {
            val userGuess = editTextGuess.text.toString().trim()
            if (chemicalList.isEmpty()) {
                textViewResult.text = "Please add chemical names first."
            } else {
                val randomChemical = chemicalList.random()
                if (userGuess.equals(randomChemical, ignoreCase = true)) {
                    textViewResult.text = "Congratulations! You guessed it right. It was $randomChemical."
                } else {
                    textViewResult.text = "Sorry, wrong guess. The correct answer was $randomChemical."
                }
                editTextGuess.text.clear()
            }
        }
    }
}
