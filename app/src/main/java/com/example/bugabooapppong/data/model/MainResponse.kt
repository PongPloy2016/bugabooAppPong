package com.example.bugabooapppong.data.model

import com.google.gson.annotations.SerializedName

data class MainResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DramasItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("new_episode")
	val newEpisode: String? = null
)

data class AcctionItem(

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class IconsItem(

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class BannerItem(

	@field:SerializedName("acction")
	val acction: List<AcctionItem?>? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("rate")
	val rate: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class LayoutItem(

	@field:SerializedName("actor")
	val actor: List<ActorItem?>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("dramas")
	val dramas: List<DramasItem?>? = null,

	@field:SerializedName("privilege")
	val privilege: Privilege? = null,

	@field:SerializedName("banner")
	val banner: List<BannerItem?>? = null
)

data class ActorItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class Privilege(

	@field:SerializedName("sub_title")
	val subTitle: String? = null,

	@field:SerializedName("action")
	val action: List<ActionItem?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("icons")
	val icons: List<IconsItem?>? = null
)

data class ActionItem(

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class LogoItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Data(

	@field:SerializedName("layout")
	val layout: List<LayoutItem?>? = null,

	@field:SerializedName("logo")
	val logo: List<LogoItem?>? = null
)
