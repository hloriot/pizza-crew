package com.hloriot.pizzacrew.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hloriot.pizzacrew.R
import com.hloriot.pizzacrew.database.UserDatabase
import com.hloriot.pizzacrew.databinding.FragmentHomeBinding
import com.hloriot.pizzacrew.databinding.FragmentLoginBinding
import com.hloriot.pizzacrew.model.User
import com.hloriot.pizzacrew.ui.home.adapter.PizzaAdapter

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListeners()
        initTextEditListeners()
    }

    private fun initClickListeners() {
        binding.loginCreateAccountButton.setOnClickListener {
            findNavController().navigate(R.id.navigate_create_account_fragment)
        }

        binding.loginGoButton.setOnClickListener {
            val username = binding.loginUsernameInputLayout.editText?.text?.toString()
            val password = binding.loginPasswordInputLayout.editText?.text?.toString()

            if (username.isNullOrEmpty()) {
                binding.loginUsernameInputLayout.error =
                    getString(R.string.login_error_empty_username)

                if (password.isNullOrEmpty()) {
                    binding.loginPasswordInputLayout.error =
                        getString(R.string.login_error_empty_password)
                }

                return@setOnClickListener
            }

            if (password.isNullOrEmpty()) {
                binding.loginPasswordInputLayout.error =
                    getString(R.string.login_error_empty_password)
                return@setOnClickListener
            }

            if (UserDatabase(
                    it.context.getSharedPreferences(
                        UserDatabase.SHARED_PREFERENCES_NAME,
                        Context.MODE_PRIVATE
                    )
                ).hasUser(User.Factory.createUser(username, password))) {
                findNavController().navigate(R.id.navigate_main_activity)
            } else {
                binding.loginUsernameInputLayout.error =
                    getString(R.string.login_error_invalid_credentials)
                binding.loginPasswordInputLayout.error =
                    getString(R.string.login_error_invalid_credentials)
            }

        }
    }

    private fun initTextEditListeners() {
        binding.loginUsernameInputLayout.apply {
            editText?.doOnTextChanged { _, _, _, _-> error = null }
        }
        binding.loginPasswordInputLayout.apply {
            editText?.doOnTextChanged { _, _, _, _-> error = null }
        }
    }
}