package shahabek.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response
import shahabek.myapplication.databinding.ActivityMainBinding
import shahabek.myapplication.models.MyTodoGetResponse
import shahabek.myapplication.retrafit.APIClient
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: shahabek.myapplication.adapter.Adapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APIClient.getRetrofitService().getAllTodo()
            .enqueue(object : retrofit2.Callback<List<MyTodoGetResponse>>{
                override fun onResponse(
                    call: Call<List<MyTodoGetResponse>>,
                    response: Response<List<MyTodoGetResponse>>
                ) {

                    if (response.isSuccessful) {
                        adapter = shahabek.myapplication.adapter.Adapter(response.body()!!)
                        binding.rv.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<List<MyTodoGetResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "internet bilan muammo", Toast.LENGTH_SHORT).show()
                }
            })


    }
}