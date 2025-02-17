package com.autobot.watchparty.dagger

import android.app.Application
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.autobot.watchparty.database.repsitories.MovieRepository
import com.autobot.watchparty.database.repsitories.PlayerRepository
import com.autobot.watchparty.exoplayer.MetaDataReader
import com.autobot.watchparty.exoplayer.MetaDataReaderImpl
import com.autobot.watchparty.database.repsitories.RoomRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object VideoPlayerModule {

    @Provides
    @ViewModelScoped
    fun provideVideoPlayer(app: Application): Player {
        return ExoPlayer.Builder(app)
            .build()
    }

    @Provides
    @ViewModelScoped
    fun provideMetaDataReader(app: Application): MetaDataReader {
        return MetaDataReaderImpl(app)
    }
    @Provides
    @ViewModelScoped
    fun provideRoomRepository(): RoomRepository {
        return RoomRepository()
    }
    @Provides
    @ViewModelScoped
    fun provideMovieRepository(): MovieRepository {
        return MovieRepository()
    }
    @Provides
    @ViewModelScoped
    fun providePlayerRepository(): PlayerRepository {
        return PlayerRepository()
    }
}