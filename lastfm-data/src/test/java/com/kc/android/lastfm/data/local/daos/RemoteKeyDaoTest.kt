/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local.daos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.kc.android.lastfm.data.local.LastFmDb
import com.kc.android.lastfm.data.local.entities.RemoteKeyEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class RemoteKeyDaoTest {
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
     * Test [RemoteKeyDao.insertOrReplace] & [RemoteKeyDao.getByLabel]
     */
    @Test
    fun `test-insert-and-get`() = testScope.runBlockingTest {
        val label = "label"
        val expected = RemoteKeyEntity(label, 5)
        db.remoteKeyDao().insertOrReplace(expected)

        val actual = db.remoteKeyDao().getByLabel(label)
        assertThat(actual).isEqualTo(expected)
    }

    /**
     * Test [RemoteKeyDao.deleteByLabel] deletes [RemoteKeyEntity]
     * when correct label is passed.
     */
    @Test
    fun `test-delete-by-label`() = testScope.runBlockingTest {
        val label = "label"
        val expected = RemoteKeyEntity(label, 5)
        db.remoteKeyDao().insertOrReplace(expected)

        db.remoteKeyDao().deleteByLabel(label)
        val actual = db.remoteKeyDao().getByLabel(label)
        assertThat(actual).isNull()
    }

    /**
     * Test [RemoteKeyDao.deleteByLabel] does not delete [RemoteKeyEntity]
     * when wrong label is passed.
     */
    @Test
    fun `test-no-delete-by-wrong-label`() = testScope.runBlockingTest {
        val label = "label"
        val wrongLabel = "wrong-label"
        val expected = RemoteKeyEntity(label, 5)
        db.remoteKeyDao().insertOrReplace(expected)

        db.remoteKeyDao().deleteByLabel(wrongLabel)
        val actual = db.remoteKeyDao().getByLabel(label)
        assertThat(actual).isEqualTo(expected)
    }
}
