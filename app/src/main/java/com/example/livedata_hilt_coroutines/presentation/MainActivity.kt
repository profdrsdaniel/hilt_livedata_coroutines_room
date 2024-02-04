package com.example.livedata_hilt_coroutines.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.livedata_hilt_coroutines.R
import com.example.livedata_hilt_coroutines.commons.result.Result
import com.example.livedata_hilt_coroutines.data.local.entity.toDomain
import com.example.livedata_hilt_coroutines.domain.model.User
import com.example.livedata_hilt_coroutines.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observers()

        // Listener de click
        findViewById<Button>(R.id.button).setOnClickListener {
            val textInput = findViewById<EditText>(R.id.edText).text
            viewModel.insertUser(User(name = textInput.toString()))
            textInput.clear()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.users.observe(this) { listOfUserEntity ->
            val listOfUser = listOfUserEntity.map { user -> user.toDomain() }

            if (listOfUser.isNotEmpty()) {
                Toast.makeText(this, listOfUser.last().name, Toast.LENGTH_LONG).show()
                listOfUser.forEach {
                    println(it.name)
                }
            }
        }
    }

    private fun observers() {
        viewModel.hasBeenInsert.observe(this) { result ->
            when (result) {
                is Result.Loading -> {
                    findViewById<ProgressBar>(R.id.progress).visibility = View.VISIBLE
                }

                is Result.Success -> {
                    findViewById<ProgressBar>(R.id.progress).visibility = View.GONE
//                    Toast.makeText(this, "Inserido com sucesso", Toast.LENGTH_LONG).show()
                }

                is Result.Error -> {
                    findViewById<ProgressBar>(R.id.progress).visibility = View.GONE
                    // O ideal é subir uma tela de erro
                    Toast.makeText(this, "erro ${result.exception}", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}