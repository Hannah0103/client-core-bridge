#include "../include/hannah_data_core.h"

const char *hannah_fetch_tab_pages_payload(void) {
    static const char *kPayload =
        "title:推荐|content:推荐页面;"
        "title:热点|content:热点页面;"
        "title:视频|content:视频页面;"
        "title:科技|content:科技页面;"
        "title:体育|content:体育页面";
    return kPayload;
}
