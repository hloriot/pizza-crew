package com.hloriot.pizzacrew.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hloriot.pizzacrew.R
import com.hloriot.pizzacrew.databinding.FragmentLoginBinding
import com.hloriot.pizzacrew.model.User

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels {
        LoginViewModel.Factory(requireContext())
    }
    private lateinit var binding: FragmentLoginBinding
    private var allowAdminCredentials = false

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
        hideAdminCredentials()
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

            if (allowAdminCredentials &&
                username.equals("admin", true) &&
                password.equals("admin", true)
            ) {
                findNavController().navigate(R.id.navigate_main_activity)
                return@setOnClickListener
            }

            viewModel
                .hasUser(User.Factory.createUser(username, password))
                .doOnSubscribe {
                    showLoadingIndicator()
                }
                .subscribe { hasUser ->
                    hideLoadingIndicator()
                    if (hasUser) {
                        findNavController().navigate(R.id.navigate_main_activity)
                    } else {
                        binding.loginUsernameInputLayout.error =
                            getString(R.string.login_error_invalid_credentials)
                        binding.loginPasswordInputLayout.error =
                            getString(R.string.login_error_invalid_credentials)
                    }
                }

        }
    }

    private fun showLoadingIndicator() {
        binding.loginGoButton.visibility = View.INVISIBLE
        binding.loginUsernameInputLayout.isEnabled = false
        binding.loginPasswordInputLayout.isEnabled = false
        binding.loginCreateAccountButton.isEnabled = false
        binding.loginProgressIndicator.show()
    }

    private fun hideLoadingIndicator() {
        binding.loginGoButton.visibility = View.VISIBLE
        binding.loginUsernameInputLayout.isEnabled = true
        binding.loginPasswordInputLayout.isEnabled = true
        binding.loginCreateAccountButton.isEnabled = true
        binding.loginProgressIndicator.hide()
    }

    private fun initTextEditListeners() {
        binding.loginUsernameInputLayout.apply {
            editText?.doOnTextChanged { _, _, _, _ -> error = null }
        }
        binding.loginPasswordInputLayout.apply {
            editText?.doOnTextChanged { _, _, _, _ -> error = null }
        }
    }

    private fun hideAdminCredentials() {
        allowAdminCredentials = try {
            User.Factory.createUser("username", "password")
            false
        } catch (_: Error) {
            true
        } catch (_: Exception) {
            true
        }
    }
}