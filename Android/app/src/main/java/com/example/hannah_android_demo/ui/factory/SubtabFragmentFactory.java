package com.example.hannah_android_demo.ui.factory;

import androidx.fragment.app.Fragment;
import com.example.hannah_android_demo.ui.subtab.SubtabFragment;
import com.example.hannah_data_sdk.model.TabPage;
import java.util.ArrayList;
import java.util.List;

public final class SubtabFragmentFactory {
    private SubtabFragmentFactory() {
    }

    public static List<Fragment> createPages(List<TabPage> tabPages) {
        List<Fragment> fragments = new ArrayList<>();
        for (TabPage tabPage : tabPages) {
            fragments.add(SubtabFragment.newInstance(tabPage.getTitle(), tabPage.getContent()));
        }
        return fragments;
    }
}
