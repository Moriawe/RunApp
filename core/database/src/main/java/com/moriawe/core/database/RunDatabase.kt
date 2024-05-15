package com.moriawe.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moriawe.core.database.dao.RunDao
import com.moriawe.core.database.dao.RunPendingSyncDao
import com.moriawe.core.database.entity.DeletedRunSyncEntity
import com.moriawe.core.database.entity.RunEntity
import com.moriawe.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
               ],
    version = 1
)
abstract class RunDatabase: RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}