package com.pico.mvvm.timetonic.timetonictest.domain.model.home

data class LastMsg(
    val smid: Int,
    val uuid: String,
    val sstamp: Long,
    val lastCommentId: Int,
    val msgBody: String,
    val msgType: String,
    val msgMethod: String,
    val msgColor: String,
    val nbComments: Int,
    val pid: Int,
    val nbMedias: Int,
    val nbEmailCids: Int,
    val nbDocs: Int,
    val b_c: String,
    val b_o: String,
    val u_c: String,
    val linkedRowId: String?,
    val linkedTabId: String?,
    val linkMessage: String,
    val linkedFieldId: String?,
    val msg: String,
    val del: Boolean,
    val created: Long,
    val lastModified: Long,
    val docs: List<Doc>?
)
