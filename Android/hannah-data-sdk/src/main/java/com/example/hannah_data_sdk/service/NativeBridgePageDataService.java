package com.example.hannah_data_sdk.service;

import com.example.hannah_data_sdk.bridge.NativeDataBridge;
import com.example.hannah_data_sdk.model.TabPage;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NativeBridgePageDataService implements PageDataService {
    private final PageDataService fallbackService;

    public NativeBridgePageDataService() {
        this(new MockPageDataService());
    }

    public NativeBridgePageDataService(PageDataService fallbackService) {
        this.fallbackService = fallbackService;
    }

    @Override
    public List<TabPage> getTabPages() {
        String payload;
        try {
            payload = NativeDataBridge.fetchTabPagesPayload();
        } catch (Throwable error) {
            payload = "";
        }

        if (payload == null || payload.trim().isEmpty()) {
            return fallbackService.getTabPages();
        }

        List<TabPage> pages = parsePayload(payload);
        if (pages.isEmpty()) {
            return fallbackService.getTabPages();
        }
        return pages;
    }

    private List<TabPage> parsePayload(String payload) {
        List<TabPage> pages = new ArrayList<>();
        String[] segments = payload.split(";");
        for (String segment : segments) {
            if (segment == null || segment.trim().isEmpty()) {
                continue;
            }
            String title = null;
            String content = "";
            String[] fields = segment.split("\\|");
            for (String field : fields) {
                String[] pair = field.split(":", 2);
                if (pair.length != 2) {
                    continue;
                }
                String key = pair[0].trim();
                String value = pair[1].trim();
                if ("title".equals(key)) {
                    title = value;
                } else if ("content".equals(key)) {
                    content = value;
                }
            }
            if (title != null && !title.isEmpty()) {
                pages.add(new TabPage(title.toLowerCase(Locale.ROOT), title, content));
            }
        }
        return pages;
    }
}
