package ru.magizoo.core.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes layout: Int): Fragment(layout) {
    open val isVisibleBottomNavigationBar = false

}