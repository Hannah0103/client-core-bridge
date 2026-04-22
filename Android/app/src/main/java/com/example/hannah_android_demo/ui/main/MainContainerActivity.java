package com.example.hannah_android_demo.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.hannah_android_demo.R;
import com.example.hannah_android_demo.ui.factory.SubtabFragmentFactory;
import com.example.hannah_data_sdk.model.TabPage;
import com.example.hannah_data_sdk.service.PageDataService;
import com.example.hannah_data_sdk.service.PageDataServiceFactory;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;

public class MainContainerActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private List<TabPage> tabPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        setupContent();
    }

    private void setupContent() {
        // UI layer independent from JNI details.
        PageDataService pageDataService = PageDataServiceFactory.create(true);
        tabPages = pageDataService.getTabPages();

        List<Fragment> fragments = SubtabFragmentFactory.createPages(tabPages);
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(this, fragments);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabPages.get(position).getTitle());
            }
        }).attach();
    }
}
