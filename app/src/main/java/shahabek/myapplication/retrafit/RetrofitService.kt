package shahabek.myapplication.retrafit

import retrofit2.Call
import retrofit2.http.GET
import shahabek.myapplication.models.MyTodoGetResponse

interface RetrofitService {

    @GET("plan")
    fun getAllTodo(): Call<List<MyTodoGetResponse>>

}