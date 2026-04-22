package com.example.hannah_data_sdk.service;

import com.example.hannah_data_sdk.model.TabPage;
import java.util.ArrayList;
import java.util.List;

public class MockPageDataService implements PageDataService {
    @Override
    public List<TabPage> getTabPages() {
        List<TabPage> pages = new ArrayList<>();
        pages.add(new TabPage("recommend", "推荐", "推荐页面"));
        pages.add(new TabPage("hot", "热点", "热点页面"));
        pages.add(new TabPage("video", "视频", "视频页面"));
        pages.add(new TabPage("tech", "科技", "科技页面"));
        pages.add(new TabPage("sports", "体育", "体育页面"));
        return pages;
    }
}
