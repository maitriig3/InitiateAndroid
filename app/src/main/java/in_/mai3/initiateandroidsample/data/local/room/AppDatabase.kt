package in_.mai3.initiateandroidsample.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import in_.mai3.initiateandroidsample.data.local.room.dao.SampleDao
import in_.mai3.initiateandroidsample.data.local.room.entity.SampleEntity

@Database(entities = [SampleEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao

}