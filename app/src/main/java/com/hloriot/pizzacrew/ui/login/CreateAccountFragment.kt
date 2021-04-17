package com.hloriot.pizzacrew.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hloriot.pizzacrew.R
import com.hloriot.pizzacrew.database.UserDatabase
import com.hloriot.pizzacrew.databinding.FragmentCreateAccountBinding
import com.hloriot.pizzacrew.model.User

class CreateAccountFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListeners()
        initTextEditListeners()
    }

    private fun initClickListeners() {
        binding.createAccountLoginButton.setOnClickListener {
            findNavController().navigate(R.id.navigate_login_fragment)
        }

        binding.createAccountGoButton.setOnClickListener {
            val username = binding.createAccountUsernameInputLayout.editText?.text?.toString()
            val password = binding.createAccountUsernameInputLayout.editText?.text?.toString()

            if (username.isNullOrEmpty()) {
                binding.createAccountUsernameInputLayout.error =
                    getString(R.string.login_error_empty_username)

                if (password.isNullOrEmpty()) {
                    binding.createAccountPasswordInputLayout.error =
                        getString(R.string.login_error_empty_password)
                }

                return@setOnClickListener
            }

            if (password.isNullOrEmpty()) {
                binding.createAccountPasswordInputLayout.error =
                    getString(R.string.login_error_empty_password)
                return@setOnClickListener
            }

            UserDatabase(
                it.context.getSharedPreferences(
                    UserDatabase.SHARED_PREFERENCES_NAME,
                    Context.MODE_PRIVATE
                )
            ).storeUser(User.Factory.createUser(username, password))

            binding.createAccountUsernameInputLayout.editText?.text = null
            binding.createAccountPasswordInputLayout.editText?.text = null
            Toast.makeText(it.context, R.string.create_account_success_message, Toast.LENGTH_LONG).show()
            findNavController().navigateUp()
        }
    }

    private fun initTextEditListeners() {
        binding.createAccountUsernameInputLayout.apply {
            editText?.doOnTextChanged { _, _, _, _-> error = null }
        }
        binding.createAccountPasswordInputLayout.apply {
            editText?.doOnTextChanged { _, _, _, _-> error = null }
        }
    }
}