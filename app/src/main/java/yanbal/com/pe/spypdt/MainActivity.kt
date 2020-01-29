package yanbal.com.pe.spypdt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import yanbal.com.pe.spypdt.R
import yanbal.com.pe.spypdt.utils.LoadingState
import yanbal.com.pe.spypdt.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {

    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel.data.observe(this, Observer {
            // Todo: Populate the recyclerView here
            it.forEach { githubUser ->
                Toast.makeText(baseContext, githubUser.login, Toast.LENGTH_SHORT).show()
            }
        })

        userViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
                LoadingState.Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
