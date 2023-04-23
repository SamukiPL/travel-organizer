package me.samuki.core.data.local

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import me.samuki.core.database.StageQueries
import me.samuki.core.database.entity.StorageStage
import me.samuki.core.model.Id
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

    fun addNextStageIdToLastStageInJourney(nextStageId: Id, journeyId: Id) {
        stageQueries.transaction {
            stageQueries.updateNextStageIdInLastStageOfJourney(nextStageId, journeyId)
        }
    }

    fun getStagesForJourney(journeyId: Id): Flow<List<StorageStage>> =
        stageQueries.selectAllForJourney(journeyId)
            .asFlow()
            .mapToList()

    fun deleteStage(stageId: Id) {
        stageQueries.deleteStage(stageId)
    }

    fun changeStageOrder(reorderedStageId: Id, newParentStageId: Id) {
        stageQueries.transaction {
            stageQueries.updateNextStageIdInPredecessorFromSuccessor(reorderedStageId)
            stageQueries.updateNextStageIdFromSuccessor(newParentStageId, reorderedStageId)
            stageQueries.updateSuccessorId(reorderedStageId, newParentStageId)
        }
    }
}
