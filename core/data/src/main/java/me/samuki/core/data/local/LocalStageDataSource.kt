package me.samuki.core.data.local

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import me.samuki.core.database.StageQueries
import me.samuki.core.database.entity.StorageStage
import javax.inject.Inject

class LocalStageDataSource @Inject constructor(
    private val stageQueries: StageQueries
) {
    fun saveStages(vararg stages: StorageStage) {
        stageQueries.transaction {
            stages.forEach {
                stageQueries.upsertStage(it)
            }
        }
    }

    fun getStagesForJourney(journeyId: String): Flow<List<StorageStage>> =
        stageQueries.selectAllForJourney(journeyId)
            .asFlow()
            .mapToList()

    fun deleteStage(stageId: String) {
        stageQueries.deleteStage(stageId)
    }
}
