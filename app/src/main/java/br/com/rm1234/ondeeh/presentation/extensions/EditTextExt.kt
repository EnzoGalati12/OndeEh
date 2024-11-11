package br.com.rm1234.ondeeh.presentation.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.addCepMask() {
    this.addTextChangedListener(object : TextWatcher {
        private var isUpdating: Boolean = false
        private val mask = "#####-###"

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (isUpdating) {
                isUpdating = false
                return
            }

            val unmasked = s?.replace(Regex("[^0-9]"), "") ?: ""
            val maskedBuilder = StringBuilder()


            var i = 0
            for (char in mask) {
                if (char != '#') {
                    maskedBuilder.append(char)
                    continue
                }
                if (i >= unmasked.length) break
                maskedBuilder.append(unmasked[i])
                i++
            }

            isUpdating = true
            this@addCepMask.setText(maskedBuilder.toString())
            this@addCepMask.setSelection(maskedBuilder.length)
        }

        override fun afterTextChanged(s: Editable?) {}
    })
}
