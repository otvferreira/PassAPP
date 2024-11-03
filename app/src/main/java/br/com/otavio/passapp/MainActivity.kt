package br.com.otavio.passapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvGeneratedPassword: TextView = findViewById(R.id.tvGeneratedPassword)
        val seekBarLength: SeekBar = findViewById(R.id.seekBarLength)
        val tvPasswordLength: TextView = findViewById(R.id.tvPasswordLength)
        val cbUppercase: CheckBox = findViewById(R.id.cbUppercase)
        val cbLowercase: CheckBox = findViewById(R.id.cbLowercase)
        val cbNumbers: CheckBox = findViewById(R.id.cbNumbers)
        val cbExcludeSimilar: CheckBox = findViewById(R.id.cbExcludeSimilar)
        val btnRegenerate: Button = findViewById(R.id.btnRegenerate)
        val btnCopy: Button = findViewById(R.id.btnCopy)

        // Configura o comprimento da senha com a barra deslizante
        seekBarLength.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tvPasswordLength.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // Gera a senha inicialmente e ao clicar no botão "Regenerar"
        btnRegenerate.setOnClickListener {
            tvGeneratedPassword.text = generatePassword(
                length = seekBarLength.progress,
                includeUppercase = cbUppercase.isChecked,
                includeLowercase = cbLowercase.isChecked,
                includeNumbers = cbNumbers.isChecked,
                excludeSimilar = cbExcludeSimilar.isChecked
            )
        }

        // Copia a senha gerada para a área de transferência
        btnCopy.setOnClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
            val clip = android.content.ClipData.newPlainText("Generated Password", tvGeneratedPassword.text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Senha copiada", Toast.LENGTH_SHORT).show()
        }
    }

    // Função para gerar senha
    private fun generatePassword(
        length: Int,
        includeUppercase: Boolean,
        includeLowercase: Boolean,
        includeNumbers: Boolean,
        excludeSimilar: Boolean
    ): String {
        val uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val lowercaseChars = "abcdefghijklmnopqrstuvwxyz"
        val numbers = "0123456789"
        val similarChars = "0O1l"

        var chars = ""
        if (includeUppercase) chars += uppercaseChars
        if (includeLowercase) chars += lowercaseChars
        if (includeNumbers) chars += numbers
        if (excludeSimilar) chars = chars.filter { it !in similarChars }

        return (1..length)
            .map { chars.random() }
            .joinToString("")
    }
}

