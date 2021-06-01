package ru.magizoo.magizoo.data.action

import io.reactivex.Single
import ru.magizoo.magizoo.data.NetworkApi
import ru.magizoo.magizoo.data.model.Action
import javax.inject.Inject

class ActionRepositoryImp @Inject constructor(
    private val api: NetworkApi
): ActionRepository {

    companion object {
        private const val DISCOUNT_TYPE_OTHER = "other"
        private const val DISCOUNT_TYPE_WEEK = "week"
    }

    override fun getActionsOfWeek(): Single<List<Action>> {
        return api.getActions(DISCOUNT_TYPE_WEEK)
            .flatMap {
                if (it.result.isNotEmpty()) {
                    Single.just(it.result)
                } else {
                    Single.error(it.errors[0])
                }
            }
    }

    override fun getActions(): Single<List<Action>> {
        return api.getActions(DISCOUNT_TYPE_OTHER)
            .flatMap {
                if (it.result.isNotEmpty()) {
                    Single.just(it.result)
                } else {
                    Single.error(it.errors[0])
                }
            }
    }

}