package com.example.demo.api


import com.example.demo.bean.ProjectContent
import com.example.demo.model.ProjectTree
import com.example.demo.repository.BasePagingResp
import com.example.demo.repository.BaseResp
import retrofit2.http.*


interface ProjectApi {


    @GET("project/tree/json")
    suspend fun loadProjectTree(): BaseResp<List<ProjectTree>>

    @GET("project/list/{path}/json")
    suspend fun loadContentById(
        @Path("path") path: Int,
        @Query("cid") cid: Int
    ): BaseResp<BasePagingResp<List<ProjectContent>>>
}

