package ru.magizoo.magizoo.data.action

import io.reactivex.Single
import ru.magizoo.magizoo.data.model.Action

interface ActionRepository {

    fun getActionsOfWeek(): Single<List<Action>>

    fun getActions(): Single<List<Action>>

}