package io.mgba.main.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.mgba.main.fragments.FavouritesFragment
import io.mgba.main.fragments.GameFragment
import io.mgba.mgba.Companion.printLog
import io.mgba.utilities.Constants.ARG_PLATFORM
import io.mgba.utilities.Constants.PLATFORM_FAVS
import io.mgba.utilities.Constants.PLATFORM_GBA
import io.mgba.utilities.Constants.PLATFORM_GBC

class TabViewPager(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {


    private val platforms = intArrayOf(PLATFORM_FAVS, PLATFORM_GBA, PLATFORM_GBC)

    init {
        printLog(TAG, "CTOR")
    }

    override fun getItem(position: Int): Fragment {
        val args = Bundle()
        args.putInt(ARG_PLATFORM, platforms[position])

        val fragment = if (position == 0) FavouritesFragment() else GameFragment()
        fragment.arguments = args
        return fragment

    }

    override fun getCount(): Int {
        return platforms.size
    }

    companion object {
        private val TAG = "mgba:TabPager"
    }
}
