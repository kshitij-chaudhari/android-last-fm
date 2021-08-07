/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local.daos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.kc.android.lastfm.data.fake.FakeAlbumEntities
import com.kc.android.lastfm.data.local.LastFmDb
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 * Annotated with [HiltAndroidTest] to inject module [com.kc.android.lastfm.data.di.TestDBModule].
 * Alternatively, we can annotate with [UninstallModules] to selectively uninstall a specific module.
 */
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class AlbumDaoTest {
    @get:Rule(order = 0) val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1) val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject lateinit var db: LastFmDb

    private val testScope = TestCoroutineScope()

    @Before
    fun setUp() = hiltRule.inject()

    @After
    fun tearDown() {
        testScope.cleanupTestCoroutines()
        db.clearAllTables()
    }

    /**
     * Test [AlbumDao.insertAll] & [AlbumDao.getAll]
     */
    @Test
    fun `test-insert-all-and-get-all`() = testScope.runBlockingTest {
        db.albumDao().insertAll(FakeAlbumEntities.believe(0))

        val actual = db.albumDao().getAll().first()
        assertThat(actual).containsExactly(FakeAlbumEntities.believe(1))
    }

    /**
     * * Test [AlbumDao.deleteAll] clears album table.
     */
    @Test
    fun `test-delete-all`() = testScope.runBlockingTest {
        db.albumDao().insertAll(FakeAlbumEntities.believe(0))

        db.albumDao().deleteAll()
        assertThat(db.albumDao().getAll().first()).isEmpty()
    }

    /**
     * Test [AlbumDao.get] returns expected [com.kc.android.lastfm.data.local.entities.AlbumEntity]
     */
    @Test
    fun `test-get-returns-expected-entity`() = testScope.runBlockingTest {
        db.albumDao().insertAll(FakeAlbumEntities.believe(0))

        val actual = db.albumDao().get(FakeAlbumEntities.believe(1).id).first()
        assertThat(actual).isEqualTo(FakeAlbumEntities.believe(1))
    }
}
