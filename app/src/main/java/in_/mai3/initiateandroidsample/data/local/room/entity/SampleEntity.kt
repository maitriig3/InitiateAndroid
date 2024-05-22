package in_.mai3.initiateandroidsample.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sample")
data class SampleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("sample_data")
    val sampleData: String
)