package in_.mai3.initiateandroidsample.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import in_.mai3.initiateandroidsample.data.local.room.entity.SampleEntity

@Dao
interface SampleDao {

    @Insert
    suspend fun insert(sampleEntity: SampleEntity)

    @Query("select * from sample")
    suspend fun get(): List<SampleEntity>


}