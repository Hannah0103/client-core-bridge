#ifndef HANNAH_DATA_CORE_H
#define HANNAH_DATA_CORE_H

#ifdef __cplusplus
extern "C" {
#endif

/**
 * Unified tab payload provider for both Android and iOS bridges.
 * Format:
 * title:推荐|content:推荐页面;title:热点|content:热点页面
 */
const char *hannah_fetch_tab_pages_payload(void);

#ifdef __cplusplus
}
#endif

#endif
